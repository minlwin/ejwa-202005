package com.jdc.market.model.actions.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.market.model.BaseRepository;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.Messages;
import com.jdc.market.model.actions.reppo.MessageRepo;

@Service
public class MessageService extends BaseService<Messages, UUID>{
	
	@Autowired
	private MessageRepo repo;

	@Override
	protected BaseRepository<Messages, UUID> repo() {
		return repo;
	}

}
