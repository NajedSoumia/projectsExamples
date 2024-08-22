package edu.m2i.clients_app.api_clients.service;

import java.util.List;

import edu.m2i.clients_app.api_clients.dto.ClientDTO;
import edu.m2i.clients_app.api_clients.entite.Client;

public interface ClientService {
	
	ClientDTO save(Client client);
	ClientDTO findById(Integer id);
	List<ClientDTO> findAll();
	void delete(Integer id);

}
