package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Medecin;

public interface MedecinService {

	public List<Medecin> getMedecins();
	
	public Medecin findMedecin(int id);

	public Medecin findMedecinByName(String name);

}

