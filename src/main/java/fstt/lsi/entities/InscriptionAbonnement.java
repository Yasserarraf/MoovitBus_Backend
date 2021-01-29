package fstt.lsi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class InscriptionAbonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CodeAbonne;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_abonnement")
    private Abonnement abonnement;
    @ManyToOne
    @JoinColumn(name = "id_ligne")
    private Ligne ligne ;

    private int payee;
    
    
    

    public InscriptionAbonnement(String codeAbonne, Client client, Abonnement abonnement, Ligne ligne) {
        CodeAbonne = codeAbonne;
        this.client = client;
        this.abonnement = abonnement;
        this.ligne = ligne;
    }
    
    

	public InscriptionAbonnement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeAbonne() {
		return CodeAbonne;
	}

	public void setCodeAbonne(String codeAbonne) {
		CodeAbonne = codeAbonne;
	}
	@JsonIgnore
	public Client getClient() {
		return client;
	}
	@JsonSetter
	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnore
	public Abonnement getAbonnement() {
		return abonnement;
	}
	@JsonSetter
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	@JsonIgnore
	public Ligne getLigne() {
		return ligne;
	}
	@JsonSetter
	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}

	public int getPayee() {
		return payee;
	}
	
	public void setPayee(int payee) {
		this.payee = payee;
	}
    
    
	
}
