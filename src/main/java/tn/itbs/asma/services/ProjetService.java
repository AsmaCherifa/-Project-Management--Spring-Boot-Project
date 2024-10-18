package tn.itbs.asma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tn.itbs.asma.entities.Projet;
import tn.itbs.asma.repositories.ProjetRepo;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepo projetRepo;

    public Projet createProjet(Projet projet) {
        return projetRepo.save(projet);
    }

    public ResponseEntity<String> addProject(Projet projet) {
        projetRepo.findById(projet.getId()).ifPresentOrElse(
            (existingProject) -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet Existe deja");
            },
            () -> {
                projetRepo.save(projet);
            }
        );
        
        return ResponseEntity.accepted().body("Procjet added : " + projet.getNomProjet());
    }

    
    public ResponseEntity<Projet> searchProject(Integer id) {
        return projetRepo.findById(id)
            .map(existingProject -> ResponseEntity.ok(existingProject))  // If found, return the project with 200 OK
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet not found"));  // If not found, throw 404 Not Found
    }

    
    

    public Projet updateProjet(Integer id, Projet projet) {
        projet.setId(id);
        return projetRepo.save(projet);
    }

    public void deleteProjet(Integer id) {
        projetRepo.deleteById(id);
    }

    public List<Projet> getAllProjets() {
        return projetRepo.findAll();
    }
}
