package com.jdc.job.model.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.job.model.dto.LoginResult;
import com.jdc.job.model.dto.SignUpDto;
import com.jdc.job.model.entity.Candidate;
import com.jdc.job.model.entity.Employer;
import com.jdc.job.model.entity.Member;
import com.jdc.job.model.entity.Member.Role;
import com.jdc.job.model.entity.Profile;
import com.jdc.job.model.repo.MemberRepo;
import com.jdc.job.model.repo.ProfileRepo;

@Service
public class MemberService {

	@Autowired
	private MemberRepo memRepo;
	@Autowired
	private ProfileRepo proRepo;
	@Autowired
	private PasswordEncoder encoder;
	
	@Transactional
	public void signUp(SignUpDto dto) {
		
		Member member = null;
		
		switch (dto.getRole()) {
		case "Admin":
			member = new Member();
			member.setRole(Role.Admin);
			break;
		case "Candidate":
			member = new Candidate();
			member.setRole(Role.Candidate);
			break;
		case "Employer":
			member = new Employer();
			member.setRole(Role.Employer);
			break;

		default:
			break;
		}
		
		if(null == member) {
			// TODO Throw Exception
		}
		
		member.setLogin(dto.getEmail());
		member.setPassword(encoder.encode(dto.getPassword()));
		
		// TODO Check Email
		
		member = memRepo.save(member);
		
		Profile profile = new Profile();
		profile.setMember(member);
		profile.setName(dto.getName());
		
		proRepo.save(profile);
	}

	public Long count() {
		return memRepo.count();
	}

	public void setLoginIfo(final LoginResult result, String name) {
		result.setSuccess(true);
		Optional<Member> optional = memRepo.findById(name);
		optional.ifPresent(data -> {
			result.setName(data.getProfile().getName());
			result.setRole(data.getRole());
		});
	}

}
