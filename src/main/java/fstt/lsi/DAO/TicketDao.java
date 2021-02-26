package fstt.lsi.DAO;

import fstt.lsi.entities.Ticket;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketDao extends JpaRepository<Ticket,Integer> {
	
	@Query("SELECT t from Ticket t WHERE t.date=:x and t.station_dep=:y ")//  
	public List<Ticket> findByDateandStationDep(@Param("x") Date date,@Param("y") int station);
	
	@Query("SELECT t from Ticket t WHERE t.station_dep=:y ")//  
	public List<Ticket> findByStationDep(@Param("y") int station);
	
	@Query("SELECT t from Ticket t WHERE t.station_dep=:y and t.date between :x1 and :x2")//  
	public List<Ticket> findByStationDepandDate(@Param("y") int station,@Param("x1")Date date1,@Param("x2")Date date2);
	
	@Query("SELECT t from Ticket t WHERE t.station_dep=:y and t.id_ligne_bus=:z and t.date between :x1 and :x2")//  
	public List<Ticket> findByStationDepandDateandLigneBus(@Param("y") int station,@Param("z")int ligneBus,@Param("x1")Date date1,@Param("x2")Date date2);
	
	
	//id_ligne_bus
	
	/*
	 * @Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	User findUserByStatusAndNameNamedParams(
	  @Param("status") Integer status, 
	  @Param("name") String name);*/
	
	//public List<Ticket> findByStation__dep(int st);
   
	@Query("select max(id) from Ticket where id_client=:x")
    public int findlastTicket(@Param("x") int id_clt);
    
    
    
}
