package com.mm.app.dao;

import java.util.List;

import com.mm.app.model.Client;

public interface ClientDao {
	
	public List<Client> getClients();
	
	public Client findClient(int id);

	public Client findClientByReference(String reference);
}
