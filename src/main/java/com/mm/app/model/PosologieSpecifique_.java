package com.mm.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:15.948+0000")
@StaticMetamodel(PosologieSpecifique.class)
public class PosologieSpecifique_ {
	public static volatile SingularAttribute<PosologieSpecifique, Integer> id;
	public static volatile SingularAttribute<PosologieSpecifique, Integer> quantity;
	public static volatile SingularAttribute<PosologieSpecifique, Integer> heures;
	public static volatile SingularAttribute<PosologieSpecifique, Boolean> matin;
	public static volatile SingularAttribute<PosologieSpecifique, Boolean> midi;
	public static volatile SingularAttribute<PosologieSpecifique, Boolean> soir;
	public static volatile SingularAttribute<PosologieSpecifique, Boolean> nuit;
	public static volatile SingularAttribute<PosologieSpecifique, String> repas;
	public static volatile SingularAttribute<PosologieSpecifique, String> condition;
	public static volatile SingularAttribute<PosologieSpecifique, Integer> rythme;
	public static volatile SingularAttribute<PosologieSpecifique, Integer> njours;
	public static volatile SingularAttribute<PosologieSpecifique, Integer> dureeTotal;
	public static volatile SingularAttribute<PosologieSpecifique, String> etiquette;
	public static volatile SingularAttribute<PosologieSpecifique, String> avertissement;
}
