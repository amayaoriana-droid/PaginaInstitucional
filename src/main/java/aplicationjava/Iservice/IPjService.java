package aplicationjava.Iservice;

import java.util.List;
import java.util.Optional;

import aplicationjava.entity.Pj;

public interface IPjService {

	List<Pj> findAllCharacters();

	Pj saveCharacter(Pj pj);

	Optional<Pj> findAllCharacterById(Long id);

	
	
}
