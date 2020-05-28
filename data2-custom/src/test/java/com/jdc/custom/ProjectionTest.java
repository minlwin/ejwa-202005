package com.jdc.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.custom.model.dto.ItemSummary;
import com.jdc.custom.model.dto.ItemWithNameAndPrice;
import com.jdc.custom.model.repo.ItemRepo;

@SpringBootTest
public class ProjectionTest {

	@Autowired
	private ItemRepo repo;
	
	@Test
	public void test1() {
		
		List<ItemWithNameAndPrice> list = repo.findByBrend("iPhone",  ItemWithNameAndPrice.class);
		assertEquals(2, list.size());
	}
	
	@Test
	public void test2() {
		
		List<ItemSummary> list = repo.findByBrend("iPhone", ItemSummary.class);
		assertEquals(2, list.size());
	}	
}
