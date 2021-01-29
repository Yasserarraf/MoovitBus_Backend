package fstt.lsi.metier;

import fstt.lsi.entities.InformationCompte;
import fstt.lsi.entities.Response;

public interface PaiementAbonnementMetier {
     public Response payeAbonnement(InformationCompte informationCompte);
     public Response confirmationPaiement(String numCompte,int code,String codeAbonnee);

}
