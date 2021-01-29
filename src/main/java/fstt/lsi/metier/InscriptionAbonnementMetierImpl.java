package fstt.lsi.metier;

import fstt.lsi.DAO.*;
import fstt.lsi.entities.*;
import fstt.lsi.entities.InscriptionAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class InscriptionAbonnementMetierImpl implements InscriptionAbonnementMetier {
    @Autowired
    private InscriptionAbonnementDAO inscriptionAbonnementDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private AbonnementDAO abonnementDAO;

    @Autowired
    private LigneDAO ligneDAO;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Response saveRegistration(InformationInscription inscription) {

        // TODO Auto-generated method stub
        //Client
        Client clt= clientDAO.findById(inscription.getId_clt()).orElse(null);

        //Abonnement
        Abonnement abonnement=abonnementDAO.findById(inscription.getId_abonnement()).orElse(null);

        //Ligne
        Ligne ligne=ligneDAO.findById(inscription.getId_ligne()).orElse(null);


        //int idClient=inscription.getClient().getId();
        //if(idClient==0) return new Response("you have already a subscription",false);


        //Insertion du code d'Abonné
        Random rand = new Random();
        int number = rand.nextInt(100000000 - 500000+ 1) + 500000;
        String code="M"+number+"42";
        InscriptionAbonnement inscriptionAbonnement=new InscriptionAbonnement(code,clt,abonnement,ligne);
        inscriptionAbonnement.setCodeAbonne(code);

        // envoie du codeAbonné dans le mail du client
          sendNotification(clt,code);

        //modification du client
        clt.setAbonne(1);
        Client cl2=clientDAO.save(clt);
        inscriptionAbonnementDAO.save(inscriptionAbonnement);
        return new Response("Votre inscription à l'abonnement a été effectuée avec succés",true);
    }

    public void sendNotification(Client clt,String code){
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setTo(clt.getEmail());
        mail.setFrom("moovitBus@gmail.com");
        mail.setSubject("Inscription à l'abonnement");
        String message="Mr/Mme   ";
        message+=clt.getNom()+" "+clt.getPrenom()+"\n\n";
        message+="Votre inscription à l'abonnement a été effectuée avec succès "
                + ", vous trouverez ci-joint votre code d'abonnement. "
                + "\n Code d'abonnement : "+code+
                "\n\n" +
                "Merci de ne pas répondre directement à cet e-mail.";
        mail.setText(message);
        javaMailSender.send(mail);
    }


    public List<InscriptionAbonnement> Factures(int id_clt){
        Client clt=clientDAO.findById(id_clt).orElse(null);
             return inscriptionAbonnementDAO.factures(clt);
    }

    @Override
    public Response AnnulerAbonnement(String codeAbonnee) {
        InscriptionAbonnement inscriptionAbonnement=inscriptionAbonnementDAO.findByCodeAbonne(codeAbonnee);
        Client clt=inscriptionAbonnement.getClient();
        inscriptionAbonnementDAO.delete(inscriptionAbonnement);
        if(inscriptionAbonnementDAO.findInscriptionAbonnementByClient(clt).size()==0){
                 clt.setAbonne(0);
                 clientDAO.save(clt);
        }
        return new Response("Votre abonnement "+codeAbonnee+" a été annulée avec succès",true);
    }
}
