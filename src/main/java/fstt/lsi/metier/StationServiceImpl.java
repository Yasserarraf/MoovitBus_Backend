package fstt.lsi.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstt.lsi.DAO.LigneDAO;
import fstt.lsi.DAO.StationDAO;
import fstt.lsi.DAO.TicketDao;
import fstt.lsi.bean.StationBean2;
import fstt.lsi.bean.StationSurcharge;
import fstt.lsi.entities.Ligne;
import fstt.lsi.entities.Station;
import fstt.lsi.entities.Ticket;
@Service
public class StationServiceImpl implements StationServices{
	@Autowired
	private StationDAO stationrepo;
	
	@Autowired
	private TicketDao ticketrepo;
	
	@Autowired
	private LigneDAO lignerepo;
	

	@Override
	public ArrayList<StationSurcharge> StationsSurchargees() {
		// TODO Auto-generated method stub
		
		//ArrayList<Station> listStationSurcharge=new ArrayList<Station>();
		
		ArrayList<StationSurcharge> listStationSurcharge=new ArrayList<StationSurcharge>();
		List<Station> listStations=stationrepo.findAll();
		for(Station st:listStations)
		{

			
			Date date1=new Date();
			Date date2=new Date();
			date1.setMinutes(0);
			date1.setSeconds(0);
			date1.setHours(date1.getHours()-4);
			date2.setMinutes(0);
			date2.setSeconds(0);
			date2.setHours(date2.getHours()+1);
			
			List<Ligne> listLigne=lignerepo.findAll();
			for(Ligne l:listLigne)
			{

				//List<Ticket> listTicket=ticketrepo.findByStationDepandDate(st.getId(), date1, date2);
				List<Ticket> listTicket=ticketrepo.findByStationDepandDateandLigneBus(st.getId(), l.getId(), date1, date2);
				if(listTicket.size()>3)
				{
					StationSurcharge stationsurcharge=new StationSurcharge();
					stationsurcharge.setNom(st.getNom());
					stationsurcharge.setLigne(l.getNom());
					stationsurcharge.setDirection(st.getDirection());
					
					listStationSurcharge.add(stationsurcharge);
					//System.out.println("date1: "+date1);
					//System.out.println("date2: "+date2);
				}	
			}
			
			/*
			List<Ticket> listTicket=ticketrepo.findByStationDepandDate(st.getId(), date1, date2);
			
			if(listTicket.size()>3)
			{
				listStationSurcharge.add(st);
				//System.out.println("date1: "+date1);
				//System.out.println("date2: "+date2);
			}	*/		
		}				
		return listStationSurcharge;
	}


	@Override
	public ArrayList<StationBean2> AllStations() {
		// TODO Auto-generated method stub
		
		ArrayList<StationBean2> stationBean=new ArrayList<StationBean2>();
		List<Station> stations=stationrepo.findAll();
		
		for(Station st:stations)
		{
			StationBean2 newStationBean=new StationBean2();
			newStationBean.setId(st.getId());
			newStationBean.setNom(st.getNom());
			newStationBean.setX_station(st.getLatitude());
			newStationBean.setY_station(st.getLongitude());
			newStationBean.setDirection(st.getDirection());
			stationBean.add(newStationBean);
		}
		return stationBean;
	}

}
