package com.jdc.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.custom.model.entity.Category;
import com.jdc.custom.model.service.CategoryService;

@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService service;
	
	
	@Test
	public void test_getChildren_c100() {
		List<Category> list = service.getChild("C100");
		assertEquals(8, list.size());
	}

	@Test
	public void test_getChildren_c110() {
		List<Category> list = service.getChild("C110");
		assertEquals(4, list.size());
	}
	
	@Test
	public void test_getChildren_c120() {
		List<Category> list = service.getChild("C120");
		assertEquals(3, list.size());
	}
	
	@Test
	public void test_getChildren_c200() {
		List<Category> list = service.getChild("C200");
		assertEquals(3, list.size());
	}
	
	@Test
	public void test_getChildren_c210() {
		List<Category> list = service.getChild("C210");
		assertEquals(1, list.size());
	}
}
