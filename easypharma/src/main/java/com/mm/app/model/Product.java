package com.mm.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@NamedQueries({
	@NamedQuery(name="findProductByReference", query="SELECT p FROM Product p WHERE p.reference = :reference"),
	@NamedQuery(name="findVenteProduitByClientProduit", query="SELECT vp FROM Vente v JOIN v.produits vp JOIN vp.product p WHERE v.id = :venteId AND p.id = :produitId")
})

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String designation;

	private double pu;

	private Integer quantity;

	private String reference;

	private Integer thresholdalert;

	@OneToMany(mappedBy="product")
	private List<VenteProduit> venteProduits;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Posologie posologie;
		
    public Product() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPu() {
		return this.pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getThresholdalert() {
		return this.thresholdalert;
	}

	public void setThresholdalert(Integer thresholdalert) {
		this.thresholdalert = thresholdalert;
	}

	public List<VenteProduit> getVenteProduits() {
		return venteProduits;
	}

	public void setVenteProduits(List<VenteProduit> venteProduits) {
		this.venteProduits = venteProduits;
	}

	public Posologie getPosologie() {
		return posologie;
	}

	public void setPosologie(Posologie posologie) {
		this.posologie = posologie;
	}
	
}