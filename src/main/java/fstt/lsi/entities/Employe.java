package fstt.lsi.entities;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employe")
public class Employe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true )
	private int id ;
	@Column()
	private String nom ;
	@Column()
	private String prenom ;
	@Column()
	 private String email;
	@Column()
	 private String password;
	@Column()
	 private String num_tel ;
	@Column()
	private String role ;
	@ManyToOne
	@JoinColumn (name="id_bus")
	private Bus bus ;
	
	@OneToMany
	@JoinColumn (name="id_employe")
	private List<Cas_Urgent> listcasurgent ;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public List<Cas_Urgent> getListcasurgent() {
		return listcasurgent;
	}
	public void setListcasurgent(List<Cas_Urgent> listcasurgent) {
		this.listcasurgent = listcasurgent;
	}
	
	

}
