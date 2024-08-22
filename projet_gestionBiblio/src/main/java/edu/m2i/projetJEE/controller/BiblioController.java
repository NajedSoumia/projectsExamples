package edu.m2i.projetJEE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.m2i.projetJEE.dto.EmpruntDTO;
import edu.m2i.projetJEE.dto.OuvrageDTO;
import edu.m2i.projetJEE.entity.Abonne;
import edu.m2i.projetJEE.entity.Categorie;
import edu.m2i.projetJEE.entity.Emprunt;
import edu.m2i.projetJEE.entity.Ouvrage;
import edu.m2i.projetJEE.service.BiblioService;

@RestController
@RequestMapping("/api-biblio")
public class BiblioController {
	@Autowired
	BiblioService biblioService;
	
	// Récupérer une liste des abonnés qui sont dans la BD
	@GetMapping("abonnes")
	public List<Abonne> getAbonnesList() {
		return biblioService.getAbonnes();
	}
	
	// Ajouter un abonné   
	@PostMapping("abonne/add")
	public void addAbonne(@RequestBody Abonne abonne) {
		biblioService.addAbonne(abonne);
	}
	
	// Modifier un abonné
	@PutMapping("abonne/update")
	public void updateAbonne(@RequestBody Abonne abonne) {
		biblioService.updateAbonne(abonne);
	}
	
	// Supprimer un abonné
	@DeleteMapping("abonne/delete/{id}")
	public void deleteAbonne(@PathVariable("id") Integer id) {
		biblioService.deleteAbonne(id);
	}
	
	// Récupérer une liste des catégories qui sont dans la BD
	//////////////////////////////////// AJOUTER UN CategorieDTO!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@GetMapping("categories")
	public List<Categorie> getCategoriesList() {
		return biblioService.getCategories();
	}
	
	// Ajouter une catégorie
	@PostMapping("categorie/add")
	public void addCategorie(@RequestBody Categorie categorie) {
		biblioService.addCategorie(categorie);
	}
	
	// Modifier une catégorie
	@PutMapping("categorie/update")
	public void updateCategorie(@RequestBody Categorie categorie) {
		biblioService.updateCategorie(categorie);
	}
	
	// Supprimer une catégorie
	@DeleteMapping("categorie/delete/{id}")
	public void deleteCategorie(@PathVariable("id") Integer id) {
		biblioService.deleteCategorie(id);
	}
	
	// Récupérer une liste des ouvrages qui sont dans la BD	
	@GetMapping("ouvrages")
	public List<OuvrageDTO> getOuvragesList() {
		return biblioService.findAllOuvrage();
	}
	
	// Ajouter un ouvrage
	@PostMapping("ouvrage/add/{id}")
	public void addOuvrage(@RequestBody OuvrageDTO ouvrageDTO, @PathVariable("id") Integer id) {
		biblioService.addOuvrage(ouvrageDTO, id);
	}
	
	// Modifier un ouvrage
	@PutMapping("ouvrage/update")
	public void updateOuvrage(@RequestBody Ouvrage ouvrage) {
		biblioService.updateOuvrage(ouvrage);
	}
	
	// Récupérer une liste des empreints qui sont dans la BD
	@GetMapping("emprunts")
	public List<EmpruntDTO> getEmpruntsList() {
		
		return biblioService.getEmprunts();
		
	}
	
	//Récupérer un emprunt
	@GetMapping("emprunt/{id}")
	public List<EmpruntDTO> getEmprunt(@PathVariable("id") Integer id) {
		
		return biblioService.getEmprunt(id);
	
	}
	//Verifier qu'un empreint est disponible
	@GetMapping("emprunt/validate")
	public boolean validateEmprunt(@RequestBody Emprunt emprunt) {
		return biblioService.validateEmprunt(emprunt);
	}
	
	
	
	
	
	
}