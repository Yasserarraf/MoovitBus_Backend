package fstt.lsi.metier;

import fstt.lsi.DAO.*;
import fstt.lsi.entities.*;
import fstt.lsi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class PaiementAbonnementMetierImpl implements PaiementAbonnementMetier{
    @Autowired
    private EmailService service;


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private InscriptionAbonnementDAO inscriptionAbonnementDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private AbonnementDAO abonnementDAO;

    @Autowired
    private PaiementAbonnementDAO paiementAbonnementDAO;


    @Autowired
    InformationCompteDAO informationCompteDAO;

    @Override
    public Response payeAbonnement(InformationCompte informationCompte) {
        InformationCompte existe=informationCompteDAO.findByNumPaiement(informationCompte.getNumPaiement());
        if(existe!= null){
            if(existe.getNom_porteur().equals(informationCompte.getNom_porteur())&& existe.getCodeVerification().equals(informationCompte.getCodeVerification())&&existe.getMoisExpiration().equals(informationCompte.getMoisExpiration())&&existe.getAnneeExpiration().equals(informationCompte.getAnneeExpiration())){
                Random rand = new Random();
                int code = rand.nextInt(1000 - 500+ 1) + 500;
                existe.setConfimation(code);
                informationCompteDAO.save(existe);
                sendNotification(existe,code);
                return new Response("Le code de confirmation a été envoyé à "+existe.getEmail(),true);

            }else{
                return new Response("Information invalid!",false);
            }
        }else{
            return new Response("Information invalid!",false);
        }
    }

    @Override
    public Response confirmationPaiement(String numCompte, int code,String codeAbonnee) {

        InscriptionAbonnement inscriptionAbonnement=inscriptionAbonnementDAO.findByCodeAbonne(codeAbonnee);
        Client clt= inscriptionAbonnement.getClient();
        Abonnement a=inscriptionAbonnement.getAbonnement();
        InformationCompte informationCompte=informationCompteDAO.findByNumPaiement(numCompte);
        if(code==informationCompte.getConfimation()){
            if(informationCompte.getSolde()>a.getPrix()){
                informationCompte.setSolde(informationCompte.getSolde()-a.getPrix());
                informationCompteDAO.save(informationCompte);
                inscriptionAbonnement.setPayee(1);
                inscriptionAbonnementDAO.save(inscriptionAbonnement);
                Map<String, Object> model = new HashMap<>();
                MailRequest request=new MailRequest();
                request.setFrom("moovitbus@gmail.com");
                request.setTo(clt.getEmail());
                request.setSubject("Reçu d'abonnement");
                request.setName("MoovitBus Team");
                model.put("codeAbonnement",inscriptionAbonnement.getCodeAbonne());
                model.put("prix", inscriptionAbonnement.getAbonnement().getPrix());
                model.put("type",inscriptionAbonnement.getAbonnement().getType());
                model.put("nom",clt.getNom());
                model.put("prenom",clt.getPrenom());
                Date aujourdhui = new Date();
                PaiementAbonnement paiementAbonnement=new PaiementAbonnement(aujourdhui,inscriptionAbonnement);
                paiementAbonnementDAO.save(paiementAbonnement);
                SimpleDateFormat formater = new SimpleDateFormat("'le' dd MMMM yyyy 'à' hh:mm:ss");
                model.put("date",formater.format(aujourdhui));
                service.sendEmail(request, model,"reçu-abonnement.ftl");
                return new Response("Votre reçu de paiement a été envoyée à  "+clt.getEmail(),true);
            }else{
                return new Response("Solde Insuffisant!",false);
            }
        }else{
            return new Response("Code Invalide!",false);
        }
    }

    public void sendNotification(InformationCompte info,int code){
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(info.getEmail());
        mail.setFrom("moovitBus@gmail.com");
        mail.setSubject("Confirmation de paiement");
        mail.setText("Bonjour "+info.getNom_porteur()+",\n" +
                "\n" +
                "Ce mail nous permet de valider votre paiement \n \nVoilà votre code de confirmation: "+code+"\n\nA bientôt,\n" +
                "MoovitBus Team\n" +
                "\n" +
                "Merci de ne pas répondre directement à cet e-mail.");
        javaMailSender.send(mail);
    }


}
