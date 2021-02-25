package fstt.lsi.Controller;


import fstt.lsi.DAO.LigneDAO;

import fstt.lsi.DAO.StationDAO;
import fstt.lsi.bean.StationBean2;
import fstt.lsi.entities.Ligne;
import fstt.lsi.entities.Station;
import fstt.lsi.metier.StationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/station")
public class StationController {

       @Autowired
    StationDAO stationDAO;
       @Autowired
    LigneDAO ligneDAO;
       
       @Autowired
       private StationServices stationservices;
       @GetMapping("/All")  
       public ArrayList<StationBean2> AllStations() {
		return stationservices.AllStations();
	}



	@GetMapping("/surcharge")
       public List<Station> StationsSurchargees() {
		return stationservices.StationsSurchargees();
	}


	@GetMapping("/{id_ligne}")
    public Collection<Station> StationLigne(@PathVariable("id_ligne") int id_ligne){
           Ligne ligne=ligneDAO.findById(id_ligne).orElse(null);
           return ligne.getStations();
       }

}
