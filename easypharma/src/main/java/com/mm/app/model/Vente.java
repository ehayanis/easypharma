package com.mm.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vente
 *
 */
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Medecin medecin;
	
	@OneToMany(mappedBy="vente", cascade=CascadeType.ALL)
	private List<VenteProduit> produits;
	
	
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

	public List<VenteProduit> getProduits() {
		return produits;
	}

	public void setProduits(List<VenteProduit> produits) {
		this.produits = produits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
