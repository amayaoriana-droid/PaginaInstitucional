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

import aplicationjava.Iservice.IPjService;
import aplicationjava.entity.Pj;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "*")

public class PjController {

	@Autowired 
	private IPjService ipjService;
	
	@GetMapping
	public List<Pj>getAllCharacters(){
		return ipjService.findAllCharacters();
	}
	
	@GetMapping("/demonslayer/{id}")
	public Optional<Pj> getCharacterById(@PathVariable Long id) {
		return ipjService.findAllCharacterById(id);
	}
	
	@PostMapping 
	public Pj createCharacter(@RequestBody Pj pj) {
		return ipjService.saveCharacter(pj);
	}
}
