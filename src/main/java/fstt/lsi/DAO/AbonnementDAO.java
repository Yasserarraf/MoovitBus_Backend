package fstt.lsi.DAO;

import fstt.lsi.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AbonnementDAO extends JpaRepository<Abonnement,Integer> {
}
