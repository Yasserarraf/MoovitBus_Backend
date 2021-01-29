package fstt.lsi.DAO;

import fstt.lsi.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketDao extends JpaRepository<Ticket,Integer> {
    @Query("select max(id) from Ticket where id_client=:x")
    public int findlastTicket(@Param("x") int id_clt);
}
