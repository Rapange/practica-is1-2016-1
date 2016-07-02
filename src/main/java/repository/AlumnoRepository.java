package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import domain.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno,Long> {
	List<Alumno> findAll();
	@Query("SELECT c FROM Alumno AS c WHERE apellidoPaterno =: apellidoPaterno")
	Alumno findByApellidoPaterno(String apellidoPaterno);
	
	@Query("SELECT c FROM Alumno AS c WHERE id =: id")
	Alumno findById(Long id);
}
