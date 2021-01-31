package fstt.lsi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstt.lsi.DAO.AdminDAO;
import fstt.lsi.DAO.BusDAO;
import fstt.lsi.DAO.ChauffeurDAO;
import fstt.lsi.entities.Admin;
import fstt.lsi.entities.Bus;
import fstt.lsi.entities.Chauffeur;

@Service
public class AdminServices {
	
	@Autowired
	AdminDAO adminDao;
	
	@Autowired
	ChauffeurDAO chauffeurDao;
	
	@Autowired
	BusDAO busDAO;
	
	public Admin login(Admin admin) {
		return adminDao.findByEmailAndPasswordAndRole(admin.getEmail(), admin.getPassword(), "admin");
	}

	public Admin ajouterAdmin(Admin newAdmin) {
		
		if(adminDao.findByEmail(newAdmin.getEmail()) == null) {
			
			adminDao.save(newAdmin);
			
			return newAdmin;
		}
		
		return null;
	}
	
	public Chauffeur ajouterChauffeur(Chauffeur newChauffeur) {
		
		if(chauffeurDao.findByEmail(newChauffeur.getEmail()) == null) {
			
			chauffeurDao.save(newChauffeur);
			
			return newChauffeur;
		}
		
		return null;
	}

	public Chauffeur affectChauffeurToBus(int idChauffeur, int idBus) {
		Optional<Chauffeur> chauffeur = chauffeurDao.findById(idChauffeur);
		
		if(chauffeur != null) {
			Optional<Bus> bus  = busDAO.findById(idBus);
			
			if(bus != null) {
				System.out.println("at this point everything is correct");
				return null;
			}
		}
		return null;
	}

	

}
