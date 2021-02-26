package fstt.lsi.bean;

public class StationBean2 {
	

	private int id;
	
	private String nom;
	
	private double x_station;
	
	private double y_station;
	private String direction ;
	public StationBean2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StationBean2(int id, String nom, double x_station, double y_station, String direction) {
		super();
		this.id = id;
		this.nom = nom;
		this.x_station = x_station;
		this.y_station = y_station;
		this.direction = direction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getX_station() {
		return x_station;
	}
	public void setX_station(double x_station) {
		this.x_station = x_station;
	}
	public double getY_station() {
		return y_station;
	}
	public void setY_station(double y_station) {
		this.y_station = y_station;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
	

}
