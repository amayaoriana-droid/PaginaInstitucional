package aplicationjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicationjava.Iservice.IPoderService;
import aplicationjava.entity.Poder;
import aplicationjava.repository.PoderRepository;
;

@Service
public class PoderService implements IPoderService {

	@Autowired
	private PoderRepository poderRepository; 
	
	@Override 
	public List<Poder> findAllPoderes(){
		return poderRepository.findAll();
	}
	
	@Override 
	public Poder savePoder(Poder poder) {
		return poderRepository.save(poder);
	}
	
	@Override 
	public Optional<Poder> findAllPoderById(Long id) {
		return poderRepository.findById(id);
	}

	
}
