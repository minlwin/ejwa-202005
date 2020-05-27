package com.jdc.market.model.master.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Embeddable
@Data
public class SecurityInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	@CreatedBy
	private String createUser;
	@LastModifiedBy
	private String updateUser;
	
	@CreatedDate
	private LocalDateTime createTime;
	@LastModifiedDate
	private LocalDateTime updateTime;
	private boolean deleted;

}
