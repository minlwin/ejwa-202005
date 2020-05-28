package com.jdc.market.model.sale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.sale.entity.Item;

public interface ItemRepo extends JpaRepository<Item, Long>{

}
