package edu.m2i.projetJEE.service.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.m2i.projetJEE.dto.AbonneDTO;
import edu.m2i.projetJEE.dto.EmpruntDTO;
import edu.m2i.projetJEE.dto.OuvrageDTO;
import edu.m2i.projetJEE.entity.Abonne;
import edu.m2i.projetJEE.entity.Emprunt;
import edu.m2i.projetJEE.entity.Ouvrage;
import edu.m2i.projetJEE.repository.AbonneRepository;
import edu.m2i.projetJEE.repository.EmpruntRepository;
import edu.m2i.projetJEE.repository.OuvrageRepository;
import edu.m2i.projetJEE.service.AbonneService;

@Service
public class AbonneServiceImp implements AbonneService {

	@Autowired
	AbonneRepository abonneRepository;

	@Autowired
	OuvrageRepository ouvrageRepository;

	@Autowired
	EmpruntRepository empruntRepository;

	// *************************Liste abonnes*********************************
	@Override
	public List<AbonneDTO> findAllAbonne() {
		List<Abonne> abonnes = abonneRepository.findAll();
		List<AbonneDTO> abonnesDTO = new ArrayList<AbonneDTO>();
		for (Abonne a : abonnes) {
			AbonneDTO abonneDTO = new AbonneDTO();
			abonneDTO.setLogin(a.getLogin());
			abonneDTO.setPassword(a.getPassword());
			abonneDTO.setName(a.getName());
			abonneDTO.setPrenom(a.getName());
			abonneDTO.setAdresse(a.getAdresse());
			abonnesDTO.add(abonneDTO);
		}
		return abonnesDTO;
	}

	// ************************abonne par id**********************************
	@Override
	public AbonneDTO findById(Integer id) {
		Abonne abonne = abonneRepository.getReferenceById(id);
		AbonneDTO abonneDTO = new AbonneDTO();
		abonneDTO.setLogin(abonne.getLogin());
		abonneDTO.setPassword(abonne.getPassword());
		abonneDTO.setName(abonne.getName());
		abonneDTO.setPrenom(abonne.getPrenom());
		abonneDTO.setAdresse(abonne.getAdresse());

		List<Emprunt> emprunts = abonne.getEmprunts();
		List<EmpruntDTO> empruntsDTO = new ArrayList<EmpruntDTO>();
		for (Emprunt e : emprunts) {
			EmpruntDTO empruntDTO = new EmpruntDTO(e.getDateDebut(), e.getDuree(), e.getStatut(),
					e.getAbonne().getName(), e.getOuvrage().getTitre());

			empruntsDTO.add(empruntDTO);
		}
		abonneDTO.setEmprunts(empruntsDTO);

		return abonneDTO;
	}

	// **************************Liste emprunts*********************************
	@Override
	public List<EmpruntDTO> findAllEmprunt() {
		List<Emprunt> emprunts = empruntRepository.findAll();
		List<EmpruntDTO> empruntsDTO = new ArrayList<EmpruntDTO>();
		for (Emprunt e : emprunts) {
			EmpruntDTO empruntDTO = new EmpruntDTO();
			empruntDTO.setDateDebut(e.getDateDebut());
			empruntDTO.setDuree(e.getDuree());
			empruntDTO.setStatut(e.getStatut());
			empruntDTO.setAbonneName(e.getAbonne().getName());
			;
			empruntDTO.setOuvrageTitre(e.getOuvrage().getTitre());
			empruntsDTO.add(empruntDTO);
		}
		return empruntsDTO;
	}

	// ********************************Récupérer la liste des
	// ouvrages*************************

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

	// *******************************Rechercher un ouvrage par son
	// titre************************

	@Override
	public OuvrageDTO findOuvrageByTitre(String titre) {
		List<Ouvrage> ouvrages = ouvrageRepository.findAll();
		Ouvrage findOuvrage = new Ouvrage();
		boolean find = false;
		for (Ouvrage o : ouvrages) {
			if (o.getTitre().equals(titre)) {
				findOuvrage = o;
				find = true;
			}
		}

		if (find == true) {
			OuvrageDTO ouvrageDTO = new OuvrageDTO(findOuvrage.getTitre(), findOuvrage.getAuteur(),
					findOuvrage.getIsbn(), findOuvrage.getNbrExemplaire(), findOuvrage.getCategorie().getType());
			return ouvrageDTO;
		} else {
			OuvrageDTO ouvrageDTO = new OuvrageDTO(null, null, null, null, null);
			return ouvrageDTO;
		}

	}

