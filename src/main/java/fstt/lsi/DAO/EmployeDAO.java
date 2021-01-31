package fstt.lsi.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fstt.lsi.entities.Employe;

@Repository
public interface EmployeDAO extends CrudRepository <Employe, Integer>{
	
	
	

}
