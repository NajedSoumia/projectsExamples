package edu.m2i.projetJEE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.m2i.projetJEE.dto.AbonneDTO;
import edu.m2i.projetJEE.dto.EmpruntDTO;
import edu.m2i.projetJEE.dto.OuvrageDTO;
import edu.m2i.projetJEE.entity.Abonne;
import edu.m2i.projetJEE.service.AbonneService;

@RestController
@RequestMapping("/EspaceAbonne")
public class AbonneController {

	@Autowired
	AbonneService abonneService;

	// Récupérer le profil utilisateur*********************************************

	@GetMapping("myProfile/{id}")
	public AbonneDTO getProfil(@PathVariable Integer id) {
		return abonneService.findById(id);
	}

	// Récupérer la liste des profils**********************************************

	@GetMapping("profils")
	public List<AbonneDTO> getAbonneList() {
		return abonneService.findAllAbonne();
	}

	// Récupérer la liste des emprunts pour un abonne*******************************
	@GetMapping("emprunts")
	public List<EmpruntDTO> getEmpruntList() {
		return abonneService.findAllEmprunt();
	}

	// Récupérer la liste des ouvrages existants dans la bibliotheque***************
	@GetMapping("Ouvrages")
	public List<OuvrageDTO> getOuvrageList() {
		return abonneService.findAllOuvrage();
	}

	// Rechercher un ouvrage par son titre******************************************
	@GetMapping("Ouvrages/Titre/{titre}")
	public OuvrageDTO getOuvrageByTitre(@PathVariable String titre) {
		return abonneService.findOuvrageByTitre(titre);
	}

	// Rechercher un ouvrage par auteur********************************************
	@GetMapping("Ouvrages/Auteur/{auteur}")
	public List<OuvrageDTO> getOuvrageByAuteur(@PathVariable String auteur) {
		return abonneService.findOuvrageByAuteur(auteur);
	}

	// Reserver un Ouvrage********************************************
	@PutMapping("Ouvrages/Reserver")
	public String ReserverOuvrage(@RequestBody OuvrageDTO ouvrageDTO) {
		return abonneService.bookOuvrage(ouvrageDTO);
	}

	// Update un Abonne************************************************
	@PutMapping("updateProfil")
	public String UpdateProfil(@RequestBody Abonne abonne) {
		return abonneService.save(abonne);

	}

}