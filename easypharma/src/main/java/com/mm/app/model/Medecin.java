package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


@NamedQuery(name="findMedecinByReference", query="SELECT m FROM Medecin m WHERE m.reference = :reference")

@Entity
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String fax;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String nc;

	private String nrcc;

	private String phone;

	private String reference;

	private String speciality;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="medecin")
	private List<Ordonnance> ordonnances;

    public Medecin() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNc() {
		return this.nc;
	}

	public void setNc(String nc) {
		this.nc = nc;
	}

	public String getNrcc() {
		return this.nrcc;
	}

	public void setNrcc(String nrcc) {
		this.nrcc = nrcc;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}
	
}