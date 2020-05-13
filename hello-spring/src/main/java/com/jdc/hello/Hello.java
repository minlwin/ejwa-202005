package com.jdc.hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hello {
	
	@Id
	@GeneratedValue
	private int id;
	private String message;

}
