package com.jdc.market.api.review;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.market.api.BaseApi;
import com.jdc.market.model.BaseService;
import com.jdc.market.model.actions.entity.Messages;
import com.jdc.market.model.actions.service.MessageService;

@RestController
@RequestMapping("act/messages")
public class MessageApi extends BaseApi<Messages, UUID>{

	@Autowired
	private MessageService service;

	@Override
	protected BaseService<Messages, UUID> service() {
		return service;
	}
}
