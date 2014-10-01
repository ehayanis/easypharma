package com.mm.app.dao;

import java.util.List;

import com.mm.app.model.Medecin;

public interface MedecinDao {
	
	public List<Medecin> getMedecins();
	
	public Medecin findMedecin(int id);

	public Medecin findMedecinByName(String name);
}
