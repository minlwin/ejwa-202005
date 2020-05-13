package com.jdc.mapping.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PostId implements Serializable{

	private static final long serialVersionUID = 1L;

	private LocalDate postDate;
	private int serialNumber;
	private int accountId;
	
}
