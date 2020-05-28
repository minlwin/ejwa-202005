package com.jdc.market.model.master.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.market.model.master.entity.Member;

public interface MemberRepo extends JpaRepository<Member, String>{

}
