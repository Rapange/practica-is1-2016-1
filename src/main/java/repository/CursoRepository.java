package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Curso;

public interface CursoRepository extends CrudRepository<Curso,Long>{
	List<Curso> findAll();
	@Query("SELECT c FROM Curso AS c WHERE codigo = :codigo")
	Curso findByCodigo(String codigo);
}
