package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.ClientDao;
import com.mm.app.dao.impl.ClientDaoImpl;
import com.mm.app.model.Assurance;
import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;
import com.mm.app.service.ClientService;

public class ClientServiceImpl implements ClientService{
	
	private EntityManager em;
	private ClientDao dao;
	
	public ClientServiceImpl(EntityManager em) {
		this.em = em;
		dao = new ClientDaoImpl(em);
	}

	public List<Client> getClients() {
		return dao.getClients();
	}

	public Client findClient(int id) {
		return dao.findClient(id);
	}

	public Client findClientByReference(String reference) {
		return dao.findClientByReference(reference);
	}

	public List<Client> findClientsByCriteria(String criteria) {
		return dao.findClientsByCriteria(criteria);
	}

	public List<AssuranceClient> getClientAssurances(Client client) {
		return dao.getClientAssurances(client);
	}

	public List<Vente> getClientVentes(Client client) {
		return dao.getClientVentes(client);
	}

}
