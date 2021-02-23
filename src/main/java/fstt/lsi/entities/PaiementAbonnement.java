package fstt.lsi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class PaiementAbonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date datepaiement;

    @OneToOne
    @JoinColumn(name="id_inscription")
    private InscriptionAbonnement InscriAbn;

    public PaiementAbonnement(Date datepaiement, InscriptionAbonnement inscriAbn) {
        this.datepaiement = datepaiement;
        InscriAbn = inscriAbn;
    }

	public PaiementAbonnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaiementAbonnement(int id, Date datepaiement) {
		super();
		this.id = id;
		this.datepaiement = datepaiement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatepaiement() {
		return datepaiement;
	}

	public void setDatepaiement(Date datepaiement) {
		this.datepaiement = datepaiement;
	}

	public InscriptionAbonnement getInscriAbn() {
		return InscriAbn;
	}

	public void setInscriAbn(InscriptionAbonnement inscriAbn) {
		InscriAbn = inscriAbn;
	}
    
    
}