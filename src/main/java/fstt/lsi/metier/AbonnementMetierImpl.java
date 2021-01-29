package fstt.lsi.metier;

import fstt.lsi.DAO.AbonnementDAO;
import fstt.lsi.entities.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementMetierImpl implements AbonnementMetier{
    @Autowired
    AbonnementDAO ABONNEMENT_DAO;

    @Override
    public List<Abonnement> AffichageAbonnements() {

        return ABONNEMENT_DAO.findAll();
    }

}
