package fstt.lsi.metier;

import java.util.ArrayList;
import java.util.List;

import fstt.lsi.bean.StationBean2;
import fstt.lsi.entities.Station;

public interface StationServices {
	
		
		List<Station> StationsSurchargees();

		ArrayList<StationBean2> AllStations();
		
		


}
