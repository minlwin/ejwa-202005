package com.jdc.example.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.example.model.entity.Township;

public interface TownshipRepo extends JpaRepository<Township, Integer>{

}
