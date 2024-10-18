package tn.itbs.asma.entities;

import java.sql.Date;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Projet {
	@Id
	private int id;
	private String NomProjet;
	
	private String description;
	private Date dateDebut;
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="idu")
	private Utilisateur user;
	
	@OneToMany (mappedBy = "projet")
	
	private ArrayList<Tache> ListeT = new ArrayList<Tache>();
}
