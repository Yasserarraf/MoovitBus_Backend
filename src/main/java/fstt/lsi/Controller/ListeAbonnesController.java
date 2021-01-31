package fstt.lsi.Controller;

import java.util.ArrayList;
import java.util.List;

// toihir

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.DAO.ClientDAO;
import fstt.lsi.DAO.LigneDAO;
import fstt.lsi.entities.Client;
import fstt.lsi.entities.ClientClone;
import fstt.lsi.entities.InscriptionAbonnement;
import fstt.lsi.entities.Ligne;


@RestController
@RequestMapping("api/abonnements")
public class ListeAbonnesController {

	@Autowired
	ClientDAO clientDao;
	@Autowired
	LigneDAO ligneDao;
	
	@GetMapping(value="/clients")
	public List<Client> getAllClientAbonnesClone(){
		return clientDao.findAllByAbonne(1);
	}
	
	@GetMapping(value="/all")
	public List<ClientClone> getAllAbonnements(){
		List<ClientClone> clients = new ArrayList();
		
		for(Client client: clientDao.findAllByAbonne(1)) {
			clients.add(new ClientClone(client));
		}
		return clients;
	}
	
	@GetMapping(value="/uneligne")
	public List<ClientClone> getAllAbonnementsUneLigne(){
		
		List<ClientClone> clients = new ArrayList();
		
		for(Client client : clientDao.findAllByAbonne(1)) {
			if(client.getListInscriptionAbn().size() == 1) {
				clients.add(new ClientClone(client));
			}
		}
		
		return clients;
	}
	
	@GetMapping(value="/deuxlignes")
	public List<ClientClone> getAllAbonnementsDeuxLignes(){
		List<ClientClone> clients = new ArrayList();
		
		for(Client client : clientDao.findAllByAbonne(1)) {
			if(client.getListInscriptionAbn().size() == 2) {
				clients.add(new ClientClone(client));
			}
		}
		
		return clients;
	}
	
	@GetMapping(value="/ligne/{ligne}")
	public List<Client> getAllAbonnementsligne(@PathVariable("ligne")String ligne){
		List<Client> clients = new ArrayList();
		
		Ligne ligneBus = ligneDao.findByNom(ligne);
		
		if(ligneBus != null) {
			for(InscriptionAbonnement insabn : ligneBus.getListInscriptionAbn()) {
				clients.add(insabn.getClient());
			}
			return clients;
		}
		return null;
		
	}
	
}


