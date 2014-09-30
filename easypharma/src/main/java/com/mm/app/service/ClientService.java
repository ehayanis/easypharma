package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Client;


public interface ClientService {

	public List<Client> getClients();
	
	public Client findClient(int id);

	public Client findClientByReference(String reference);

}

