package fstt.lsi.Controller;


import fstt.lsi.DAO.LigneDAO;
import fstt.lsi.entities.Ligne;
import fstt.lsi.metier.LigneMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lignes")
public class LigneController {

    @Autowired
    private LigneMetier ligneMetier;

    @GetMapping
    public List<Ligne> AffichageLignes() {
        return ligneMetier.AffichageLignes();
    }

}
