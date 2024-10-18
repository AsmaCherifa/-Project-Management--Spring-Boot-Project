package tn.itbs.asma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.itbs.asma.entities.etiquette;
import tn.itbs.asma.repositories.EtiquetteRepo;

@Service

public class EtiquetteService {
	
private EtiquetteRepo etiquetteRepo;
	
	public etiquette CreateEtiquette(etiquette etiquette) {
		return etiquetteRepo.save(etiquette);
	}
	
	
	public List<etiquette> ReadEtiquette(){
		return etiquetteRepo.findAll();
	}
	
	
	public etiquette UpdateEtiquette(etiquette etiquette, Integer id) {
		etiquette etiquetteUp = etiquetteRepo.findById(id).orElseThrow();
		etiquetteUp.setLibelle(etiquette.getLibelle());
		return etiquetteRepo.save(etiquetteUp);
	}
	
	public void DeleteEtiquette(Integer id) {
		etiquetteRepo.deleteById(id);
	}
}
