package tn.itbs.asma.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data

public class Utilisateur {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
	private String surname;
	@NotBlank(message = "login cannot be empty")
	private String login;
	@NotBlank(message = "mdp cannot be empty")
	private String mdp;
	@Column (unique=true)
	private String email;
	
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference

	private List<Projet> ListeP = new ArrayList<>();
	
	
	
}
