package com.mm.app.service.impl;

import javax.persistence.EntityManager;

import com.mm.app.dao.PrescriptionProductDao;
import com.mm.app.dao.impl.PrescriptionProductDaoImpl;
import com.mm.app.model.PrescriptionProduct;
import com.mm.app.service.PrescriptionProductService;

public class PrescriptionProductServiceImpl implements PrescriptionProductService{
	private EntityManager em;
	private PrescriptionProductDao dao;
	
	public PrescriptionProductServiceImpl(EntityManager em) {
		this.em = em;
		dao = new PrescriptionProductDaoImpl(em);
	}

	@Override
	public PrescriptionProduct addPrescriptionProduct(PrescriptionProduct prescriptionProduct) {
		return dao.addPrescriptionProduct(prescriptionProduct);
	}


}
