package aplicationjava.Iservice;

import java.util.List;
import java.util.Optional;

import aplicationjava.entity.Aldea;

public interface IAldeaService {


	List<Aldea> findAllAldeas();

	Optional<Aldea> findAllAldeaById(Long id);

	Aldea saveAldea(Aldea aldea);

}
