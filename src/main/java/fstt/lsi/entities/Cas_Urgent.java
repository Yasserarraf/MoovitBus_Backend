package fstt.lsi.entities;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="cas_urgent")
public class Cas_Urgent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true )
	private int id;
	@Column()
	private String type ;
	@Column()
	private String date ;
	
	@ManyToOne
	@JoinColumn (name="id_employe")
	private Employe employe ;

	public Cas_Urgent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cas_Urgent(int id, String type  , Employe employe , String date) {
		super();
		this.id = id;
		this.type = type;
		this.date = date ;
		this.employe = employe;
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

