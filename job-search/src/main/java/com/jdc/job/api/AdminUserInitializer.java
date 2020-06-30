package com.jdc.job.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jdc.job.model.entity.Member;
import com.jdc.job.model.entity.Member.Role;
import com.jdc.job.model.entity.Profile;
import com.jdc.job.model.repo.MemberRepo;
import com.jdc.job.model.repo.ProfileRepo;

@Configuration
public class AdminUserInitializer {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private MemberRepo memRepo;
	@Autowired
	private ProfileRepo proRepo;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			if(memRepo.count() == 0) {
				Member member = new Member();
				member.setLogin("admin");
				member.setPassword(encoder.encode("admin"));
				member.setRole(Role.Admin);
				
				memRepo.save(member);
				
				Profile profile = new Profile();
				profile.setMember(member);
				profile.setName("Admin User");
				
				proRepo.save(profile);
			}
		};
	}
}
