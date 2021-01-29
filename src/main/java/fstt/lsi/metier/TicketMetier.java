package fstt.lsi.metier;

import fstt.lsi.entities.InformationCompte;
import fstt.lsi.entities.Response;
import fstt.lsi.entities.SoldeTelephone;
import fstt.lsi.entities.Ticket;

public interface TicketMetier {

    public Ticket infoTicket(Ticket ticket);
    public Response paiementTicketParSolde(SoldeTelephone num_tel);
    public Response confirmationPaiementParSolde(int code,int id_clt,String num_tel);
    public Response paiementTicketParCarte(InformationCompte informationCompte);
    public Response confirmationPaiementParCarte(int code,int id_clt,String numCompte);
}
