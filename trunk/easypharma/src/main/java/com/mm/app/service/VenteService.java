package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Client;
import com.mm.app.model.Medecin;
import com.mm.app.model.Operator;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;


public interface VenteService {

	public List<Vente> getVentes();
	
	public Vente findVente(int id);

	public Vente addVente(Vente vente);
	
	public void deleteVente(Vente vente);
	
	public void addProduit(Product product);
	
	public List<VenteProduit> getProduits();
	
	public void addMedecin(Medecin medecin);
	
	public void deleteMedecin(Medecin medecin);
	
	public void addClient(Client client);
	
	public void deleteClient(Client client);
	
	public void addOperator(Operator operator);

}

