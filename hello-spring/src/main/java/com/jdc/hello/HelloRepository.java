package com.jdc.hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Integer>{

}
