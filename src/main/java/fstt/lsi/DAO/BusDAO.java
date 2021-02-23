package fstt.lsi.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fstt.lsi.entities.Bus;
import fstt.lsi.entities.Ligne;



public interface BusDAO extends JpaRepository<Bus, Integer>{
	
	@Query("select b From Bus b  where b.lignebus =:x and b.direction=:d")
	List<Bus> findAllBy(@Param("x")Ligne lb  ,@Param("d") String deriction);
	
	

}
