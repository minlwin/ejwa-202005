package com.jdc.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.example.model.entity.Township;
import com.jdc.example.model.service.TownshipService;

@SpringBootTest
public class TownshipServiceTest {

	@Autowired
	private TownshipService service;
	
	@Test
	void test() {
		
		List<Township> list = service.search("Yan", null, null);
		assertEquals(45, list.size());
		
	}
}
