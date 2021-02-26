package fstt.lsi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstt.lsi.DAO.ChauffeurDAO;
import fstt.lsi.entities.Chauffeur;

@Service
public class ChauffeurServices {

	@Autowired
	ChauffeurDAO chauffeurDao;
	
	public Chauffeur login(Chauffeur chauffeur) {
		if(chauffeur == null) return null;
		
		return chauffeurDao.findByEmailAndPasswordAndRole(chauffeur.getEmail(), chauffeur.getPassword(), "chauffeur");
	}
}
