package com.jdc.projection;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.projection.model.entity.Course;
import com.jdc.projection.model.repo.CourseRepo;

@SpringBootTest
public class FetchModeTest {
	
	@Autowired
	private CourseRepo repo;
	
	@Test
	void test() {
		
		Optional<Course> result = repo.findById(1);
		
		result.ifPresent(c -> {
			
			System.out.println(c.getName());
			
			System.out.println(c.getSections().size());
		});
		
	}

}
