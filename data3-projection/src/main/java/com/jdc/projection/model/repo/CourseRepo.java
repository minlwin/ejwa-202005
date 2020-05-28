package com.jdc.projection.model.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.projection.model.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

	<T> List<T> findByNameLike(String name, Class<T> type);
	
	<T> Optional<T> findOneByName(String name, Class<T> type);

}
