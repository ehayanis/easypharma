package com.mm.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:15.940+0000")
@StaticMetamodel(Operator.class)
public class Operator_ {
	public static volatile SingularAttribute<Operator, Integer> id;
	public static volatile SingularAttribute<Operator, String> firstName;
	public static volatile SingularAttribute<Operator, String> lastname;
	public static volatile ListAttribute<Operator, Vente> ventes;
}
