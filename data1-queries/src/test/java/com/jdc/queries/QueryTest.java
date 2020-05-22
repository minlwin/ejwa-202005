package com.jdc.queries;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.queries.entity.Member;
import com.jdc.queries.entity.Member.Role;
import com.jdc.queries.repo.MemberRepo;

@SpringBootTest
class QueryTest {
	
	@Autowired
	private MemberRepo repo;

	@Test
	void contextLoads() {
		
		List<Member> members = repo.findAll();
		assertNotNull(members);
		
		assertEquals(2, members.size());
	}
	
	@Test
	void findByEmailTestOK() {
		
		Optional<Member> result = repo.findOneByEmail("admin@gmail.com");
		
		Member member = result.orElse(null);
		
		assertNotNull(member);
		
		assertEquals("Admin", member.getName());
		assertEquals(Role.Admin, member.getRole());
	}

	@Test
	void findByEmailTestNG() {
		
		Optional<Member> result = repo.findOneByEmail("admin@gmail.con");
		
		Member member = result.orElse(null);
		
		assertNull(member);
		
	}
	
	@Test
	void findByRoleTest() {
		List<Member> list = repo.findByRole(Role.Member);
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	
	@Test
	void findByNameLikeAndRoleTestOK() {
		List<Member> list = repo.findByNameLikeAndRole("Me%", Role.Member);
		assertNotNull(list);
		assertEquals(1, list.size());
	}

	@Test
	void findByNameLikeAndRoleTestNG() {
		List<Member> list = repo.findByNameLikeAndRole("Ae%", Role.Admin);
		assertNotNull(list);
		assertEquals(0, list.size());
	}
	
	@Test
	void findByNameLikeIgnoreCaseTestOK() {
		List<Member> list = repo.findByNameLikeIgnoreCase("a%");		
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	
	
	@Test
	void searchNameQueryTest2() {
		List<Member> list = repo.searchByNameOrEmail("%a%");		
		assertNotNull(list);
		assertEquals(2, list.size());
	}

	@Test
	void searchNameQueryTest1() {
		List<Member> list = repo.searchByNameOrEmail("%e%");		
		assertNotNull(list);
		assertEquals(1, list.size());
	}
}
