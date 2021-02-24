package fstt.lsi.Controller;


import fstt.lsi.entities.InformationCompte;
import fstt.lsi.entities.Response;
import fstt.lsi.entities.SoldeTelephone;
import fstt.lsi.entities.Ticket;
import fstt.lsi.metier.TicketMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ticket")
public class TicketController {


    @Autowired
    TicketMetier ticketMetier;

    @PostMapping
    public Ticket infoTicket(@RequestBody Ticket ticket) {
        return ticketMetier.infoTicket(ticket);
    }


    @PostMapping("/paiementParCarte")
    public Response paiementTicket(@RequestBody InformationCompte informationCompte) {
        return ticketMetier.paiementTicketParCarte(informationCompte);
    }

    @GetMapping("/confirmationPaiementParCarte")
    public Response confirmationPaiementParCarte(@RequestParam int code,@RequestParam int id_clt,@RequestParam String numCompte) {
        return ticketMetier.confirmationPaiementParCarte(code, id_clt, numCompte);
    }

    @PostMapping("/paiementParSolde")
    public Response paiementTicketParSolde(@RequestBody SoldeTelephone Telephone) {
        return ticketMetier.paiementTicketParSolde(Telephone);
    }
    @GetMapping("/confirmationPaiementParSolde")
    public Response confirmationPaiementParSolde(@RequestParam int code,@RequestParam int id_clt,@RequestParam String num_tel) {
        return ticketMetier.confirmationPaiementParSolde(code, id_clt, num_tel);
    }

}
