package com.mm.app.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Vente implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="type_vente")
	private String typeVente;
	@Column(name="paiement_carte")
	private float paiementCarte;
	@Column(name="paiement_cheque")
	private float paiementCheque;
	@Column(name="paiement_bvr")
	private float paiementBvr;
	@Column(name="paiement_assurance")
	private float paiementAssurance;
	private String status;
	@ManyToOne
	private Operator operator;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Client client;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Medecin medecin;
	
	@OneToMany(mappedBy="vente", cascade=CascadeType.ALL)
	private Collection<VenteProduit> produits;
	
	
	private static final long serialVersionUID = 1L;

	public Vente() {
		super();
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getTypeVente() {
		return typeVente;
	}

	public void setTypeVente(String typeVente) {
		this.typeVente = typeVente;
	}

	public float getPaiementCarte() {
		return paiementCarte;
	}

	public void setPaiementCarte(float paiementCarte) {
		this.paiementCarte = paiementCarte;
	}

	public float getPaiementCheque() {
		return paiementCheque;
	}

	public void setPaiementCheque(float paiementCheque) {
		this.paiementCheque = paiementCheque;
	}

	public float getPaiementBvr() {
		return paiementBvr;
	}

	public void setPaiementBvr(float paiementBvr) {
		this.paiementBvr = paiementBvr;
	}

	public float getPaiementAssurance() {
		return paiementAssurance;
	}

	public void setPaiementAssurance(float paiementAssurance) {
		this.paiementAssurance = paiementAssurance;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
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

	public Collection<VenteProduit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<VenteProduit> produits) {
		this.produits = produits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}
