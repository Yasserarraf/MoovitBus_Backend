package fstt.lsi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ligne_station")
public class LigneStation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true )
	private int id;
	@Column()
	private float distance;
	@Column()
	private int id_station;
	@Column()
	private int id_ligne_bus;
	public LigneStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneStation(int id, float distance, int id_station, int id_lignebus) {
		super();
		this.id = id;
		this.distance = distance;
		this.id_station = id_station;
		this.id_ligne_bus = id_lignebus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public int getId_station() {
		return id_station;
	}
	public void setId_station(int id_station) {
		this.id_station = id_station;
	}
	public int getId_lignebus() {
		return id_ligne_bus;
	}
	public void setId_lignebus(int id_lignebus) {
		this.id_ligne_bus = id_lignebus;
	}
	

}
