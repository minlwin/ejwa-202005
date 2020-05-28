package com.jdc.projection.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.projection.model.entity.Lesson;

public interface LessonRepo extends JpaRepository<Lesson, Integer>{

}
