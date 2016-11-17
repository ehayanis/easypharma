package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.PrescriptionDao;
import com.mm.app.dao.impl.PrescriptionDaoImpl;
import com.mm.app.model.Prescription;
import com.mm.app.service.PrescriptionService;

public class PrescriptionServiceImpl implements PrescriptionService{
	private EntityManager em;
	private PrescriptionDao dao;
	
	public PrescriptionServiceImpl(EntityManager em) {
		this.em = em;
		dao = new PrescriptionDaoImpl(em);
	}

	@Override
	public List<Prescription> getPrescriptions() {
		return dao.getPrescriptions();
	}

	@Override
	public Prescription findPrescription(int id) {
		return dao.findPrescription(id);
	}

	@Override
	public Prescription findPrescriptionByReference(String selectedValue) {
		return dao.findPrescriptionByReference(selectedValue);
	}

	@Override
	public List<Prescription> findPrescriptionByCriteria(String criteria1, String criteria2, String criteria3, String criteria4, String criteria5) {
		return dao.findPrescriptionByCriteria(criteria1, criteria2, criteria3, criteria4, criteria5);
	}

}
