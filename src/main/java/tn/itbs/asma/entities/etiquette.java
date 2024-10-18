package tn.itbs.asma.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class etiquette {
	@Id
	private int id;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="idt")
	private Tache tache;
}
