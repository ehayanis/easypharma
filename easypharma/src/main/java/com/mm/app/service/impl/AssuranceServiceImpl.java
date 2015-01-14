package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.AssuranceDao;
import com.mm.app.dao.impl.AssuranceDaoImpl;
import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.service.AssuranceService;
import com.mm.app.view.TypeAssurance;

public class AssuranceServiceImpl implements AssuranceService{
	
	private EntityManager em;
	private AssuranceDao dao;
	
	public AssuranceServiceImpl(EntityManager em) {
		this.em = em;
		dao = new AssuranceDaoImpl(em);
	}

	public List<Assurance> getAssurances() {
		return dao.getAssurances();
	}

	public Assurance findAssurance(int id) {
		return dao.findAssurance(id);
	}

	public AssuranceClient findAssuranceByCoverCard(String coverCard) {
		return dao.findAssuranceByCoverCard(coverCard);
	}

	public List<Assurance> getAssurancesByCriteria(String criteria, TypeAssurance typeAssurance) {
		return dao.getAssurancesByCriteria(criteria, typeAssurance);
	}

}
