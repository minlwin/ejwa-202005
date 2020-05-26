package com.jdc.custom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.custom.model.entity.Item;
import com.jdc.custom.model.entity.Item.State;
import com.jdc.custom.model.service.ItemService;

@SpringBootTest
class ItemServiceTest {
	
	@Autowired
	private ItemService service;

	@Test
	void test1_search_with_state() {
		
		List<Item> list1 = service.search(null, null, State.New, 0, 0);
		assertEquals(2, list1.size());
		
		List<Item> list2 = service.search(null, null, State.Used, 0, 0);
		assertEquals(1, list2.size());
		
		List<Item> list3 = service.search(null, null, null, 0, 0);
		assertEquals(3, list3.size());

		List<Item> list4 = service.search(null, "iPhone", State.New, 0, 0);
		assertEquals(1, list4.size());
		
		List<Item> list5 = service.search(null, "iPhone", null, 0, 0);
		assertEquals(2, list5.size());
		
		List<Item> list6 = service.search(null, "iPhone", null, 0, 800_000);
		assertEquals(1, list6.size());
	}

}
