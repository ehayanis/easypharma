package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.AssuranceDao;
import com.mm.app.model.Assurance;

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
	public Assurance findAssuranceByCoverCard(String name) {
		Assurance c = (Assurance) em.createNamedQuery("findAssuranceByCoverCard").setParameter("name", name).getSingleResult();
		return c;
	}

	@Override
	public List<Assurance> getAssurancesByCriteria(String criteria) {
		List<Assurance> result = em.createNamedQuery("findAssurancesByCriteria").setParameter("name", criteria).getResultList();
		return result;
	}
	
	
}
