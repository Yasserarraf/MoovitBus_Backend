package fstt.lsi.DAO;

import fstt.lsi.entities.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LigneDAO extends JpaRepository<Ligne,Integer> {

	Ligne findByNom(String ligne);
}
