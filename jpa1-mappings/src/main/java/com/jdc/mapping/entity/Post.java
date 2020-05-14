package com.jdc.mapping.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.MapKeyColumn;

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
	
	@ElementCollection
	private Set<String> tags;
	
	
	@ElementCollection
	@MapKeyColumn(name = "user")
	private Map<String, String> reactions;
	
	@ElementCollection
	private List<Comment> comments;
}
