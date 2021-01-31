package fstt.lsi.DAO;

import fstt.lsi.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StationDAO extends JpaRepository<Station,Integer> {
	
	
	@Query(value="select s From Station s where s.nom = :x")
	Station findStationByname(@Param("x") String name);
}
