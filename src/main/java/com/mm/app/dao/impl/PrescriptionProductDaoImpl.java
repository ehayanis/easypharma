package com.mm.app.dao.impl;

import javax.persistence.EntityManager;

import com.mm.app.dao.PrescriptionProductDao;
import com.mm.app.model.PrescriptionProduct;

public class PrescriptionProductDaoImpl implements PrescriptionProductDao{

	private EntityManager em;
	
	public PrescriptionProductDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public PrescriptionProduct addPrescriptionProduct(PrescriptionProduct prescriptionProduct) {
		// TODO Auto-generated method stub
		return null;
	}

}
