package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.MedecinDao;
import com.mm.app.dao.impl.MedecinDaoImpl;
import com.mm.app.model.Medecin;
import com.mm.app.service.MedecinService;

public class MedecinServiceImpl implements MedecinService{
	
	private EntityManager em;
	private MedecinDao dao;
	
	public MedecinServiceImpl(EntityManager em) {
		this.em = em;
		dao = new MedecinDaoImpl(em);
	}

	public List<Medecin> getMedecins() {
		return dao.getMedecins();
	}

	public Medecin findMedecin(int id) {
		return dao.findMedecin(id);
	}

	public Medecin findMedecinByName(String name) {
		return dao.findMedecinByName(name);
	}

	public List<Medecin> findMedecinsByCriteria(String criteria) {
		return dao.findMedecinsByCriteria(criteria);
	}


}