	// *******************************Rechercher un ouvrage par
	// auteur************************

	@Override
	public List<OuvrageDTO> findOuvrageByAuteur(String auteur) {
		List<Ouvrage> ouvrages = ouvrageRepository.findAll();
		List<OuvrageDTO> ouvragesDTO = new ArrayList<OuvrageDTO>();

		for (Ouvrage o : ouvrages) {
			OuvrageDTO ouvrageDTO = new OuvrageDTO();
			if (o.getAuteur().equals(auteur)) {
				ouvrageDTO.setAuteur(o.getAuteur());
				;
				ouvrageDTO.setIsbn(o.getIsbn());
				ouvrageDTO.setNbrExemplaire(o.getNbrExemplaire());
				ouvrageDTO.setTitre(o.getTitre());
				ouvrageDTO.setTypeCategorie(o.getCategorie().getType());
				ouvragesDTO.add(ouvrageDTO);
			}
		}

		return ouvragesDTO;
	}

	// ***************************Reserver un
	// Ouvrage*******************************************
	//
	@Override
	public String bookOuvrage(OuvrageDTO ouvrageDTO) {

		List<Ouvrage> ouvrages = ouvrageRepository.findAll();
		List<OuvrageDTO> ouvragesDTO = new ArrayList<OuvrageDTO>();
		for (Ouvrage o : ouvrages) {
			ouvrageDTO.setAuteur(o.getAuteur());
			ouvrageDTO.setIsbn(o.getIsbn());
			ouvrageDTO.setNbrExemplaire(o.getNbrExemplaire());
			ouvrageDTO.setTitre(o.getTitre());
			ouvrageDTO.setTypeCategorie(o.getCategorie().getType());
			ouvragesDTO.add(ouvrageDTO);
		}

		boolean exist = false;
		boolean find = true;
		Ouvrage existOuvrage = new Ouvrage();

		for (Ouvrage o : ouvrages) {
			if (isExist(ouvrageDTO.getTitre())) {
				exist = true;
				existOuvrage = o;
				if (isAvailable(existOuvrage)) {
					find = true;
					o.setNbrExemplaire(o.getNbrExemplaire() - 1);
				}
			}
		}
		if (exist == false) {
			return "L'ouvrage recherché n'exite pas dans la bibliothèque";
		} else {
			if (find == false) {
				return "L'ouvrage recherché n'est pas disponible actuellement, Veuillez ressayer plus tard";
			} else {
				return "Votre demande de réservation a bien été prise en compte";
			}
		}

	}

	// ******************************Save
	// abonne*************************************************************
	@Override
	public String save(Abonne abonne) {

		List<Abonne> abonnes = abonneRepository.findAll();
		String reponse = null;
		for (Abonne a : abonnes) {
			if (a.getLogin() == abonne.getLogin()) {

				abonne.setId(a.getId());
				abonne.setAdresse(a.getAdresse());
				abonne.setLogin(a.getLogin());
				abonne.setName(a.getName());
				abonne.setPrenom(a.getPrenom());
				abonne.setPassword(a.getPassword());
				abonne.setEmprunts(a.getEmprunts());
				abonneRepository.save(a);

				reponse = "Votre profil est modifié";

			} else {
				reponse = "Votre login est incorrect";
			}

		}

		return reponse;

	}
	// ******************************is
	// Exist*************************************************************

	public boolean isExist(String titre) {

		List<Ouvrage> ouvrages = ouvrageRepository.findAll();
		boolean test = false;

		for (Ouvrage o : ouvrages) {
			if (o.getTitre().equals(titre)) {
				test = true;

			}
		}
		return test;

	}

	// ******************************is
	// available*************************************************************
	public boolean isAvailable(Ouvrage ouvrage) {

		if (ouvrage.getNbrExemplaire() > 0) {
			return true;
		}
		return false;
	}

}