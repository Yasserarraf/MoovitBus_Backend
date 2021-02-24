package fstt.lsi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.entities.Chauffeur;
import fstt.lsi.service.ChauffeurServices;

@RestController
@RequestMapping(value="/api/chauffeur")
public class ChauffeurController {

	@Autowired
	ChauffeurServices chauffeurServices;
	
	@PostMapping(value="/login")
	public Chauffeur Login(@RequestBody Chauffeur chauffeur){
		return chauffeurServices.login(chauffeur);
	}
}
