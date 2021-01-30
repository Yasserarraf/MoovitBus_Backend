package fstt.lsi.entities;

import java.util.ArrayList;
import java.util.Collection;

public class ClientClone extends Client {
	private Collection<InscriptionAbonnementClone> inscriptionAbonnements;
	
	public ClientClone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientClone(int id, String nom, String prenom, String email, String password, String num_tel, int abonne) {
		super(id, nom, prenom, email, password, num_tel, abonne);
		// TODO Auto-generated constructor stub
	}

	public ClientClone(Client client) {
		super(client.getId(), client.getNom(), client.getPrenom(),client.getEmail(),
				client.getPassword(), client.getNum_tel(), client.getAbonne());
		this.inscriptionAbonnements = new ArrayList();
		
		for(InscriptionAbonnement insabn : client.getListInscriptionAbn()) {
			this.inscriptionAbonnements.add(new InscriptionAbonnementClone(insabn));
		}
	}

	public Collection<InscriptionAbonnementClone> getInscriptionAbonnements() {
		return inscriptionAbonnements;
	}

	public void setInscriptionAbonnements(Collection<InscriptionAbonnementClone> inscriptionAbonnements) {
		this.inscriptionAbonnements = inscriptionAbonnements;
	}

}

class InscriptionAbonnementClone extends InscriptionAbonnement{
	private Ligne ligneBus;

	public InscriptionAbonnementClone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InscriptionAbonnementClone(String codeAbonne, Client client, Abonnement abonnement, Ligne ligne) {
		super(codeAbonne, client, abonnement, ligne);
		// TODO Auto-generated constructor stub
	}
	
	public InscriptionAbonnementClone(InscriptionAbonnement insabn) {
		this.setId(insabn.getId());
		this.setCodeAbonne(insabn.getCodeAbonne());
		this.setPayee(insabn.getPayee());
		
		this.ligneBus = insabn.getLigne();
	}

	public Ligne getLigneBus() {
		return ligneBus;
	}

	public void setLigneBus(Ligne ligneBus) {
		this.ligneBus = ligneBus;
	}
	
	
	
}
