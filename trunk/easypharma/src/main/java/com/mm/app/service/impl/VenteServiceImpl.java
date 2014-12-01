package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.AssuranceDao;
import com.mm.app.dao.VenteDao;
import com.mm.app.dao.impl.AssuranceDaoImpl;
import com.mm.app.dao.impl.VenteDaoImpl;
import com.mm.app.model.Assurance;
import com.mm.app.model.Client;
import com.mm.app.model.Medecin;
import com.mm.app.model.Operator;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;
import com.mm.app.service.AssuranceService;
import com.mm.app.service.VenteService;

public class VenteServiceImpl implements VenteService{
	
	private EntityManager em;
	private VenteDao dao;
	
	public VenteServiceImpl(EntityManager em) {
		this.em = em;
		dao = new VenteDaoImpl(em);
	}

	@Override
	public List<Vente> getVentes() {
		return dao.getVentes();
	}

	@Override
	public Vente findVente(int id) {
		return dao.findVente(id);
	}

	@Override
	public Vente addVente(Vente vente) {
		return dao.addVente(vente);
		
	}

	@Override
	public void deleteVente(Vente vente) {
		dao.deleteVente(vente);
		
	}

	@Override
	public void addProduit(Product product) {
		dao.addProduit(product);
	}

	@Override
	public List<VenteProduit> getProduits() {
		return dao.getProduits();
	}

	@Override
	public void addMedecin(Medecin medecin) {
		dao.addMedecin(medecin);
		
	}

	@Override
	public void deleteMedecin(Medecin medecin) {
		dao.deleteMedecin(medecin);
	}

	@Override
	public void addClient(Client client) {
		dao.addClient(client);
	}

	@Override
	public void deleteClient(Client client) {
		dao.deleteClient(client);
	}

	@Override
	public void addOperator(Operator operator) {
		dao.addOperator(operator);
		
	}

}
