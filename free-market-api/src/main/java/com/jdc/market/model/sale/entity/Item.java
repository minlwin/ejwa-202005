package com.jdc.market.model.sale.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

import com.jdc.market.model.master.entity.Category;
import com.jdc.market.model.master.entity.Member;
import com.jdc.market.model.master.entity.Township;

import lombok.Data;

@Data
@Entity
public class Item implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	@ManyToOne
	private Category category;
	@ManyToOne
	private Member owner;
	private int price;
	
	private String description;
	
	@ElementCollection
	@MapKeyColumn
	private Map<String, String> properties;
	
	@ElementCollection
	private List<String> tags;
	
	@ManyToMany
	private List<Township> availableTownships;
	
	
}
