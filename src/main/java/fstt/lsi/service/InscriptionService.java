package fstt.lsi.service;

import fstt.lsi.DAO.InscriptionRepo;
import fstt.lsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.PostConstruct;

@Service
public class InscriptionService {
    private static InscriptionRepo repo;
    @Autowired
    public InscriptionService(InscriptionRepo repo) {
        InscriptionService.repo = repo;
    }


    public Client saveClient(Client client) {

        return repo.save(client);

    }

    public static Client fetchClientByEmail(String email) {

        return repo.findByEmail(email);

    }

    public static Client fetchClientByEmailAndPassword(String email, String password) {

        return repo.findByEmailAndPassword(email, password);

    }
    
    public List<Client> AllClients()
    {
    	return repo.findAll();
    }



}
