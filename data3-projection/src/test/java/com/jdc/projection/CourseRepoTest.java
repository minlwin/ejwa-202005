package com.jdc.projection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.projection.model.dto.CourseDTO;
import com.jdc.projection.model.dto.CourseListDTO;
import com.jdc.projection.model.repo.CourseRepo;

@SpringBootTest
class CourseRepoTest {
	
	@Autowired
	private CourseRepo repo;

	@Test
	void test1_findByNameLike() {
		
		List<CourseListDTO> list = repo.findByNameLike("Java%", CourseListDTO.class);
		assertEquals(2, list.size());
		
		List<CourseDTO> list2 = repo.findByNameLike("Spring", CourseDTO.class);
		assertEquals(1, list2.size());
		
	}
	
	@Test
	void test2_findOneByName() {
		
		Optional<CourseDTO> result1 = repo.findOneByName("Spring", CourseDTO.class);
		
		CourseDTO dto1  = result1.orElse(null);
		assertNotNull(dto1);
		assertEquals("3. Spring", dto1.getViewName());
		
	}

}
