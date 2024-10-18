package tn.itbs.asma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itbs.asma.entities.Tache;
import tn.itbs.asma.repositories.TacheRepo;

@Service

public class TacheService {
private TacheRepo tacheRepo;
	
	
	public Tache CreateTask(Tache task) {
		return tacheRepo.save(task);
	}
	/*
	 methode 1
	public Tache ReadTaskById(Integer id){
		return tacheRepo.findById(id).get();
	}
	*/
// methode 2
// on utlise optional qd on a findby

	public Optional<Tache> ReadTaskById(Integer id){
		return tacheRepo.findById(id);
	}
	
	
	public Tache UpdateTask(Tache task, Integer id) {
		Tache taskUp = tacheRepo.findById(id).orElseThrow();
		taskUp.setTitre(task.getTitre());
		taskUp.setDescription(task.getDescription());
		taskUp.setStatut(task.getStatut());
		taskUp.setDateEcheance(task.getDateEcheance());
		return tacheRepo.save(taskUp);
	}
	
	public void DeleteTask(Integer id) {
		tacheRepo.deleteById(id);
	}
	
	
	/*
	public List<Tache> SearchTaskByProjectId(Integer idP){
		return tacheRepo.findByProjectId(idP);
		
	}
	
	  */
}
