package com.mm.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity

public class Operator implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastname;
	
	@OneToMany(mappedBy="operator")
	private List<Vente> ventes;
	
	private static final long serialVersionUID = 1L;
	
	public Operator() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}
   
}
