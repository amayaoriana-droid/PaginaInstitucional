package aplicationjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicationjava.Iservice.IPjService;
import aplicationjava.entity.Pj;
import aplicationjava.repository.PjRepository;

@Service
public class PjService implements IPjService {

	@Autowired
	private PjRepository pRepository; 
	
	@Override 
	public List<Pj> findAllCharacters(){
		return pRepository.findAll();
	}
	
	@Override 
	public Pj saveCharacter(Pj pj) {
		return pRepository.save(pj);
	}
	
	@Override 
	public Optional<Pj> findAllCharacterById(Long id) {
		return pRepository.findById(id);
	}
	
	
	
}
