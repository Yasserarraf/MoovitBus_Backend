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


@Entity
@Table(name="ligne_bus")

public class Ligne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "ligne")
    private Collection<InscriptionAbonnement> listInscriptionAbn;

    @ManyToMany(mappedBy="lignes")
    private Collection<Station> stations;

    @JsonIgnore
    public Collection<InscriptionAbonnement> getListInscriptionAbn() {
        return listInscriptionAbn;
    }
    @JsonSetter
    public void setListInscriptionAbn(Collection<InscriptionAbonnement> listInscriptionAbn) {
        this.listInscriptionAbn = listInscriptionAbn;
    }
	public Ligne() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne(int id, String nom, Collection<Station> stations) {
		super();
		this.id = id;
		this.nom = nom;
		this.stations = stations;
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
	@JsonIgnore
	public Collection<Station> getStations() {
		return stations;
	}
	@JsonSetter
	public void setStations(Collection<Station> stations) {
		this.stations = stations;
	}

    

}