package com.mm.app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:16.012+0000")
@StaticMetamodel(Vente.class)
public class Vente_ {
	public static volatile SingularAttribute<Vente, Integer> id;
	public static volatile SingularAttribute<Vente, String> typeVente;
	public static volatile SingularAttribute<Vente, Float> paiementCarte;
	public static volatile SingularAttribute<Vente, Float> paiementCheque;
	public static volatile SingularAttribute<Vente, Float> paiementBvr;
	public static volatile SingularAttribute<Vente, Float> paiementAssurance;
	public static volatile SingularAttribute<Vente, String> status;
	public static volatile SingularAttribute<Vente, Operator> operator;
	public static volatile SingularAttribute<Vente, Client> client;
	public static volatile SingularAttribute<Vente, Date> dateCreation;
	public static volatile SingularAttribute<Vente, Medecin> medecin;
	public static volatile CollectionAttribute<Vente, VenteProduit> produits;
}
