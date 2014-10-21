package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.ClientDao;
import com.mm.app.model.Client;

public class ClientDaoImpl implements ClientDao{
	
	private EntityManager em;
	
	public ClientDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Client> getClients() {
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		return query.getResultList();
	}

	@Override
	public Client findClient(int id) {
		return em.find(Client.class, id);
	}

	@Override
	public Client findClientByReference(String reference) {
		Client c = (Client) em.createNamedQuery("findClientByReference").setParameter("reference", reference).getSingleResult();
		return c;
	}

	@Override
	public List<Client> findClientsByCriteria(String criteria) {
		List<Client> clients = em.createNamedQuery("findClientByReference").setParameter("reference", criteria).getResultList();
		return clients;
	}
	
	
}
