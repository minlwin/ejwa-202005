package com.jdc.market.model.sale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.sale.entity.Sale;

public interface SaleRepo extends JpaRepository<Sale, Long>{

}
