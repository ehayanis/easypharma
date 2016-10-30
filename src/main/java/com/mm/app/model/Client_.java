package com.mm.app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:15.930+0000")
@StaticMetamodel(Client.class)
public class Client_ {
	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SingularAttribute<Client, Integer> age;
	public static volatile SingularAttribute<Client, Integer> avs;
	public static volatile SingularAttribute<Client, Date> birthDate;
	public static volatile SingularAttribute<Client, String> email;
	public static volatile SingularAttribute<Client, String> fax;
	public static volatile SingularAttribute<Client, String> firstName;
	public static volatile SingularAttribute<Client, String> fix;
	public static volatile SingularAttribute<Client, String> lastName;
	public static volatile SingularAttribute<Client, Integer> mpi;
	public static volatile SingularAttribute<Client, String> phone;
	public static volatile SingularAttribute<Client, String> reference;
	public static volatile SingularAttribute<Client, Boolean> sexe;
	public static volatile SingularAttribute<Client, String> addrPrincipal;
	public static volatile SingularAttribute<Client, String> addrFacturation;
	public static volatile SingularAttribute<Client, String> addrLivraison;
	public static volatile ListAttribute<Client, Vente> ventes;
	public static volatile ListAttribute<Client, AssuranceClient> assuranceClients;
}
