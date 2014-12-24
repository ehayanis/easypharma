package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.view.TypeAssurance;


public interface AssuranceService {

	public List<Assurance> getAssurances();
	
	public Assurance findAssurance(int id);

	public AssuranceClient findAssuranceByCoverCard(String covercard);
	
	public List<Assurance> getAssurancesByCriteria(String criteria, TypeAssurance typeAssurance);

}

