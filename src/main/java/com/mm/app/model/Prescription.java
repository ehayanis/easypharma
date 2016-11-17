package com.mm.app.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Prescription implements Serializable{

	private static final long serialVersionUID = -1683906829979686877L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String ref;

	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL)
	private Medecin medecin;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "creation_Date")
	private Date dateCreation;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "version")
	private Date version;
	
	@OneToMany(mappedBy="prescription", cascade=CascadeType.ALL)
	private Collection<PrescriptionProduct> prescriptionProducts;

	public Prescription() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Collection<PrescriptionProduct> getPrescriptionProducts() {
		return prescriptionProducts;
	}

	public void setPrescriptionProducts(Collection<PrescriptionProduct> prescriptionProducts) {
		this.prescriptionProducts = prescriptionProducts;
	}

}
