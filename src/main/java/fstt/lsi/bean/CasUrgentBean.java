package fstt.lsi.bean;

public class CasUrgentBean {
	
	
	
	private int id;
	private String type;
	private BusBean bus;
	private String date;
	
	public CasUrgentBean(int id, String type, BusBean bus, String date) {
		super();
		this.id = id;
		this.type = type;
		this.bus = bus;
		this.date = date;
	}
	
	public BusBean getBus() {
		return bus;
	}

	public void setBus(BusBean bus) {
		this.bus = bus;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
