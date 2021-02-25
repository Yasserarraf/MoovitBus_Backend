package fstt.lsi.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fstt.lsi.DAO.BusDAO;
import fstt.lsi.DAO.Cas_UrgentDAO;
import fstt.lsi.DAO.EmployeDAO;
import fstt.lsi.DAO.LigneDAO;
import fstt.lsi.DAO.LigneStationDAO;
import fstt.lsi.DAO.StationDAO;
import fstt.lsi.bean.BusBean;
import fstt.lsi.bean.CasUrgentBean;
import fstt.lsi.bean.LigneBusBean;
import fstt.lsi.bean.StationBean;
import fstt.lsi.entities.Bus;
import fstt.lsi.entities.Cas_Urgent;
import fstt.lsi.entities.Employe;
import fstt.lsi.entities.Ligne;
import fstt.lsi.entities.LigneStation;
import fstt.lsi.entities.Station;


@Service
public class service {

	
	@Autowired
	private StationDAO st;
	@Autowired
	private LigneDAO lbdao;
	@Autowired
	private BusDAO busdao;
	@Autowired
	private LigneStationDAO lignestationdao;
	@Autowired
	private EmployeDAO employedao;

	@Autowired
	private Cas_UrgentDAO casurgentdao;

    
	public Station getStationByname(String nom) {

		return st.findStationByname(nom);

	}
     //return la liste des bus corresspond a l aligne de bus donnée est en direction donnée
	public List getListBus(int idLigneBus, String direction) {
		Ligne lb= lbdao.findById(idLigneBus).orElse(null);
		return busdao.findAllBy(lb, direction);
	}

	public Ligne getLigneBusByname(String nom) {
		return lbdao.findLigneBusByname(nom);

	}

	public LigneStation getLigneStation(int idStation, int idLigneBus) {

		return lignestationdao.findLigneStation(idStation, idLigneBus);
	}
	
//***************************************************************************************************************************************	

	
	
	
       // cette fonction permet d'obtenir les lignesStation qui existent entre Station depart et station arrivee 
	   //pour une ligne de bus
	public List<LigneStation> getlistStationByLignebus(int idlignebus, int idStationDep, int idStationDest,
			String direction) {
		List<LigneStation> listLigneStation = lignestationdao.findlistLigneStationByLigneBus(idlignebus);
		List<LigneStation> listLigneStationb = new ArrayList<LigneStation>();
		int indexDep = 0;
		int indexDest = 0;
		for (int i = 0; i < listLigneStation.size(); i++) {
			if (listLigneStation.get(i).getId_station() == idStationDep)
				indexDep = i;
			else if (listLigneStation.get(i).getId_station() == idStationDest)
				indexDest = i;		
		}
		for (int i = 0; i < listLigneStation.size(); i++) {
			if (i >= indexDep && i <= indexDest && direction.equalsIgnoreCase("aller"))
				listLigneStationb.add(listLigneStation.get(i));
			else if (i >= indexDest && i <= indexDep && direction.equalsIgnoreCase("retour"))
				listLigneStationb.add(listLigneStation.get(i));
		}
		return listLigneStationb;
	}
     
	
	public List<LigneBusBean> getLigneBus(String nomStationDepart, String nomStationDest) {
		Station stationdest = getStationByname(nomStationDest);
		Station stationdep = getStationByname(nomStationDepart);

		String direction = null;
		if (stationdest.getId() < stationdep.getId())
			direction = "retour";
		if (stationdest.getId() > stationdep.getId())
			direction = "aller";
		
		List<Ligne> l= getLigneBusBystation(stationdep.getId(),  stationdest.getId(),  direction);
		List<LigneBusBean> ll=new ArrayList<LigneBusBean>();
		for(Ligne lb: l) {
			ll.add(new LigneBusBean(lb.getId(), lb.getNom(),new StationBean(stationdep.getId(),stationdep.getNom(),stationdep.getLatitude(),stationdep.getLongitude()),
					new StationBean(stationdest.getId(),stationdest.getNom(),stationdest.getLatitude(),stationdest.getLongitude()) , 1));
		}
		
		
		
		
		
		return ll;
	}
	
//***************************************************************************************************************************************	
	//return the busLigne which pass by StationDep and StationDest desc by distance
	public List<Ligne> getLigneBusBystation(int idStationDep, int idStationDest, String direction) {
		TreeMap<Integer, List<LigneStation>> LigneBusStation = new TreeMap<>();
		TreeMap<Integer, Float> LigneBusDistance = new TreeMap<>();
		List<Float> listDistance =new ArrayList<Float>();
		List<Ligne> listLigneBus =new ArrayList<Ligne>();
		List<Integer> listligneBus = lignestationdao.findLigneBusBystations(idStationDep, idStationDest);
		float distance = 0;
		for (int i = 0; i < listligneBus.size(); i++) {
			LigneBusStation.put(listligneBus.get(i),
					getlistStationByLignebus(listligneBus.get(i), idStationDep, idStationDest, direction));
		}
		for (int i : LigneBusStation.keySet()) {
			for (LigneStation ls : LigneBusStation.get(i)) {
				distance +=ls.getDistance();

			}
			LigneBusDistance.put(i, distance);
			listDistance.add(distance);
			
		distance = 0;}
		Collections.sort(listDistance);

		for (int i : LigneBusDistance.keySet()) {

			if ((float)LigneBusDistance.get(i) == (float)listDistance.get(0)) {
				listLigneBus.add(lbdao.findById(i).orElse(null));
				
			}
			
		}

		return listLigneBus;
	}

