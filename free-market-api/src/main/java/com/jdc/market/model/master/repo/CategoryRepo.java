package com.jdc.market.model.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.master.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
