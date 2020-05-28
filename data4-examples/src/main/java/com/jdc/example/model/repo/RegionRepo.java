package com.jdc.example.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.example.model.entity.Region;

public interface RegionRepo extends JpaRepository<Region, Integer>{

}
