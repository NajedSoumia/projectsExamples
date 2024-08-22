package edu.m2i.clients_app.api_clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.m2i.clients_app.api_clients.entite.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

}
