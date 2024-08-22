package edu.m2i.projetJEE.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.projetJEE.dto.EmpruntDTO;
import edu.m2i.projetJEE.dto.OuvrageDTO;
import edu.m2i.projetJEE.entity.Abonne;
import edu.m2i.projetJEE.entity.Categorie;
import edu.m2i.projetJEE.entity.Emprunt;
import edu.m2i.projetJEE.entity.Ouvrage;
import edu.m2i.projetJEE.repository.AbonneRepository;
import edu.m2i.projetJEE.repository.CategorieRepository;
import edu.m2i.projetJEE.repository.EmpruntRepository;
import edu.m2i.projetJEE.repository.OuvrageRepository;
import edu.m2i.projetJEE.service.BiblioService;

@Service
public class BiblioServiceImp implements BiblioService {
	
	@Autowired
	AbonneRepository abonneRepository;
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Autowired
	OuvrageRepository ouvrageRepository;
	
	@Autowired
	EmpruntRepository empruntRepository;

	@Override
	public List<Abonne> getAbonnes() {
		
		return abonneRepository.findAll();
		
		
	}

	@Override
	public void addAbonne(Abonne abonne) {
		
		abonneRepository.save(abonne);
		
	}

	@Override
	public void updateAbonne(Abonne abonne) {
		Abonne abonneToUpdate = abonneRepository.findById(abonne.getId()).get();
		if (abonne.getName() != null) {
			abonneToUpdate.setName(abonne.getName());
		}
		if (abonne.getPrenom() != null) {
			abonneToUpdate.setPrenom(abonne.getPrenom());
		}
		if (abonne.getAdresse() != null) {
			abonneToUpdate.setAdresse(abonne.getAdresse());
		}
		if (abonne.getLogin() != null) {
			abonneToUpdate.setLogin(abonne.getLogin());
		}
		if (abonne.getPassword() != null) {
			abonneToUpdate.setPassword(abonne.getPassword());
		}
		abonneRepository.save(abonneToUpdate);
		
	}

	@Override
	public void deleteAbonne(Integer id) {
	    abonneRepository.deleteById(id);
		
	}

	@Override
	public List<Categorie> getCategories() {
		return categorieRepository.findAll();
		
	}

	@Override
	public void addCategorie(Categorie categorie) {
		categorieRepository.save(categorie);
		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Categorie categorieToUpdate = categorieRepository.findById(categorie.getId()).get();
		if (categorie.getType() != null) {
			categorieToUpdate.setType(categorie.getType());
		}
		categorieRepository.save(categorieToUpdate);
		
	}

	@Override
	public void deleteCategorie(Integer id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public List<OuvrageDTO> findAllOuvrage() {
		List<Ouvrage> ouvrages = ouvrageRepository.findAll();
		List<OuvrageDTO> ouvragesDTO = new ArrayList<OuvrageDTO>();
		for (Ouvrage o : ouvrages) {
			OuvrageDTO ouvrageDTO = new OuvrageDTO();
			ouvrageDTO.setAuteur(o.getAuteur());
			ouvrageDTO.setIsbn(o.getIsbn());
			ouvrageDTO.setNbrExemplaire(o.getNbrExemplaire());
			ouvrageDTO.setTitre(o.getTitre());
			ouvrageDTO.setTypeCategorie(o.getCategorie().getType());
			ouvragesDTO.add(ouvrageDTO);
		}
		return ouvragesDTO;
	}

	@Override
	public void addOuvrage(OuvrageDTO ouvrageDTO, Integer id) {
		
		Ouvrage ouvrage = new Ouvrage();
		Categorie categorie = categorieRepository.findById(id).get();
		
		
		ouvrage.setTitre(ouvrageDTO.getTitre());
		ouvrage.setAuteur(ouvrageDTO.getAuteur());
		ouvrage.setIsbn(ouvrageDTO.getIsbn());
		ouvrage.setNbrExemplaire(ouvrageDTO.getNbrExemplaire());
		ouvrage.setCategorie(categorie);
		ouvrage.setEmprunts(null);
		
		System.out.println(ouvrage);
		
		
		
		ouvrageRepository.save(ouvrage);
		
		
	}

	@Override
	public void updateOuvrage(Ouvrage ouvrage) {
		Ouvrage ouvrageToUpdate = ouvrageRepository.findById(ouvrage.getId()).get();
		if (ouvrage.getTitre() != null) {
			ouvrageToUpdate.setTitre(ouvrage.getTitre());
		}
		if (ouvrage.getAuteur() != null) {
			ouvrageToUpdate.setAuteur(ouvrage.getAuteur());
		}
		if (ouvrage.getIsbn() != null) {
			ouvrageToUpdate.setIsbn(ouvrage.getIsbn());
		}
		if (String.valueOf(ouvrage.getNbrExemplaire()) != null) {
			ouvrageToUpdate.setNbrExemplaire(ouvrage.getNbrExemplaire());
		}
		ouvrageRepository.save(ouvrageToUpdate);
	}
	
	@Override
	public List<EmpruntDTO> getEmprunts() {
		
		List<Emprunt> emprunts = empruntRepository.findAll();
		List<EmpruntDTO> empruntsDTO = new ArrayList<EmpruntDTO>();
		for (Emprunt e : emprunts) {
			EmpruntDTO empruntDTO = new EmpruntDTO();
			empruntDTO.setDateDebut(e.getDateDebut());
			empruntDTO.setDuree(e.getDuree());
			empruntDTO.setStatut(e.getStatut());
			empruntDTO.setAbonneName(e.getAbonne().getName());
			
			empruntDTO.setOuvrageTitre(e.getOuvrage().getTitre());
			empruntsDTO.add(empruntDTO);
		}
		return empruntsDTO;
		
	}

	@Override
	public List<EmpruntDTO> getEmprunt(Integer id) {
		
		Abonne abonneById = abonneRepository.getReferenceById(id);
		
		List<Emprunt> emprunts = empruntRepository.findAll();
		List<EmpruntDTO> empruntsDTO = new ArrayList<EmpruntDTO>();
		
		
		for (Emprunt e : emprunts) {
			EmpruntDTO empruntDTO = new EmpruntDTO();
			if (e.getAbonne().getLogin()== abonneById.getLogin()) {
				
			empruntDTO.setDateDebut(e.getDateDebut());
			empruntDTO.setDuree(e.getDuree());
			empruntDTO.setStatut(e.getStatut());
			empruntDTO.setAbonneName(e.getAbonne().getName());
			
			empruntDTO.setOuvrageTitre(e.getOuvrage().getTitre());
			empruntsDTO.add(empruntDTO);
			}
		}
		return empruntsDTO;
	}

	@Override
	public boolean validateEmprunt(Emprunt emprunt) {
		return isExist(emprunt.getOuvrage()) && isAvailable(emprunt.getOuvrage());
	}
	
	public boolean isExist(Ouvrage ouvrage) {

		List<Ouvrage> ouvrages = ouvrageRepository.findAll();
		boolean test = false;

		for (Ouvrage o : ouvrages) {
			if (ouvrage.getTitre().equals(o.getTitre())) {
				test = true;

			}
		}
		return test;

	}

	public boolean isAvailable(Ouvrage ouvrage) {

		if (ouvrage.getNbrExemplaire() > 0) {
			return true;
		}
		return false;
	}

}