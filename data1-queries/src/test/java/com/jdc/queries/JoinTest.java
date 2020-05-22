package com.jdc.queries;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.queries.entity.Member;
import com.jdc.queries.repo.MemberRepo;

@SpringBootTest
public class JoinTest {
	
	@Autowired
	private MemberRepo repo;
	
	
	@Test
	void findByHobyTest() {
		
		List<Member> list = repo.findByHobby("Music");
		assertNotNull(list);
		assertEquals(2, list.size());
	}
	
	@Test
	void findByFriendNameTest() {
		List<Member> list = repo.findByFriendName("Admin");
		assertNotNull(list);
		assertEquals(1, list.size());
	}
	
	
	@Test
	void findByStateTest() {
		List<Member> list = repo.findByState("State 1");
		assertNotNull(list);
		assertEquals(1, list.size());
	}

}
