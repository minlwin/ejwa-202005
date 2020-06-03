package com.jdc.jersey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.jersey.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{

}
