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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

enum AssuranceType{
	OBLIGATOIRE, COMPLEMENTAIRE, ACCIDENT
}

@NamedQueries({
	@NamedQuery(name="findClientByReference", query="SELECT c FROM Client c WHERE c.reference = :reference"),
	@NamedQuery(name="findClientByCriteria", query="SELECT c FROM Client c WHERE c.reference LIKE :criteria OR c.firstName LIKE :criteria OR c.lastName LIKE :criteria")
})

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
	
	@Column(name="addr_principal")
	private String addrPrincipal;
	@Column(name="addr_facturation")
	private String addrFacturation;
	@Column(name="addr_livraison")
	private String addrLivraison;
	
	@OneToMany(mappedBy="client", fetch= FetchType.LAZY)
	private List<Vente> ventes;
	
	@OneToMany(mappedBy="client", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	private List<AssuranceClient> assuranceClients;
	
	@OneToMany(mappedBy="client", fetch= FetchType.LAZY)
	private Collection<Prescription> prescriptions;
	
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

	public List<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}

	public List<AssuranceClient> getAssuranceClients() {
		return assuranceClients;
	}

	public void setAssuranceClients(List<AssuranceClient> assuranceClients) {
		this.assuranceClients = assuranceClients;
	}
	
	public String getAddrPrincipal() {
		return addrPrincipal;
	}

	public void setAddrPrincipal(String addrPrincipal) {
		this.addrPrincipal = addrPrincipal;
	}

	public String getAddrFacturation() {
		return addrFacturation;
	}

	public void setAddrFacturation(String addrFacturation) {
		this.addrFacturation = addrFacturation;
	}

	public String getAddrLivraison() {
		return addrLivraison;
	}

	public void setAddrLivraison(String addrLivraison) {
		this.addrLivraison = addrLivraison;
	}

	public Collection<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Collection<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	

}