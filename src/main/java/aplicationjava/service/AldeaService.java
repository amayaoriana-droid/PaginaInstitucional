package aplicationjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicationjava.Iservice.IAldeaService;
import aplicationjava.entity.Aldea;
import aplicationjava.repository.AldeaRepository;

@Service
public class AldeaService implements IAldeaService {

	@Autowired
	private AldeaRepository aRepository; 
	
	@Override 
	public List<Aldea> findAllAldeas(){
		return aRepository.findAll();
	}
	
	@Override 
	public Optional<Aldea> findAllAldeaById(Long id) {
		return aRepository.findById(id);
	}

	@Override
	public Aldea saveAldea(Aldea aldea) {
		return aRepository.save(aldea);
	}

	 
}
