package com.mm.app.model;

import com.mm.app.view.TypeAssurance;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-19T16:21:15.925+0000")
@StaticMetamodel(AssuranceClient.class)
public class AssuranceClient_ {
	public static volatile SingularAttribute<AssuranceClient, Integer> id;
	public static volatile SingularAttribute<AssuranceClient, Date> dateDebut;
	public static volatile SingularAttribute<AssuranceClient, Date> dateFin;
	public static volatile SingularAttribute<AssuranceClient, Client> client;
	public static volatile SingularAttribute<AssuranceClient, Assurance> assurance;
	public static volatile SingularAttribute<AssuranceClient, String> coverCard;
	public static volatile SingularAttribute<AssuranceClient, TypeAssurance> type;
}
