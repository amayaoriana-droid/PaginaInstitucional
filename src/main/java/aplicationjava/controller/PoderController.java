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

import aplicationjava.Iservice.IPoderService;
import aplicationjava.entity.Poder;

@RestController
@RequestMapping("/api/poder")
@CrossOrigin(origins = "*")

public class PoderController {

	@Autowired 
	private IPoderService ipoderService;
	
	@GetMapping
	public List<Poder>getAllCharacters(){
		return ipoderService.findAllPoderes();
	}
	
	@GetMapping("/demonslayerPoder/{id}")
	public Optional<Poder> getCharacterById(@PathVariable Long id) {
		return ipoderService.findAllPoderById(id);
	}
	
	@PostMapping 
	public Poder createCharacter(@RequestBody Poder poder) {
		return ipoderService.savePoder(poder);
	}
}
