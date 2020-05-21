package com.jdc.jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.jpa.fetch.entity.ClassA;
import com.jdc.jpa.fetch.entity.ClassB;

class FetchModeTest {
	
	static EntityManagerFactory EMF;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		EMF = Persistence.createEntityManagerFactory("jpa6-fetch-modes");
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
		a.setName("A");
		a.setContent("Long Contents");
		a.setList(Arrays.asList("A", "B", "C"));
		
		ClassB b = new ClassB();
		b.setData("Data");
		b.setI(10);
		a.setB(b);
		
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		
		assertEquals(1, a.getId());
	}
	
	@Test
	void test2() {
		
		ClassA a = em.find(ClassA.class, 1);
		
		em.detach(a);
		
		String content = a.getContent();
		System.out.println(content);
		a.getList().size();
		
		ClassB b = a.getB();
		System.out.println(b.getData());
		
	}
	
	@Test
	void test3() {
		
		ClassA a1 = em.find(ClassA.class, 1);
		ClassA a2 = em.getReference(ClassA.class, 1);
		
		ClassA a3 = em.find(ClassA.class, 2);
		ClassA a4 = em.getReference(ClassA.class, 2);
		
		em.clear();
		
		a1.getList().size();
		a2.getB();
	}

}
