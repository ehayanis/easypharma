package com.mm.app.dao;

import java.util.List;

import com.mm.app.model.AssuranceClient;
import com.mm.app.model.Client;
import com.mm.app.model.Vente;

public interface ClientDao {
	
	public List<Client> getClients();
	
	public Client findClient(int id);

	public Client findClientByReference(String reference);
	
	public List<Client> findClientsByCriteria(String criteria);
	
	public List<AssuranceClient> getClientAssurances(Client client);
	
	public List<Vente> getClientVentes(Client client);
}
