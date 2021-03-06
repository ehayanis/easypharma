package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Prescription;

public interface PrescriptionService {
	
	public List<Prescription> getPrescriptions();

	public Prescription findPrescription(int id);

	public Prescription findPrescriptionByReference(String selectedValue);

	public List<Prescription> findPrescriptionByCriteria(String criteria1, String criteria2, String criteria3, String criteria4, String criteria5);


}
