package com.jdc.custom.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedQuery(name = "Category.findOneByName", query = "select c from Category c where c.name = :name")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@ManyToOne
	private Category parent;
	
	@OneToMany(
			mappedBy = "parent", 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			orphanRemoval = true
	)
	private List<Category> children = new ArrayList<>();
	
	public void addChild(Category c) {
		c.setParent(this);
		children.add(c);
	}
	
	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}
}
