package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Ordonnance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Temporal( TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

    @Temporal( TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Assurance
    @ManyToOne
	@JoinColumn(name="id_assurance")
	private Assurance assurance;

	//bi-directional many-to-one association to Client
    @ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Medecin
    @ManyToOne
	@JoinColumn(name="id_medecin")
	private Medecin medecin;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="ordonnance")
	private List<Product> products;

    public Ordonnance() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Assurance getAssurance() {
		return this.assurance;
	}

	public void setAssurance(Assurance assurance) {
		this.assurance = assurance;
	}
	
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}