package fstt.lsi.metier;

import fstt.lsi.entities.InformationInscription;
import fstt.lsi.entities.InscriptionAbonnement;
import fstt.lsi.entities.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscriptionAbonnementMetier {
    Response saveRegistration(InformationInscription inscription);
    public List<InscriptionAbonnement> Factures(int id_clt);
    public Response AnnulerAbonnement(String codeAbonnee);
}
