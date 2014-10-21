package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.ClientDao;
import com.mm.app.dao.impl.ClientDaoImpl;
import com.mm.app.model.Client;
import com.mm.app.service.ClientService;

public class ClientServiceImpl implements ClientService{
	
	private EntityManager em;
	private ClientDao dao;
	
	public ClientServiceImpl(EntityManager em) {
		this.em = em;
		dao = new ClientDaoImpl(em);
	}

	@Override
	public List<Client> getClients() {
		return dao.getClients();
	}

	@Override
	public Client findClient(int id) {
		return dao.findClient(id);
	}

	@Override
	public Client findClientByReference(String reference) {
		return dao.findClientByReference(reference);
	}

	@Override
	public List<Client> findClientsByCriteria(String criteria) {
		return dao.findClientsByCriteria(criteria);
	}

}