	public List<LigneStation> getlistStationByLignebusDep(int idlignebus, int idStationDep, String direction) {
		List<LigneStation> listLigneStation = lignestationdao.findlistLigneStationByLigneBus(idlignebus);
		List<LigneStation> listLigneStationb = new ArrayList<LigneStation>();
		int indexDep = 0;
		for (int i = 0; i < listLigneStation.size(); i++) {
			if (listLigneStation.get(i).getId_station() == idStationDep)
				indexDep = i;
			
		}
		for (int i = 0; i < listLigneStation.size(); i++) {
			if (i >= indexDep && direction.equalsIgnoreCase("aller"))
				listLigneStationb.add(listLigneStation.get(i));
			else if (i <= indexDep && direction.equalsIgnoreCase("retour"))
				listLigneStationb.add(listLigneStation.get(i));
		}
		return listLigneStationb;
	}

	public List<LigneStation> getlistStationByLignebusDest(int idlignebus, int idStationDest, String direction) {
		List<LigneStation> listLigneStation = lignestationdao.findlistLigneStationByLigneBus(idlignebus);
		List<LigneStation> listLigneStationb =new ArrayList<LigneStation>();
		int indexDest = 0;
		for (int i = 0; i <listLigneStation.size(); i++) {
			if (listLigneStation.get(i).getId_station() == idStationDest) {
				indexDest = i;
			}
			
		}
		for (int i = 0; i < listLigneStation.size(); i++) {
			if (i <= indexDest && direction.equalsIgnoreCase("aller")) {
				listLigneStationb.add(listLigneStation.get(i));
	
			}
			else if (i >= indexDest && direction.equalsIgnoreCase("retour"))
				listLigneStationb.add(listLigneStation.get(i));
		}
		return listLigneStationb;
	}
 

