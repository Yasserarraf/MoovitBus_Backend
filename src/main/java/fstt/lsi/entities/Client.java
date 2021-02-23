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
//@Data
//@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String num_tel;
    private int abonne;

    public Client() {
    }

    @OneToMany(mappedBy = "client")
    private Collection<InscriptionAbonnement> listInscriptionAbn;


    @JsonIgnore
    public Collection<InscriptionAbonnement> getListInscriptionAbn() {
        return listInscriptionAbn;
    }
    @JsonSetter
    public void setListInscriptionAbn(Collection<InscriptionAbonnement> listInscriptionAbn) {
        this.listInscriptionAbn = listInscriptionAbn;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", num_tel='" + num_tel + '\'' +
                ", abonne=" + abonne;
    }
    
    
	public Client(int id, String nom, String prenom, String email, String password, String num_tel, int abonne) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.num_tel = num_tel;
		this.abonne = abonne;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	public int getAbonne() {
		return abonne;
	}
	public void setAbonne(int abonne) {
		this.abonne = abonne;
	}
    
    
}

