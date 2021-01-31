package fstt.lsi.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fstt.lsi.entities.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer>{

	Admin findByEmailAndPasswordAndRole(String email, String password, String role);

	Admin findByEmail(String email);
	
}
