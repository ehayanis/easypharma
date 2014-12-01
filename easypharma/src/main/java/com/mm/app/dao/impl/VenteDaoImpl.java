package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.AssuranceDao;
import com.mm.app.dao.VenteDao;
import com.mm.app.model.Assurance;
import com.mm.app.model.Client;
import com.mm.app.model.Medecin;
import com.mm.app.model.Operator;
import com.mm.app.model.Product;
import com.mm.app.model.Vente;
import com.mm.app.model.VenteProduit;

public class VenteDaoImpl implements VenteDao{
	
	private EntityManager em;
	
	public VenteDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Vente> getVentes() {
		TypedQuery<Vente> query = em.createQuery("SELECT v FROM Vente v", Vente.class);
		return query.getResultList();
	}

	@Override
	public Vente findVente(int id) {
		return em.find(Vente.class, id);
	}

	@Override
	public Vente addVente(Vente vente) {
		em.getTransaction().begin();
		em.persist(vente);
		em.getTransaction().commit();
		
		return vente;
	}

	@Override
	public void deleteVente(Vente vente) {
		em.getTransaction().begin();
		em.remove(vente);
		em.getTransaction().commit();
	}

	@Override
	public void addProduit(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VenteProduit> getProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOperator(Operator operator) {
		// TODO Auto-generated method stub
		
	}
	
	
}
