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

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
public class InformationCompte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom_porteur;
    private String numPaiement;
    private String moisExpiration;
    private String anneeExpiration;
    private String codeVerification;
    private String email;
    private double solde;
    private int confimation;

    public InformationCompte(String nom_porteur, String numPaiement, String moisExpiration,String anneeExpiration, String codeVerification,String email) {
        this.nom_porteur = nom_porteur;
        this.numPaiement = numPaiement;
        this.moisExpiration = moisExpiration;
        this.codeVerification = codeVerification;
        this.anneeExpiration = anneeExpiration;
        this.email=email;
    }

	public InformationCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_porteur() {
		return nom_porteur;
	}

	public void setNom_porteur(String nom_porteur) {
		this.nom_porteur = nom_porteur;
	}

	public String getNumPaiement() {
		return numPaiement;
	}

	public void setNumPaiement(String numPaiement) {
		this.numPaiement = numPaiement;
	}

	public String getMoisExpiration() {
		return moisExpiration;
	}

	public void setMoisExpiration(String moisExpiration) {
		this.moisExpiration = moisExpiration;
	}

	public String getAnneeExpiration() {
		return anneeExpiration;
	}

	public void setAnneeExpiration(String anneeExpiration) {
		this.anneeExpiration = anneeExpiration;
	}

	public String getCodeVerification() {
		return codeVerification;
	}

	public void setCodeVerification(String codeVerification) {
		this.codeVerification = codeVerification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getConfimation() {
		return confimation;
	}

	public void setConfimation(int confimation) {
		this.confimation = confimation;
	}
    
    
}