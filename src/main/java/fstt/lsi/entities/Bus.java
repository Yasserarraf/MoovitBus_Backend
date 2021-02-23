package fstt.lsi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fstt.lsi.entities.*;


@Entity
@Table(name="bus")
public class Bus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true )
	private int id;
	@Column()
	private float Latitude;
	@Column()
	private float longitude;
	@Column()
	private String direction;
	@Column()
	private float distance_dep;
	@Column()
	private float vitesse;
	@ManyToOne
	@JoinColumn (name="id_ligne_bus")
	private Ligne lignebus ;

	@OneToMany
	@JoinColumn (name="id_bus")
	private List<Employe> listchauffeur;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Bus(int id, float latitude, float longitude, String direction, float distance_dep, float vitesse,
			Ligne lignebus) {
		super();
		this.id = id;
		Latitude = latitude;
		this.longitude = longitude;
		this.direction = direction;
		this.distance_dep = distance_dep;
		this.vitesse = vitesse;
		this.lignebus = lignebus;
	}


	public float getDistance_dep() {
		return distance_dep;
	}
	public void setDistance_dep(float distance_dep) {
		this.distance_dep = distance_dep;
	}
	public float getVitesse() {
		return vitesse;
	}
	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
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
	public Ligne getLignebus() {
		return lignebus;
	}
	public void setLignebus(Ligne lignebus) {
		this.lignebus = lignebus;
	}
	

}
