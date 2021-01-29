package fstt.lsi.DAO;

import fstt.lsi.entities.SoldeTelephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldeTelephoneDAO extends JpaRepository<SoldeTelephone,Integer> {


    @Query("select e from SoldeTelephone e where e.num_tel=:x")
    public SoldeTelephone findSoldeTelephoneByNum_tel(@Param("x") String num_tel);
}
