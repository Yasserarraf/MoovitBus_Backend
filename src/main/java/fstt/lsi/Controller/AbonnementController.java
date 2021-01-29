package fstt.lsi.Controller;


import fstt.lsi.DAO.ClientDAO;
import fstt.lsi.entities.*;
import fstt.lsi.metier.AbonnementMetier;
import fstt.lsi.metier.InscriptionAbonnementMetier;
import fstt.lsi.metier.PaiementAbonnementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Abonnements")
public class AbonnementController {
    @Autowired
    AbonnementMetier abonnementMetier;

    @Autowired
    ClientDAO dao;



    @Autowired
    private InscriptionAbonnementMetier inscriptionAbonnementMetier ;


    @Autowired
    private PaiementAbonnementMetier paiementAbonnementMetier;


    @GetMapping
    public List<Abonnement> AffichageAbonnements() {
        System.out.println(abonnementMetier.AffichageAbonnements().get(1));
        return abonnementMetier.AffichageAbonnements();
    }

    @PostMapping(value = "/inscription")
    public Response saveRegistration(@RequestBody InformationInscription inscription) {
        System.out.println(inscription.getId_clt());
        return inscriptionAbonnementMetier.saveRegistration(inscription);
    }


    @GetMapping(value="/facture")
    public List<InscriptionAbonnement> Factures(@RequestParam int id_clt) {
        return inscriptionAbonnementMetier.Factures(id_clt);
    }

    @PostMapping(value="/paiement")
    public Response payeAbonnement(@RequestBody InformationCompte informationCompte) {
        return paiementAbonnementMetier.payeAbonnement(informationCompte);
    }

    @GetMapping("/confirmation")
    public Response confirmationPaiementParCarte(@RequestParam String numCompte,@RequestParam int code,@RequestParam String codeAbonnee) {
        return paiementAbonnementMetier.confirmationPaiement(numCompte, code,codeAbonnee);
    }

    @GetMapping("/annulation")
    public Response AnnulerAbonnement(@RequestParam String codeAbonnee) {
        return inscriptionAbonnementMetier.AnnulerAbonnement(codeAbonnee);
    }



}
