package com.mm.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

enum AssuranceType{
	OBLIGATOIRE, COMPLEMENTAIRE, ACCIDENT
}

@NamedQuery(name="findClientByReference", query="SELECT c FROM Client c WHERE c.reference = :reference")

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer age;

	private Integer avs;

    @Temporal( TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	private String email;

	private String fax;

	@Column(name="first_name")
	private String firstName;

	private String fix;

	@Column(name="last_name")
	private String lastName;

	private Integer mpi;

	private String phone;

	private String reference;

	private Boolean sexe;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="client")
	private List<Address> addresses;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="client")
	private List<Ordonnance> ordonnances;
	
	@ManyToMany
	@JoinTable(name="client_assurance")
	private List<Assurance> assurances;
	
    public Client() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAvs() {
		return this.avs;
	}

	public void setAvs(Integer avs) {
		this.avs = avs;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFix() {
		return this.fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getMpi() {
		return this.mpi;
	}

	public void setMpi(Integer mpi) {
		this.mpi = mpi;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Boolean getSexe() {
		return this.sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public List<Assurance> getAssurances() {
		return assurances;
	}

	public void setAssurances(List<Assurance> assurances) {
		this.assurances = assurances;
	}
	
}