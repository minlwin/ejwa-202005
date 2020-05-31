package com.jdc.market.model.actions.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.jdc.market.model.BaseEntity;
import com.jdc.market.model.master.entity.Member;

import lombok.Data;

@Entity
@Data
@Table(name = "ACT_MESSAGES")
public class Messages implements BaseEntity<UUID>{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	private String title;
	private String message;
	
	private Member receiver;
	private Member sender;
	
	private boolean viewed;
	private LocalDateTime sendTime;
	private LocalDateTime readTime;
	
	private Messages reply;

}
