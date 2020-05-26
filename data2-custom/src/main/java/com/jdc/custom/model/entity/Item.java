package com.jdc.custom.model.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

import lombok.Data;

@Data
@Entity
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Category category;
	private String name;
	private String brend;
	private State state;
	private int price;
	
	@ElementCollection
	@MapKeyColumn(name = "property")
	private Map<String, String> descriptions = new LinkedHashMap<>();
	
	
	
	public enum State {
		New, Used
	}

}
