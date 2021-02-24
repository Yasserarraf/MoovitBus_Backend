package fstt.lsi.Controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.entities.Admin;
import fstt.lsi.entities.Chauffeur;


import fstt.lsi.service.AdminServices;



@RestController
@RequestMapping(value="/api/admin")
public class AdminController {
	@Autowired
	AdminServices adminServices;
	
	@GetMapping(value="/AfficherEmploye")
	public List<Chauffeur> AfficherEmploye() {
		return adminServices.AfficherEmploye();
	}

	@PostMapping(value="/login")
	public Admin Login(@RequestBody Admin admin){
		return adminServices.login(admin);
	}
	
	@PostMapping(value="/ajouter/admin")
	public Admin createAdmin(@RequestBody Object object){
		
		Object tokenObject = ((LinkedHashMap) object).get("token");
		
		if(adminServices.login(tokenToAdmin(tokenObject))!= null) {
			
			Object adminObject = ((LinkedHashMap) object).get("new admin");
			
			return adminServices.ajouterAdmin(objectToAdmin(adminObject));
		}
		
		return null;
	}
	
	@PostMapping(value="/ajouter/chauffeur")
	public Chauffeur createChauffeur(@RequestBody Object object){
		
		Object tokenObject = ((LinkedHashMap) object).get("token");
		
		if(adminServices.login(tokenToAdmin(tokenObject))!= null) {
			
			Object chauffeurObject = ((LinkedHashMap) object).get("new chauffeur");
			
			return adminServices.ajouterChauffeur(objectToChauffeur(chauffeurObject));
		}
		
		return null;
	}
	
	@PostMapping(value="/affecter/chauffeur-bus")
	public Chauffeur affectChauffeurToBus(@RequestBody Object object){
		
		Object tokenObject = ((LinkedHashMap) object).get("token");
		
		if(adminServices.login(tokenToAdmin(tokenObject))!= null) {
			int idChauffeur = (int) ((LinkedHashMap) ((LinkedHashMap) object).get("chauffeur")).get("id");
			int idBus = (int) ((LinkedHashMap) ((LinkedHashMap) object).get("bus")).get("id");
			
			return adminServices.affectChauffeurToBus(idChauffeur, idBus);
		}
		return null;
	}
	
	
	
	
	//methods to convert objects for post methods
	
		public static Admin objectToAdmin(Object object) {
			String nom = (String) ((LinkedHashMap) object).get("nom");
			String prenom = (String) ((LinkedHashMap) object).get("prenom");
			String email = (String) ((LinkedHashMap) object).get("email");
			String password = (String) ((LinkedHashMap) object).get("password");
			String numTel = (String) ((LinkedHashMap) object).get("numTel");
			
			Admin admin = new Admin(0, nom, prenom, email, password, numTel, "admin");
			
			return admin;
		}
		
		public static Admin tokenToAdmin(Object object) {
			String email = (String) ((LinkedHashMap) object).get("email");
			String password = (String) ((LinkedHashMap) object).get("password");
			
			Admin admin = new Admin();
			admin.setEmail(email);
			admin.setPassword(password);
			
			return admin;
		}
		
		public static Chauffeur objectToChauffeur(Object object) {
			String nom = (String) ((LinkedHashMap) object).get("nom");
			String prenom = (String) ((LinkedHashMap) object).get("prenom");
			String email = (String) ((LinkedHashMap) object).get("email");
			String password = (String) ((LinkedHashMap) object).get("password");
			String numTel = (String) ((LinkedHashMap) object).get("numTel");
			
			Chauffeur chauffeur = new Chauffeur(0, nom, prenom, email, password, numTel, "chauffeur");
			
			return chauffeur;
		}
}
