package edu.m2i.projetJEE.service;

import java.util.List;

import edu.m2i.projetJEE.dto.AbonneDTO;
import edu.m2i.projetJEE.dto.EmpruntDTO;
import edu.m2i.projetJEE.dto.OuvrageDTO;
import edu.m2i.projetJEE.entity.Abonne;

public interface AbonneService {

	AbonneDTO findById(Integer id);

	List<AbonneDTO> findAllAbonne();

	List<EmpruntDTO> findAllEmprunt();

	String save(Abonne abonne);

	List<OuvrageDTO> findAllOuvrage();

	OuvrageDTO findOuvrageByTitre(String titre);

	List<OuvrageDTO> findOuvrageByAuteur(String auteur);

	String bookOuvrage(OuvrageDTO ouvrageDTO);

}
