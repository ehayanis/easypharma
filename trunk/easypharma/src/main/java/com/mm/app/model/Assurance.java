package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the assurance database table.
 * 
 */
@Entity
public class Assurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String agence;

	@Column(name="cover_card")
	private String coverCard;

	private String ean;

	private String name;

	private String npa;

	private String ofas;

	private String phone;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="assurance")
	private List<Ordonnance> ordonnances;

    public Assurance() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgence() {
		return this.agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getCoverCard() {
		return this.coverCard;
	}

	public void setCoverCard(String coverCard) {
		this.coverCard = coverCard;
	}

	public String getEan() {
		return this.ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpa() {
		return this.npa;
	}

	public void setNpa(String npa) {
		this.npa = npa;
	}

	public String getOfas() {
		return this.ofas;
	}

	public void setOfas(String ofas) {
		this.ofas = ofas;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}
	
}