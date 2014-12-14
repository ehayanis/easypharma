package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.ClientDao;
import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;

public class ClientDaoImpl implements ClientDao {
	
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

	@Override
	public List<Assurance> getClientAssurances(Client client) {
		List<Assurance> assurances = em.createQuery("SELECT s FROM Client c JOIN c.assuranceClients a JOIN a.assurance s WHERE c.id = :id", Assurance.class).setParameter("id", client.getId()).getResultList();
		return assurances;
	}

	@Override
	public List<Vente> getClientVentes(Client client) {
		List<Vente> ventes = em.createQuery("SELECT v FROM Client c FETCH JOIN c.ventes v WHERE c.id = :id", Vente.class).setParameter("id", client.getId()).getResultList();
		return ventes;
	}
	
	
}
