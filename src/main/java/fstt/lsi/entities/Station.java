package fstt.lsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="station")
public class Station implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true )
	private int id;
	@Column()
	private String nom;
	@Column(name="x_station")
	private float Latitude;
	@Column(name="y_station")
	private float longitude;
	@Column()
	private String direction ;
	
	@ManyToMany
	@JoinTable(name = "ligne_station" , joinColumns =  @JoinColumn(name = "id_station"),
	inverseJoinColumns = @JoinColumn(name = "id_ligne_bus") )
	private List<Ligne> lignes ;

	public Station(int id, String nom, float latitude, float longitude, String direction, List<Ligne> lignes) {
		super();
		this.id = id;
		this.nom = nom;
		Latitude = latitude;
		this.longitude = longitude;
		this.direction = direction;
		this.lignes = lignes;
	}

	public Station() {
		super();
		// TODO Auto-generated constructor stub
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
	@JsonIgnore
	public List<Ligne> getLignes() {
		return lignes;
	}
@JsonSetter
	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}

	
}
