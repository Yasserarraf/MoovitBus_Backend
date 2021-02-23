package fstt.lsi.DAO;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import fstt.lsi.entities.LigneStation;

public interface LigneStationDAO extends JpaRepository <LigneStation, Integer>{
     
	@Query(value="select ls From LigneStation ls where ls.id_station =:x and ls.id_ligne_bus=:y")
	LigneStation findLigneStation(@Param("x") int idStation ,@Param("y") int idLigneBus);
	
	@Query(value="SELECT ls.id_ligne_bus FROM LigneStation ls WHERE ls.id_station =:x"
			+ " AND ls.id_ligne_bus IN (SELECT ls.id_ligne_bus FROM LigneStation ls WHERE ls.id_station =:y)")
	 List<Integer> findLigneBusBystations(@Param("x")int idStationDep , @Param("y")int idStationDest);
	
	@Query(value="select ls From LigneStation ls where ls.id_ligne_bus=:x")
	List<LigneStation> findlistLigneStationByLigneBus( @Param("x") int idLigneBus);
	 
	@Query(value="SELECT ls.id_ligne_bus FROM LigneStation ls WHERE ls.id_station =:x")
	 List<Integer> findLigneBusBystation(@Param("x")int idStation);

	
}
