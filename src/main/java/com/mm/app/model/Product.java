package com.mm.app.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name="findProductByReference", query="SELECT p FROM Product p WHERE p.reference = :reference"),
	@NamedQuery(name="findVenteProduitByClientProduit", query="SELECT vp FROM Vente v JOIN v.produits vp JOIN vp.product p WHERE v.id = :venteId AND p.id = :produitId"),
	@NamedQuery(name="findProductByCriteria", query="SELECT p FROM Product p WHERE p.designation LIKE :criteria"),
	@NamedQuery(name="findHistoriqueProductForClient", query="SELECT vp FROM Vente v JOIN v.client c JOIN v.produits vp JOIN vp.product p WHERE c.id = :clientId AND p.id = :productId")
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
	
	@Column(name="list_remb")
	private String listRemb;
	private String reglement;
	@Column(name="prix_usine")
	private double prixUsine;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_permeption")
	private Date datePermeption;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private Collection<PrescriptionProduct> prescriptionProducts;
	
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

	public String getListRemb() {
		return listRemb;
	}

	public void setListRemb(String listRemb) {
		this.listRemb = listRemb;
	}

	public String getReglement() {
		return reglement;
	}

	public void setReglement(String reglement) {
		this.reglement = reglement;
	}

	public double getPrixUsine() {
		return prixUsine;
	}

	public void setPrixUsine(double prixUsine) {
		this.prixUsine = prixUsine;
	}

	public Date getDatePermeption() {
		return datePermeption;
	}

	public void setDatePermeption(Date datePermeption) {
		this.datePermeption = datePermeption;
	}

	public Collection<PrescriptionProduct> getPrescriptionProducts() {
		return prescriptionProducts;
	}

	public void setPrescriptionProducts(Collection<PrescriptionProduct> prescriptionProducts) {
		this.prescriptionProducts = prescriptionProducts;
	}
}