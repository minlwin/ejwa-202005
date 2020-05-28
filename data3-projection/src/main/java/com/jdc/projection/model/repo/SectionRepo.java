package com.jdc.projection.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.projection.model.dto.SectionDTO;
import com.jdc.projection.model.entity.Section;

public interface SectionRepo extends JpaRepository<Section, Integer>{

	SectionDTO findOneByCourseNameAndPriority(String name, int priority);
}
