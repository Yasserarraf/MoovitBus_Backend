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
public class TicketMetierImpl implements TicketMetier{
    @Autowired
    private EmailService service;


    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    TicketDao ticketDao;

    @Autowired
    InformationCompteDAO informationCompteDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private AbonnementDAO abonnementDAO;

    @Autowired
    private LigneDAO ligneDAO;

    @Autowired
    private StationDAO stationDAO;

    @Autowired
    private SoldeTelephoneDAO soldeTelephoneDAO;


    @Override
    public Ticket infoTicket(Ticket ticket) {
        ticket.setPrix(4.5);
        Date aujourdhui = new Date();
        ticket.setDate(aujourdhui);
        ticket=ticketDao.save(ticket);
        return ticket;
    }

    //methode de paiement par solde du téléphone
  public Response paiementTicketParSolde(SoldeTelephone compte){
      System.out.println();
         SoldeTelephone soldeTelephone=soldeTelephoneDAO.findSoldeTelephoneByNum_tel(compte.getNum_tel());
         System.out.println(soldeTelephone);
         if(soldeTelephone!=null){
             Random rand = new Random();
             int code = rand.nextInt(1000 - 500+ 1) + 500;
             soldeTelephone.setConfirmation(code);
             soldeTelephoneDAO.save(soldeTelephone);
             sendNotification(soldeTelephone,code);
             return new Response("Le code de confirmation a été envoyé à "+soldeTelephone.getEmail(),true);

         }else{
             return new Response("Numéro de téléphone invalide !",false);
         }

  }

  //Confirmation de paiement par Solde
    @Override
    public Response confirmationPaiementParSolde(int code, int id_clt, String num_tel) {
        SoldeTelephone soldeTelephone=soldeTelephoneDAO.findSoldeTelephoneByNum_tel(num_tel);
        Client clt=clientDAO.findById(id_clt).orElse(null);
        int id=ticketDao.findlastTicket(id_clt);
        Ticket t=ticketDao.findById(id).orElse(null);
        String ligne=ligneDAO.findById(t.getId_ligne_bus()).orElse(null).getNom();
        Station station_dep=stationDAO.findById(t.getStation_dep()).orElse(null);
        Station station_des=stationDAO.findById(t.getStation_des()).orElse(null);
        if(soldeTelephone.getSolde()>t.getPrix()){
            soldeTelephone.setSolde(soldeTelephone.getSolde()-t.getPrix());
            soldeTelephoneDAO.save(soldeTelephone);
            Map<String, Object> model = new HashMap<>();
            MailRequest request=new MailRequest();
            request.setFrom("moovitbus@gmail.com");
            request.setTo(clt.getEmail());
            request.setSubject("Ticket MoovitBus");
            request.setName("MoovitBus Team");
            model.put("nom",clt.getNom());
            model.put("prenom",clt.getPrenom());
            model.put("prix", t.getPrix());
            model.put("id", t.getId());
            model.put("ligne", ligne);
            model.put("des", station_des.getNom());
            model.put("dep", station_dep.getNom());
            Date aujourdhui = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("EEEE, d MMM yyyy");
            model.put("date", formater.format(aujourdhui));
            formater = new SimpleDateFormat("h:mm a");
            model.put("time",formater.format(aujourdhui));
            formater = new SimpleDateFormat("MMM");
            model.put("mois", formater.format(aujourdhui));
            formater = new SimpleDateFormat("d");
            model.put("jour", formater.format(aujourdhui));
            service.sendEmail(request, model,"ticket-template.ftl");
            return new Response("Votre ticket a été envoyée à  "+clt.getEmail(),true);

        }else {
            return new Response("Solde Insuffisant!", false);
        }
    }


    //Méthode de paiement par carte Bancaire
    @Override
    public Response paiementTicketParCarte(InformationCompte informationCompte) {
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

    //Confirmation de paiement par carte Bancaire
    @Override
    public Response confirmationPaiementParCarte(int code, int id_clt, String numCompte) {
        Client clt=clientDAO.findById(id_clt).orElse(null);
        int id=ticketDao.findlastTicket(id_clt);
        Ticket t=ticketDao.findById(id).orElse(null);
        InformationCompte informationCompte=informationCompteDAO.findByNumPaiement(numCompte);
        String ligne=ligneDAO.findById(t.getId_ligne_bus()).orElse(null).getNom();
        Station station_dep=stationDAO.findById(t.getStation_dep()).orElse(null);
        Station station_des=stationDAO.findById(t.getStation_des()).orElse(null);     
        if(code==informationCompte.getConfimation()){
            if(informationCompte.getSolde()>t.getPrix()){
                informationCompte.setSolde(informationCompte.getSolde()-t.getPrix());
                informationCompteDAO.save(informationCompte);
                Map<String, Object> model = new HashMap<>();
                MailRequest request=new MailRequest();
                request.setFrom("moovitbus@gmail.com");
                request.setTo(clt.getEmail());
                request.setSubject("Ticket MoovitBus");
                request.setName("MoovitBus Team");
                model.put("nom",clt.getNom());
                model.put("prenom",clt.getPrenom());
                model.put("prix", t.getPrix());
                model.put("id", t.getId());
                model.put("ligne", ligne);
                model.put("des", station_des.getNom());
                model.put("dep", station_dep.getNom());
                Date aujourdhui = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("EEEE, d MMM yyyy");
                model.put("date", formater.format(aujourdhui));
                formater = new SimpleDateFormat("h:mm a");
                model.put("time",formater.format(aujourdhui));
                formater = new SimpleDateFormat("MMM");
                model.put("mois", formater.format(aujourdhui));
                formater = new SimpleDateFormat("d");
                model.put("jour", formater.format(aujourdhui));
                service.sendEmail(request, model,"ticket-template.ftl");
                return new Response("Votre ticket a été envoyée à  "+clt.getEmail(),true);
            }else{
                return new Response("Solde Insuffisant!",false);
            }
        }else{
            return new Response("Code Invalide!",false);

        }


    }



//Confirmation Achat par carte
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

    //Confirmation Achat par solde
    public void sendNotification(SoldeTelephone info,int code){
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
