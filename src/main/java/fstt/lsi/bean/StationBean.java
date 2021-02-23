package fstt.lsi.bean;



public class StationBean {
	
	
	
	private int id;
	
	private String nom;
	
	private double Latitude;
	
	private double longitude;

	public StationBean(int id, String nom, double latitude, double longitude) {
		super();
		this.id = id;
		this.nom = nom;
		Latitude = latitude;
		this.longitude = longitude;
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

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	

}
