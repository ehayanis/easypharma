package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.PrescriptionDao;
import com.mm.app.model.Prescription;

public class PrescriptionDaoImpl implements PrescriptionDao{

	private EntityManager em;
	
	public PrescriptionDaoImpl(EntityManager em) {
		this.em = em;
	}
	@Override
	public List<Prescription> getPrescriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription findPrescription(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription findPrescriptionByReference(String selectedValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prescription> findPrescriptionByCriteria(String criteria1, String criteria2, String criteria3, String criteria4, String criteria5) {
		List<Prescription> result = em.createQuery("SELECT pr FROM Prescription pr ORDER BY pr.id", Prescription.class).getResultList();

//		result = new ArrayList<Prescription>();
//		Prescription prescription = new Prescription();
//		prescription.setId(1);
//		prescription.setRef("GGG");
//		prescription.setStartDate(new Date());
//		prescription.setEndDate(new Date());
//		Client client = new Client();
//		client.setFirstName("firstName");
//		prescription.setClient(client);
//		Medecin medecin = new Medecin();
//		medecin.setFirstName("firstName");
//		prescription.setMedecin(medecin);
//		List<PrescriptionProduct> prescriptionProducts = new ArrayList<PrescriptionProduct>();
//		PrescriptionProduct prescriptionProduct = new PrescriptionProduct();
//		prescriptionProduct.setQte(10);
//		prescriptionProducts.add(prescriptionProduct);
//		prescription.setPrescriptionProducts(prescriptionProducts);
//		result.add(prescription);
		return result;
	}

}
