package fstt.lsi.DAO;

import fstt.lsi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientDAO extends JpaRepository<Client,Integer> {
}
