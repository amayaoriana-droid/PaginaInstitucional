package aplicationjava.Iservice;

import java.util.List;
import java.util.Optional;

import aplicationjava.entity.Poder;

public interface IPoderService {


	List<Poder> findAllPoderes();

	Optional<Poder> findAllPoderById(Long id);

	Poder savePoder(Poder poder);

}
