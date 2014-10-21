package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({
	@NamedQuery(name="findAssuranceByCoverCard", query="SELECT a FROM Assurance a WHERE a.coverCard = :name"),
	@NamedQuery(name="findAssurancesByCriteria", query="SELECT a FROM Assurance a WHERE a.name LIKE :name")
})

@Entity
public class Assurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean accident;

	private String address;

	private String agence;

	private Boolean aos;

	private Integer assure;

    @Temporal( TemporalType.DATE)
	@Column(name="card_validity")
	private Date cardValidity;

	@Column(name="cover_card")
	private String coverCard;

	private String ean;

	private String name;

	private String npa;

	private String ofas;

	private String phone;

	private String rcc;

    @Temporal( TemporalType.DATE)
	@Column(name="validation_date")
	private Date validationDate;

	@Column(name="validation_number")
	private Integer validationNumber;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="assurance")
	private List<Ordonnance> ordonnances;

	@ManyToMany(mappedBy="assurances")
	private List<Client> clients;
	

	public Assurance() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAccident() {
		return this.accident;
	}

	public void setAccident(Boolean accident) {
		this.accident = accident;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgence() {
		return this.agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public Boolean getAos() {
		return this.aos;
	}

	public void setAos(Boolean aos) {
		this.aos = aos;
	}

	public Integer getAssure() {
		return this.assure;
	}

	public void setAssure(Integer assure) {
		this.assure = assure;
	}

	public Date getCardValidity() {
		return this.cardValidity;
	}

	public void setCardValidity(Date cardValidity) {
		this.cardValidity = cardValidity;
	}

	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getCoverCard() {
		return this.coverCard;
	}

	public void setCoverCard(String coverCard) {
		this.coverCard = coverCard;
	}

	public String getEan() {
		return this.ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpa() {
		return this.npa;
	}

	public void setNpa(String npa) {
		this.npa = npa;
	}

	public String getOfas() {
		return this.ofas;
	}

	public void setOfas(String ofas) {
		this.ofas = ofas;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRcc() {
		return this.rcc;
	}

	public void setRcc(String rcc) {
		this.rcc = rcc;
	}

	public Date getValidationDate() {
		return this.validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

	public Integer getValidationNumber() {
		return this.validationNumber;
	}

	public void setValidationNumber(Integer validationNumber) {
		this.validationNumber = validationNumber;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}
	
}