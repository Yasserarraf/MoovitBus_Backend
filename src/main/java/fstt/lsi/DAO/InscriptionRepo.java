package fstt.lsi.DAO;

import fstt.lsi.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface InscriptionRepo extends JpaRepository<Client, Integer> {


    public Client findByEmail(String email);

    public Client findByEmailAndPassword(String email, String password);

}
