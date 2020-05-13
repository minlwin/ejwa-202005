package com.jdc.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class SecurityInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String createUser;
	private String updateUser;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	
}
