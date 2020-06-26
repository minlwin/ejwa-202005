package com.jdc.job.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.job.model.BaseRepository;
import com.jdc.job.model.BaseService;
import com.jdc.job.model.JobSearchException;
import com.jdc.job.model.entity.Member;
import com.jdc.job.model.entity.Profile;
import com.jdc.job.model.repo.MemberRepo;
import com.jdc.job.model.repo.ProfileRepo;

@Service
public class ProfileService extends BaseService<Profile, Integer>{

	@Autowired
	private ProfileRepo repo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	protected BaseRepository<Profile, Integer> repo() {
		return repo;
	}

	public Profile save(String login, Profile profile) {
		Member member = memberRepo.findById(login)
				.orElseThrow(() -> new JobSearchException(String.format("There is no Member with Login Id %s!", login)));
		
		profile.setMember(member);
		
		return repo.save(profile);
	}

}
