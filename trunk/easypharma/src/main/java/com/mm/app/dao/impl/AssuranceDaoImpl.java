package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.AssuranceDao;
import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.view.TypeAssurance;

public class AssuranceDaoImpl implements AssuranceDao{
	
	private EntityManager em;
	
	public AssuranceDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Assurance> getAssurances() {
		TypedQuery<Assurance> query = em.createQuery("SELECT c FROM Assurance c", Assurance.class);
		return query.getResultList();
	}

	@Override
	public Assurance findAssurance(int id) {
		return em.find(Assurance.class, id);
	}

	@Override
	public AssuranceClient findAssuranceByCoverCard(String coverCard) {
		AssuranceClient c = (AssuranceClient) em.createNamedQuery("findAssuranceByCoverCard").setParameter("coverCard", coverCard).getSingleResult();
		return c;
	}

	@Override
	public List<Assurance> getAssurancesByCriteria(String criteria, TypeAssurance typeAssurance) {
		//List<Assurance> result = em.createNamedQuery("findAssurancesByCriteria").setParameter("name", "%" + criteria + "%").setParameter("type", typeAssurance).getResultList();
		Object result = em.createNamedQuery("findAssurancesByCriteria").setParameter("name", "%" + criteria + "%").getResultList();
		System.err.println("############# : " + result.getClass().getName());
		return (List<Assurance>) result;
		//return result;
	}
	
	
}
