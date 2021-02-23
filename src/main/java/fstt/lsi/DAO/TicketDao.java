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
	
	/*@Query("select * from Ticket where date=:x and Station__dep=:y")
	public List<Ticket> findByDateandStationDep(@Param("x") Date date,@Param("y") int station);
	*/
	//public List<Ticket> findByStation__dep(int st);
   
	@Query("select max(id) from Ticket where id_client=:x")
    public int findlastTicket(@Param("x") int id_clt);
    
    
    
}
