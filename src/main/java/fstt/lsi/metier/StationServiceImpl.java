package fstt.lsi.metier;

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
	public List<Station> StationsSurchargees() {
		// TODO Auto-generated method stub
		//List<Ticket> listTicket;
		List<Station> listStations=stationrepo.findAll();
		for(Station st:listStations)
		{
		//	List<Ticket> listTicket=ticketrepo.findByDateandStationDep(new Date(), st.getId());
			
		}
		
		
		return null;
	}

}
