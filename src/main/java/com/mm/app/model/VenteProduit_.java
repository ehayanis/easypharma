package com.mm.app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:16.018+0000")
@StaticMetamodel(VenteProduit.class)
public class VenteProduit_ {
	public static volatile SingularAttribute<VenteProduit, Integer> id;
	public static volatile SingularAttribute<VenteProduit, Integer> quantity;
	public static volatile SingularAttribute<VenteProduit, Float> remise;
	public static volatile SingularAttribute<VenteProduit, String> typePaiement;
	public static volatile SingularAttribute<VenteProduit, Date> dateCreation;
	public static volatile SingularAttribute<VenteProduit, Vente> vente;
	public static volatile SingularAttribute<VenteProduit, Product> product;
	public static volatile SingularAttribute<VenteProduit, PosologieSpecifique> specifique;
}
