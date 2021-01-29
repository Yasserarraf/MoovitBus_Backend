package fstt.lsi.metier;

import fstt.lsi.DAO.LigneDAO;
import fstt.lsi.entities.Ligne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneMetierImpl implements LigneMetier {
    @Autowired
    LigneDAO LIGNE_DAO;

    @Override
    public List<Ligne> AffichageLignes() {
        return LIGNE_DAO.findAll();
    }
}
