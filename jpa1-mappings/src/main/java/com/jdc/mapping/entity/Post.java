package com.jdc.mapping.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
@IdClass(PostId.class)
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private LocalDate postDate;
	@Id
	private int serialNumber;
	@Id
	private int accountId;

	private LocalTime postTime;
	private String title;
	@Lob
	private String contents;
}
