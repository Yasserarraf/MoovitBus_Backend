package fstt.lsi.DAO;

import fstt.lsi.entities.PaiementAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementAbonnementDAO extends JpaRepository<PaiementAbonnement,Integer> {
}
