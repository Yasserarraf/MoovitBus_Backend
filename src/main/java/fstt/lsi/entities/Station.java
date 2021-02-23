package fstt.lsi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Collection;

@Entity

public class Station implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private double x_station;
    private double y_station;
    private String direction;

    @ManyToMany
    @JoinTable(name="ligne_station",joinColumns= @JoinColumn(name="id_station"),inverseJoinColumns=@JoinColumn(name="id_ligne_bus"))
    private Collection<Ligne> lignes  ;


    @JsonIgnore
    public Collection<Ligne> getLignes() {
        return lignes;
    }


	public Station() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Station(int id, String nom, double x_station, double y_station, String direction, Collection<Ligne> lignes) {
		super();
		this.id = id;
		this.nom = nom;
		this.x_station = x_station;
		this.y_station = y_station;
		this.direction = direction;
		this.lignes = lignes;
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

	@JsonSetter
	public void setLignes(Collection<Ligne> lignes) {
		this.lignes = lignes;
	}

    

}