	public TreeMap<Integer, List<Integer>> getLigneBusBystation2(int idStationDep, int idStationDest, String direction) {

		List<Integer> listlignebusDep = lignestationdao.findLigneBusBystation(idStationDep);
		List<Integer> listlignebusDest = lignestationdao.findLigneBusBystation(idStationDest);

		TreeMap<Integer, List<LigneStation>> LigneBusStationDep = new TreeMap<>();
		TreeMap<Integer, List<LigneStation>> LigneBusStationDest = new TreeMap<>();
		TreeMap<Integer, List<Integer>> StationLigneBus = new TreeMap<>();
		TreeMap<Integer, List<Integer>> ListLignesBus = new TreeMap<>();
		List<LigneStation> LigneStationBus1 = new ArrayList<LigneStation>();
		List<LigneStation> LigneStationBus2 =  new ArrayList<LigneStation>();
		Map<Integer, Map<List<Integer>, Float>> multiMap = new HashMap<>();
		HashMap<List<Integer>, Float> StationDistance=new HashMap<>(); 
		List<Float>Distances=new ArrayList<Float>();;
		List<LigneStation>ll=new ArrayList<LigneStation>();;
		float dist = 0;
		

		List<Integer> lb = new ArrayList<Integer>();
		for (int i = 0; i < listlignebusDep.size(); i++) {
			
			LigneBusStationDep.put(listlignebusDep.get(i),
					getlistStationByLignebusDep(listlignebusDep.get(i), idStationDep, direction));
		ll=getlistStationByLignebusDep(listlignebusDep.get(i), idStationDep, direction);
			
			}
		for (int i = 0; i < listlignebusDest.size(); i++) {
		
			LigneBusStationDest.put(listlignebusDest.get(i),
					getlistStationByLignebusDest(listlignebusDest.get(i), idStationDest, direction));
			ll=getlistStationByLignebusDest(listlignebusDest.get(i), idStationDest, direction);
		
		}
int k=0;
		for (int i : LigneBusStationDep.keySet())	
            for (int j : LigneBusStationDest.keySet())
            	for (LigneStation lsDep : LigneBusStationDep.get(i))
					for (LigneStation lsDest : LigneBusStationDest.get(j))
	
						if (lsDest.getId_station() == lsDep.getId_station()) {
							lb.add(i);
							lb.add(j);
							lb.add(lsDest.getId_station());
				
							StationLigneBus.put(k, lb);
							k++;
							lb=new ArrayList<Integer>();}
		
		
		
	
		for(int i=0; i<StationLigneBus.size();i++) {
			
			LigneStationBus1= getlistStationByLignebus( StationLigneBus.get(i).get(0),  idStationDep, StationLigneBus.get(i).get(2),direction) ;
			LigneStationBus2= getlistStationByLignebus( StationLigneBus.get(i).get(1),  StationLigneBus.get(i).get(2), idStationDest,direction) ;
			for(int j =0;j<LigneStationBus1.size();j++)
				dist+=LigneStationBus1.get(j).getDistance();
			for(int j =0;j<LigneStationBus2.size();j++)
				dist+=LigneStationBus2.get(j).getDistance();
			lb=new ArrayList<Integer>();
			lb.add(StationLigneBus.get(i).get(0));
			lb.add(StationLigneBus.get(i).get(1));
			lb.add(StationLigneBus.get(i).get(2));
		
			StationDistance.put(lb, dist);
	
			multiMap.put(i,StationDistance);
			Distances.add(dist);
			StationDistance=new HashMap<>(); 
			dist=0;
		
		}
		
		
		Collections.sort(Distances);
    k=0;
		for(int i:	multiMap.keySet()) {
			for(List<Integer>l:multiMap.get(i).keySet()) {
				if((float)multiMap.get(i).get(l)==(float)Distances.get(0)) {
					ListLignesBus.put(k, l);
				k++;}
			}
			
		}
		return ListLignesBus;
		
	}

	
	public List<LigneBusBean> getLigneBus1(String nomStationDepart, String nomStationDest){
		List<LigneBusBean> tot = getLigneBus(nomStationDepart , nomStationDest) ;
		List<LigneBusBean> ml = new ArrayList<LigneBusBean>();
		Station stationdest = getStationByname(nomStationDest);
		Station stationdep = getStationByname(nomStationDepart);
		Ligne lb;
		 TreeMap<Integer, List<Integer>> l = new TreeMap<>() ;
		String direction = null;
		if (stationdest.getId() < stationdep.getId())
			direction = "retour";
		if (stationdest.getId() > stationdep.getId())
			direction = "aller";
TreeMap<Integer, List<Integer>>mm=	getLigneBusBystation2(stationdep.getId(),  stationdest.getId(),  direction) ;
		
		for(int i:mm.keySet() ) {
			lb=lbdao.findById(mm.get(i).get(0)).orElse(null);
			stationdep = getStationByname(nomStationDepart);
			stationdest=st.findById(mm.get(i).get(2)).orElse(null);
			ml.add(new LigneBusBean(lb.getId(), lb.getNom(),new StationBean(stationdep.getId(),stationdep.getNom(),stationdep.getLatitude(),stationdep.getLongitude()),
					new StationBean(stationdest.getId(),stationdest.getNom(),stationdest.getLatitude(),stationdest.getLongitude()), 2));
		
			lb=lbdao.findById(mm.get(i).get(1)).orElse(null);
			 stationdest = getStationByname(nomStationDest);
			stationdep=st.findById(mm.get(i).get(2)).orElse(null);
			ml.add(new LigneBusBean(lb.getId(), lb.getNom(),new StationBean(stationdep.getId(),stationdep.getNom(),stationdep.getLatitude(),stationdep.getLongitude()),
					new StationBean(stationdest.getId(),stationdest.getNom(),stationdest.getLatitude(),stationdest.getLongitude()) , 2));
		
		
		}

	if(tot.size() == 0) {
		 
		return ml ;

	}
	
		return tot ;
	

	}	 
	
