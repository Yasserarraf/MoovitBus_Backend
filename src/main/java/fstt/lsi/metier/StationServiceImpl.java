package fstt.lsi.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstt.lsi.DAO.StationDAO;
import fstt.lsi.DAO.TicketDao;
import fstt.lsi.entities.Station;
import fstt.lsi.entities.Ticket;
@Service
public class StationServiceImpl implements StationServices{
	@Autowired
	private StationDAO stationrepo;
	
	@Autowired
	private TicketDao ticketrepo;
	

	@Override
	public ArrayList<Station> StationsSurchargees() {
		// TODO Auto-generated method stub
		
		ArrayList<Station> listStationSurcharge=new ArrayList<Station>();
		List<Station> listStations=stationrepo.findAll();
		for(Station st:listStations)
		{

			
			Date date1=new Date();
			Date date2=new Date();
			date1.setMinutes(0);
			date1.setSeconds(0);
			date1.setHours(date1.getHours()-2);
			date2.setMinutes(0);
			date2.setSeconds(0);
			date2.setHours(date2.getHours()+1);
			
			
			List<Ticket> listTicket=ticketrepo.findByStationDepandDate(st.getId(), date1, date2);
			
			if(listTicket.size()>3)
			{
				listStationSurcharge.add(st);
				//System.out.println("date1: "+date1);
				//System.out.println("date2: "+date2);
			}			
		}				
		return listStationSurcharge;
	}

}
