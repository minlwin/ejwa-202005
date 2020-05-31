package com.jdc.market.model;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity<?>, ID extends Serializable> extends JpaRepository<T, ID> {

}
