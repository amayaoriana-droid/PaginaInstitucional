package aplicationjava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aplicationjava.Iservice.IAldeaService;
import aplicationjava.entity.Aldea;

@RestController
@RequestMapping("/api/aldea")
@CrossOrigin(origins = "*")

public class AldeaController {

	@Autowired 
	private IAldeaService ialdeaService;
	
	@GetMapping
	public List<Aldea>getAllCharacters(){
		return ialdeaService.findAllAldeas();
	}
	
	@GetMapping("/demonslayerAldea/{id}")
	public Optional<Aldea> getCharacterById(@PathVariable Long id) {
		return ialdeaService.findAllAldeaById(id);
	}
	
	@PostMapping 
	public Aldea createCharacter(@RequestBody Aldea aldea) {
		return ialdeaService.saveAldea(aldea);
	}
}
