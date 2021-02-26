package fstt.lsi.bean;

public class StationSurcharge {
	
	private String nom;
	private String ligne;
	private String direction;
	public StationSurcharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public StationSurcharge(String nom, String ligne, String direction) {
		super();
		this.nom = nom;
		this.ligne = ligne;
		this.direction = direction;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLigne() {
		return ligne;
	}
	public void setLigne(String ligne) {
		this.ligne = ligne;
	}
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
