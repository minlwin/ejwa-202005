package com.jdc.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.queries.entity.Address;
import com.jdc.queries.entity.Member;
import com.jdc.queries.entity.Member.Role;
import com.jdc.queries.repo.MemberRepo;

@Configuration
public class DataInitializer {
	
	@Autowired
	private MemberRepo repo;
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			
			Member m1 = new Member();
			m1.setEmail("admin@gmail.com");
			m1.setName("Admin");
			m1.setRole(Role.Admin);
			m1.setAccept(true);
			
			Address a1 = new Address();
			a1.setAddress("Address 1");
			a1.setState("State 1");
			a1.setStreet("Street 1");
			a1.setTownship("Township 1");
			m1.setAddress(a1);
			
			m1.getHobbies().add("Music");
			m1.getHobbies().add("IT");
			
			repo.save(m1);
			
			Member m2 = new Member();
			m2.setEmail("member@gmail.com");
			m2.setName("Member");
			m2.setRole(Role.Member);

			Address a2 = new Address();
			a2.setAddress("Address 2");
			a2.setState("State 2");
			a2.setStreet("Street 2");
			a2.setTownship("Township 2");
			m2.setAddress(a2);
			m2.getHobbies().add("Music");
			m2.getHobbies().add("Shopping");
			
			m2.getFriends().add(m1);

			repo.save(m2);
			
		};
	}

}
