package fstt.lsi.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fstt.lsi.bean.BusBean;
import fstt.lsi.bean.CasUrgentBean;
import fstt.lsi.bean.LigneBusBean;
import fstt.lsi.service.service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class Controller {

	@Autowired
	private service moovitservice;

	@GetMapping(value="/meilleurVoyage")
	public List<LigneBusBean>getLigneBus(@RequestParam("station_Dep")String station_Dep,@RequestParam("station_Dist") String station_Dist){
	return moovitservice.getLigneBus1(station_Dep, station_Dist);
	}
	
	@GetMapping(value="/Postempsrestantbus")
	 List<BusBean>  getPostempsrestantBus(@RequestParam("station_Dep")String station_Dep,@RequestParam("station_Dist") String station_Dist,@RequestParam("nom_LigneBus") String nom_LigneBus){
	return moovitservice.getPostempsrestantBus(station_Dep, station_Dist,  nom_LigneBus);
	}
	@GetMapping(value="/CasUrgents")
	List<CasUrgentBean>  getPostCasUrgents(){
	return moovitservice.getcas_urgents();
	}
	@GetMapping(value="/SignalerCasUrgent")
	CasUrgentBean CreateCasUrgent(@RequestParam("id_chauffeur")int id_chauffeur,@RequestParam("type")String type){
	return moovitservice.signalercas(id_chauffeur, type);
	}
	
	
}
