package com.mm.app.dao;

import java.util.List;

import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.view.TypeAssurance;

public interface AssuranceDao {
	
	public List<Assurance> getAssurances();
	
	public Assurance findAssurance(int id);

	public AssuranceClient findAssuranceByCoverCard(String coverCard);
	
	public List<Assurance> getAssurancesByCriteria(String criteria, TypeAssurance typeAssurance);
	
}
