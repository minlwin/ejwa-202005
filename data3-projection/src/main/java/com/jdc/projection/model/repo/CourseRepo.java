package com.jdc.projection.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.projection.model.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
