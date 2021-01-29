package fstt.lsi.DAO;

import fstt.lsi.entities.Client;
import fstt.lsi.entities.InscriptionAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InscriptionAbonnementDAO extends JpaRepository<InscriptionAbonnement,Integer> {

    @Query("select e from InscriptionAbonnement e where e.client=:x and e.payee=0")
    public List<InscriptionAbonnement> factures(@Param("x") Client clt);

    @Query("select e from InscriptionAbonnement e where e.client=:x")
   public List<InscriptionAbonnement> findInscriptionAbonnementByClient(@Param("x") Client clt);

    @Query("select e from InscriptionAbonnement e where e.CodeAbonne=:x")
    public InscriptionAbonnement findByCodeAbonne(@Param("x") String codeAbonne);
}
