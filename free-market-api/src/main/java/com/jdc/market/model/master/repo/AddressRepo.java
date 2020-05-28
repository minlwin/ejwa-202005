package com.jdc.market.model.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.master.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
