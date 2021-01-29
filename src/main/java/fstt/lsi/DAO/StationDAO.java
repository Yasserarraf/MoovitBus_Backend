package fstt.lsi.DAO;

import fstt.lsi.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationDAO extends JpaRepository<Station,Integer> {
}
