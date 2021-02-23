package fstt.lsi.DAO;

import fstt.lsi.entities.Client;
import fstt.lsi.entities.InformationCompte;
import fstt.lsi.entities.InscriptionAbonnement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface InformationCompteDAO extends JpaRepository<InformationCompte,Integer> {
	
	//@Query("select i from InformationCompte i where i.numPaiement=:x ")	
	//public InformationCompte findByNumPaiement(@Param("x")String numPaiement);
	
    public InformationCompte findByNumPaiement(String numPaiement);
}
