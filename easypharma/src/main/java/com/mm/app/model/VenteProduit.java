package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="vente_produit")
public class VenteProduit implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="quantity_vendu")
	private int quantity;
	private float remise;
	@Column(name="type_paiement")
	private String typePaiement;
	
	@ManyToOne
	private Vente vente;
	
	@ManyToOne
	private Product product;
	
	@OneToOne
	private PosologieSpecifique specifique;
	
	private static final long serialVersionUID = 1L;

	public VenteProduit() {
		super();
	}
	
	public VenteProduit(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRemise() {
		return remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

	public String getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PosologieSpecifique getSpecifique() {
		return specifique;
	}

	public void setSpecifique(PosologieSpecifique specifique) {
		this.specifique = specifique;
	}
	
}
