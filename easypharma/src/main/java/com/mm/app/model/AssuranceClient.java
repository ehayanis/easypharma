package com.mm.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: AssuranceClient
 *
 */
@Entity
@Table(name="assurance_client")
public class AssuranceClient implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="date_debut")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column(name="date_fin")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@ManyToOne
	private Client client;
	
	@OneToOne
	private Assurance assurance;
	
	
	private static final long serialVersionUID = 1L;

	public AssuranceClient() {
		super();
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Assurance getAssurance() {
		return assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
   
}
