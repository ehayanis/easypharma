package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;


@NamedQuery(name="findProductByReference", query="SELECT p FROM Product p WHERE p.reference = :reference")

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

	//bi-directional many-to-one association to Ordonnance
    @ManyToOne
	@JoinColumn(name="id_ordonnance")
	private Ordonnance ordonnance;

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

	public Ordonnance getOrdonnance() {
		return this.ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}
	
}