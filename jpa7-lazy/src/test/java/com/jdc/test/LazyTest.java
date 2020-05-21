package com.jdc.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.lazy.ClassA;
import com.jdc.lazy.ClassB;

class LazyTest {

	static EntityManagerFactory EMF;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa7-lazy");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		EMF.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = EMF.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test1() {

		ClassA a = new ClassA();
		ClassB b = new ClassB();
		
		b.setCount(10);
		b.setName("Data B");
		
		a.setB(b);
		a.setName("Data A");
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
		assertEquals(1, a.getId());
	}
	
	@Test
	void test2() {
		
		ClassA a = em.find(ClassA.class, 1);
		em.detach(a);
		
		ClassB b = a.getB();
		System.out.println(b.getName());
	}
	
	@Test
	void test3() {
		
		ClassA a1 = em.find(ClassA.class, 1);
		ClassA a2 = em.getReference(ClassA.class, 1);
		
		ClassA a3 = em.find(ClassA.class, 2);
		ClassA a4 = em.getReference(ClassA.class, 2);
		
		em.clear();
		
	}	

}
