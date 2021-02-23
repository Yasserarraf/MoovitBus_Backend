package fstt.lsi.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data@AllArgsConstructor@NoArgsConstructor@ToString
public  class InformationInscription {
    private int id_abonnement;
    private int id_ligne;
    private int id_clt;
	public int getId_abonnement() {
		return id_abonnement;
	}
	
	
	
	
	public InformationInscription() {
		super();
		// TODO Auto-generated constructor stub
	}




	public InformationInscription(int id_abonnement, int id_ligne, int id_clt) {
		super();
		this.id_abonnement = id_abonnement;
		this.id_ligne = id_ligne;
		this.id_clt = id_clt;
	}




	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}
	public int getId_ligne() {
		return id_ligne;
	}
	public void setId_ligne(int id_ligne) {
		this.id_ligne = id_ligne;
	}
	public int getId_clt() {
		return id_clt;
	}
	public void setId_clt(int id_clt) {
		this.id_clt = id_clt;
	}
    
    
    
    

}
