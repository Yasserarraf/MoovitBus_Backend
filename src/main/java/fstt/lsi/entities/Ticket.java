package fstt.lsi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Entity
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_client;
    private int id_ligne_bus;
    private double prix;
    private Date date;
    private int station_dep;
    private int station_des;
    private int methodPaiement;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int id, int id_client, int id_ligne_bus, double prix, Date date, int station_dep, int station_des,
			int methodPaiement) {
		super();
		this.id = id;
		this.id_client = id_client;
		this.id_ligne_bus = id_ligne_bus;
		this.prix = prix;
		this.date = date;
		this.station_dep = station_dep;
		this.station_des = station_des;
		this.methodPaiement = methodPaiement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getId_ligne_bus() {
		return id_ligne_bus;
	}
	public void setId_ligne_bus(int id_ligne_bus) {
		this.id_ligne_bus = id_ligne_bus;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getStation_dep() {
		return station_dep;
	}
	public void setStation_dep(int station_dep) {
		this.station_dep = station_dep;
	}
	public int getStation_des() {
		return station_des;
	}
	public void setStation_des(int station_des) {
		this.station_des = station_des;
	}
	public int getMethodPaiement() {
		return methodPaiement;
	}
	public void setMethodPaiement(int methodPaiement) {
		this.methodPaiement = methodPaiement;
	}
    
    
}
