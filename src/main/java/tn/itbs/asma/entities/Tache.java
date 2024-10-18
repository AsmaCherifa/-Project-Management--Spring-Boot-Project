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
public class Tache {

	@Id
	private int id;
	private String titre;
	private String description;
	private Date dateEcheance;
	private Statut statut;

    public enum Statut {
        en_attente,
        en_cours,
        terminee
    }
    
    @ManyToOne
	@JoinColumn(name="idp")
	private Projet projet;
    
    @OneToMany (mappedBy = "tache")
	
	private ArrayList<etiquette> ListeE = new ArrayList<etiquette>();
}
