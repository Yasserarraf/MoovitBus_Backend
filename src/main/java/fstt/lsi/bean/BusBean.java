package fstt.lsi.bean;



public class BusBean {
	
	
	private int id;
	
	private float Latitude;
	
	private float longitude;
	
	private String direction;
	
	private float temps_Restant;

	

	public BusBean(int id, float latitude, float longitude, String direction, float temps_Restant) {
		super();
		this.id = id;
		Latitude = latitude;
		this.longitude = longitude;
		this.direction = direction;
		this.temps_Restant = temps_Restant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void setLatitude(float latitude) {
		Latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public float getTemps_Restant() {
		return temps_Restant;
	}

	public void setTemps_Restant(float temps_Restant) {
		this.temps_Restant = temps_Restant;
	}
	
	

}
