package com.jdc.projection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.projection.model.dto.SectionDTO;
import com.jdc.projection.model.repo.SectionRepo;

@SpringBootTest
public class SectionRepoTest {
	
	@Autowired
	private SectionRepo repo;
	
	@Test
	void findOneByCourseNameAndPriorityTest() {
		
		SectionDTO dto1 = repo.findOneByCourseNameAndPriority("Spring", 4);
		
		assertNotNull(dto1);
		assertEquals("AOP", dto1.getName());
		assertEquals("4. AOP", dto1.getViewName());
	}
}
