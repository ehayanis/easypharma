package com.mm.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:15.936+0000")
@StaticMetamodel(Medecin.class)
public class Medecin_ {
	public static volatile SingularAttribute<Medecin, Integer> id;
	public static volatile SingularAttribute<Medecin, String> fax;
	public static volatile SingularAttribute<Medecin, String> firstName;
	public static volatile SingularAttribute<Medecin, String> lastName;
	public static volatile SingularAttribute<Medecin, String> nc;
	public static volatile SingularAttribute<Medecin, String> nrcc;
	public static volatile SingularAttribute<Medecin, String> phone;
	public static volatile SingularAttribute<Medecin, String> email;
	public static volatile SingularAttribute<Medecin, String> reference;
	public static volatile SingularAttribute<Medecin, String> speciality;
	public static volatile SingularAttribute<Medecin, String> address;
	public static volatile ListAttribute<Medecin, Vente> ventes;
}
