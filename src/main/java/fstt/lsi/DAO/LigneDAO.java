package fstt.lsi.DAO;

import fstt.lsi.entities.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LigneDAO extends JpaRepository<Ligne,Integer> {
<<<<<<< HEAD
	
	@Query(value="select l From Ligne l where l.nom =:x ")
	Ligne findLigneBusByname(@Param("x") String name);
	
	
=======

	Ligne findByNom(String ligne);
>>>>>>> bc86bad097ef99ad0233b331056a114f050097d8
}
