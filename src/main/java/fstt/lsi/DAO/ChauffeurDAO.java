package fstt.lsi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fstt.lsi.entities.Chauffeur;

@Repository
public interface ChauffeurDAO extends JpaRepository<Chauffeur, Integer> {

	Chauffeur findByEmail(String email);

}
