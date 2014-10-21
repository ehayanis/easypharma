package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.MedecinDao;
import com.mm.app.model.Assurance;
import com.mm.app.model.Medecin;

public class MedecinDaoImpl implements MedecinDao{
	
	private EntityManager em;
	
	public MedecinDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Medecin> getMedecins() {
		TypedQuery<Medecin> query = em.createQuery("SELECT m FROM Medecin m", Medecin.class);
		return query.getResultList();
	}

	@Override
	public Medecin findMedecin(int id) {
		return em.find(Medecin.class, id);
	}

	@Override
	public Medecin findMedecinByName(String name) {
		Medecin m = (Medecin) em.createNamedQuery("findMedecinByName").setParameter("firstName", name).getSingleResult();
		return m;
	}

	@Override
	public List<Medecin> findMedecinsByCriteria(String criteria) {
		List<Medecin> result = em.createNamedQuery("findMedecinByReference").setParameter("reference", criteria).getResultList();
		return result;
	}
	
	
}
