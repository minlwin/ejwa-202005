package com.jdc.example;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.example.model.entity.Region;
import com.jdc.example.model.service.RegionService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RegionServiceTest {
	
	@Autowired
	private RegionService service;

	@Test
	@Order(1)
	void searchTest() {
		
		List<Region> list = service.search("", null, "South");
		
		for(Region r : list) {
			System.out.println(r.getName());
		}
		
	}
	
	@Test
	@Order(2)
	void findOneByCapitalTest() {
		
		Optional<Region> result = service.findByCapital("pa-an");
		
		result.ifPresent(r -> System.out.println(r.getName()));
		
	}
}
