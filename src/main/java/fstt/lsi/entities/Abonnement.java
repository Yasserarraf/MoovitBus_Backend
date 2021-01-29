package fstt.lsi.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public  class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private float prix;
    @OneToMany(mappedBy = "abonnement")
    private Collection<InscriptionAbonnement> listInscriptionAbn;


    @JsonIgnore
    public Collection<InscriptionAbonnement> getListInscriptionAbn() {
        return listInscriptionAbn;
    }

    public void setListInscriptionAbn(Collection<InscriptionAbonnement> listInscriptionAbn) {
        this.listInscriptionAbn = listInscriptionAbn;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                '}';
    }

	public Abonnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Abonnement(int id, String type, float prix, Collection<InscriptionAbonnement> listInscriptionAbn) {
		super();
		this.id = id;
		this.type = type;
		this.prix = prix;
		this.listInscriptionAbn = listInscriptionAbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
    
    
    
}