	public List<BusBean>  getPostempsrestantBus(String nomStationDepart, String nomStationDest, String nomLigneBus) {
		Station stationdest = getStationByname(nomStationDest);
		Station stationdep = getStationByname(nomStationDepart);
		String direction = null;
		float time=0f;
		float distance=0;
		float distanceDebut=0;
		float distRest=0;
		Ligne lignebus = getLigneBusByname(nomLigneBus);
		LigneStation LigneStation_dep = getLigneStation(stationdep.getId(), lignebus.getId());
		LigneStation LigneStation_dest = getLigneStation(stationdest.getId(), lignebus.getId());
		List<LigneStation>ls1=lignestationdao.findlistLigneStationByLigneBus(lignebus.getId());
		 if (LigneStation_dest.getId() < LigneStation_dep.getId())
			direction = "retour";
		 if (LigneStation_dest.getId() > LigneStation_dep.getId())
			direction = "aller";
		 if(LigneStation_dep==ls1.get(0))
			direction = "retour";
		if(LigneStation_dep==ls1.get(ls1.size()-1));
			direction = "aller";
			
		List<Bus> ListBus = getListBus(lignebus.getId(), direction);
		LigneStation lsdebut;
		if(direction.equalsIgnoreCase("aller"))
		 lsdebut=lignestationdao.findlistLigneStationByLigneBus(lignebus.getId()).get(0);
		else
		 lsdebut=lignestationdao.findlistLigneStationByLigneBus(lignebus.getId()).get(lignestationdao.findlistLigneStationByLigneBus(lignebus.getId()).size()-1);
		List<LigneStation>ls= getlistStationByLignebus(lignebus.getId() ,lsdebut.getId(), stationdep.getId(),direction);
	
		for(LigneStation l :ls) {
			distanceDebut+=l.getDistance();	
		}


		List<BusBean> ListBusBean = new ArrayList<BusBean>();
		BusBean busbean;
		for(Bus b :ListBus) {
			distRest=distanceDebut-b.getDistance_dep();
			time= (distRest/b.getVitesse())*60;
			
			if(b.getDistance_dep()<distanceDebut)
			ListBusBean.add(new BusBean(b.getId(), b.getLatitude(), b.getLongitude(), b.getDirection(),time));	
		}
		return ListBusBean;
	}
	
	
public CasUrgentBean signalercas( int id_chauffeur , String type  ) {
		
		Employe e = employedao.findById(id_chauffeur).orElse(null);
	   Bus b = busdao.findById(e.getBus().getId()).orElse(null);
	   
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String s= df.format(new Date());
	
		Cas_Urgent cas = new Cas_Urgent( 0 , type , e,s ) ;
		casurgentdao.save(cas) ;
		BusBean bb= new BusBean(b.getId(),b.getLatitude() , b.getLongitude(), b.getDirection(),0);
        
		 CasUrgentBean cub= new CasUrgentBean(cas.getId(), type,bb,s);
		return cub ;
	}
	
	public List<CasUrgentBean> getcas_urgents(){
		List<Cas_Urgent>  cas = (List<Cas_Urgent>) casurgentdao.findAll();
		List<CasUrgentBean> cbean =new ArrayList<CasUrgentBean>();
		 
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String s= df.format(new Date());
			for (Cas_Urgent c: cas) {
			if(c.getDate().equalsIgnoreCase(s)){
			Employe e = c.getEmploye();
		  Bus b = busdao.findById(e.getBus().getId()).orElse(null);
		  BusBean bb= new BusBean(b.getId(),b.getLatitude() , b.getLongitude(), b.getDirection(),0);
			CasUrgentBean cub= new CasUrgentBean(c.getId(), c.getType(),bb,c.getDate());
			 cbean.add(cub);
		}}
		return cbean ;	
	}
	
	
	
	
}

