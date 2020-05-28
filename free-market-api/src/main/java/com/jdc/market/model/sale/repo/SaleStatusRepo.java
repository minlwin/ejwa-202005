package com.jdc.market.model.sale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.sale.entity.SaleStatus;

public interface SaleStatusRepo extends JpaRepository<SaleStatus, Long>{

}
