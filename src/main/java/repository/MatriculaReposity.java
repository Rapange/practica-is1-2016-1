package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Alumno;
import domain.Matricula;

public interface MatriculaReposity extends CrudRepository<Matricula,Long> {
	List<Matricula> findAll();
	
	@Query("SELECT c FROM Matricula AS c WHERE semestre = :semestre AND curso_codigo = :curso_codigo")
	List<Alumno> findBySemestreCurso(String semestre, String curso_codigo);
}
