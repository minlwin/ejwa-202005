package com.jdc.queries.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.queries.entity.Member;
import com.jdc.queries.entity.Member.Role;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	
	Optional<Member> findOneByEmail(String email);
	
	List<Member> findByRole(Role role);
	List<Member> findByNameLikeAndRole(String name, Role role);
	
	List<Member> findByNameLikeIgnoreCase(String name);
	
	List<Member> searchByNameOrEmail(String param);

	List<Member> findByHobby(String hobby);
	List<Member> findByFriendName(String name);
	List<Member> findByState(String state);

}
