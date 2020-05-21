package com.jdc.jpa.fetch.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class ClassA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Basic(optional = true, fetch = FetchType.LAZY)
	@Lob
	private String content;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> list;
	@Basic(fetch = FetchType.LAZY)
	@Embedded
	private ClassB b;
}
