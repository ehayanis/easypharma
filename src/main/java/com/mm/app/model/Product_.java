package com.mm.app.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:15.954+0000")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, String> designation;
	public static volatile SingularAttribute<Product, Double> pu;
	public static volatile SingularAttribute<Product, Integer> quantity;
	public static volatile SingularAttribute<Product, String> reference;
	public static volatile SingularAttribute<Product, Integer> thresholdalert;
	public static volatile ListAttribute<Product, VenteProduit> venteProduits;
	public static volatile SingularAttribute<Product, Posologie> posologie;
	public static volatile SingularAttribute<Product, String> listRemb;
	public static volatile SingularAttribute<Product, String> reglement;
	public static volatile SingularAttribute<Product, Double> prixUsine;
	public static volatile SingularAttribute<Product, Date> datePermeption;
}
