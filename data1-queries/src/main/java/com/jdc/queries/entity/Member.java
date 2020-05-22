package com.jdc.queries.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
@NamedQuery(name = "Member.searchByNameOrEmail", 
	query = "select m from Member m where lower(m.name) like lower(:param) or lower(m.email) like lower(:param)")
@NamedQuery(name = "Member.findByHobby", 
	query = "select m from Member m where :hobby member of m.hobbies")
@NamedQuery(name = "Member.findByFriendName", 
	query = "select m from Member m join m.friends f where f.name = :name")
@NamedQuery(name = "Member.findByState", 
	query = "select m from Member m where m.address.state = :state")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String email;
	private String name;
	private String password;
	private boolean accept;
	private Role role;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Address address;
	
	@ElementCollection
	private List<String> hobbies = new ArrayList<>();
	
	@OneToMany
	private List<Member> friends = new ArrayList<Member>();
	
	
	public enum Role {
		Admin, Member
	}

}
