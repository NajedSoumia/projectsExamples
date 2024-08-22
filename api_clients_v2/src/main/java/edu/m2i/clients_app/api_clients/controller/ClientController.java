package edu.m2i.clients_app.api_clients.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.m2i.clients_app.api_clients.dto.ClientDTO;
import edu.m2i.clients_app.api_clients.entite.Client;

import edu.m2i.clients_app.api_clients.service.ClientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-clients")
public class ClientController {
	@Autowired
	ClientService clientService;

	// Récupérer une liste de clients qui sont dans la BD
	@GetMapping("clients")
	public List<ClientDTO> getClientList() {
		return clientService.findAll();
	}

	// Ajouter un client à la base de données
	@PostMapping("add")
	public void addClient(@Valid @RequestBody ClientDTO request) {
		Client client = new Client();
		client.setNom(request.getNom());
		client.setAdresse(request.getAdresse());
		clientService.save(client);
	}

	// Supprimer un client à partir de son ID
	@DeleteMapping("delete/{id}")
	public void deleteClient(@PathVariable("id") Integer id) {
		clientService.delete(id);
	}

	// MAJ des informations d'un client
	@PutMapping("update_v1")
	public void updateClient(@RequestBody Client client) {
		clientService.save(client);
	}

	@PutMapping("update_v2")
	public void updateClient_v2(@RequestParam("id") Integer id, @RequestParam("nom") String nom,
			@RequestParam("adresse") String adresse) {
		Client client = new Client();
		client.setId(id);
		client.setAdresse(adresse);
		client.setNom(nom);
		clientService.save(client);
	}

	@PutMapping("update_v3/{id}/{nom}/{adresse}")
	public void updateClient_v3(@PathVariable("id") Integer id, @PathVariable("nom") String nom,
			@PathVariable("adresse") String adresse) {
		Client client = new Client();
		client.setId(id);
		client.setAdresse(adresse);
		client.setNom(nom);
		clientService.save(client);
	}
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> erreurs = new HashMap<>();
		e.getBindingResult().getAllErrors()
				.forEach(err -> erreurs.put(((FieldError) err).getField(), err.getDefaultMessage()));
		return erreurs;
	}
}