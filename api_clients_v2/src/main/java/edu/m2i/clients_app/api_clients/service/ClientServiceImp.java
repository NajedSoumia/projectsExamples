package edu.m2i.clients_app.api_clients.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.clients_app.api_clients.dto.ClientDTO;
import edu.m2i.clients_app.api_clients.entite.Client;
import edu.m2i.clients_app.api_clients.repository.ClientRepository;

@Service
public class ClientServiceImp implements ClientService {
	
	@Autowired
    ClientRepository clientRepository;
	
	@Override
	public ClientDTO save(Client client) {
		client = clientRepository.save(client);
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAdresse(client.getAdresse());
		clientDTO.setNom(client.getNom());
		return clientDTO;
		
	}

	@Override
	public ClientDTO findById(Integer id) {
		Client client = clientRepository.getReferenceById(id);
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setAdresse(client.getAdresse());
		clientDTO.setNom(client.getNom());
		return clientDTO;
	
	}

	@Override
	public List<ClientDTO> findAll() {
		List<Client> clients = clientRepository.findAll();
		List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
		for(Client c : clients) {
			ClientDTO clientDTO = new ClientDTO(c.getNom(),c.getAdresse());
			clientsDTO.add(clientDTO);
		}
		return clientsDTO;
	}

	@Override
	public void delete(Integer id) {
		clientRepository.deleteById(id);

	}

}
