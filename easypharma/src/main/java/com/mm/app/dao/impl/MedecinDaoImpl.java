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

	public List<Medecin> getMedecins() {
		TypedQuery<Medecin> query = em.createQuery("SELECT m FROM Medecin m ORDER BY m.firstName", Medecin.class);
		return query.getResultList();
	}

	public Medecin findMedecin(int id) {
		return em.find(Medecin.class, id);
	}

	public Medecin findMedecinByName(String name) {
		Medecin m = (Medecin) em.createNamedQuery("findMedecinByName").setParameter("firstName", name).getSingleResult();
		return m;
	}

	public List<Medecin> findMedecinsByCriteria(String criteria) {
		List<Medecin> result = em.createNamedQuery("findMedecinByCriteria").setParameter("criteria", criteria).getResultList();
		return result;
	}
	
	
}
