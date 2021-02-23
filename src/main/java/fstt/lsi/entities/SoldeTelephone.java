package fstt.lsi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class SoldeTelephone implements Serializable {

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String num_tel;
    private String nom_porteur;
    private double solde;
    private String email;
    private int confirmation;
	public SoldeTelephone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SoldeTelephone(int id, String num_tel, String nom_porteur, double solde, String email, int confirmation) {
		super();
		this.id = id;
		this.num_tel = num_tel;
		this.nom_porteur = nom_porteur;
		this.solde = solde;
		this.email = email;
		this.confirmation = confirmation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	public String getNom_porteur() {
		return nom_porteur;
	}
	public void setNom_porteur(String nom_porteur) {
		this.nom_porteur = nom_porteur;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getConfirmation() {
		return confirmation;
	}
	public void setConfirmation(int confirmation) {
		this.confirmation = confirmation;
	}
    
    

}
