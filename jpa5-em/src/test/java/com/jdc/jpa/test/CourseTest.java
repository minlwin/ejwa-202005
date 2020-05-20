package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.jpa.entity.Course;

class CourseTest {
	
	private EntityManager em;
	private static EntityManagerFactory emf;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa5-em");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test1() {
		
		// begin transaction
		em.getTransaction().begin();
		
		// transient state
		Course c = new Course();
		
		// managed state
		em.persist(c);
		
		assertEquals(1, c.getId());
		
		// detach state
		em.detach(c);
		
		c.setName("Java Basic");
		
		// managed state
		em.merge(c);
		
		
		// commit transaction
		em.getTransaction().commit();
	}
	
	@Test
	void test2() {
		
		// managed state
		Course c = em.find(Course.class, 1);
		assertNotNull(c);
		assertEquals("Java Basic", c.getName());
		
		em.getTransaction().begin();
		c.setFees(180000);
		c.setDuration(3);
		
		// removed state
		em.remove(c);
		
		em.clear();
		
		em.getTransaction().commit();
	}
	
	@Test
	void test3() {
		
		EntityManager em2 = emf.createEntityManager();
		
		Course c1 = em.find(Course.class, 1);
		
		em.getTransaction().begin();
		c1.setFees(180000);
		em.flush();
		Course c2 = em2.find(Course.class, 1);

		em2.getTransaction().begin();
		em2.refresh(c2);
		
		em.getTransaction().commit();
		
		c2.setDuration(3);
		em2.getTransaction().commit();
		
		em2.close();
		
	}

}
