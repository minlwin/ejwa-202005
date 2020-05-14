package com.jdc.mapping.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Comment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private LocalDateTime comentTime;
	private String user;
	private String comment;
}
