package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Alumno;
import domain.Curso;
import domain.Matricula;
import repository.AlumnoRepository;
import repository.CursoRepository;
import repository.MatriculaReposity;

@Service
public class MatriculaService {
	
	AlumnoRepository alumnoRepositorio;
	CursoRepository cursoRepositorio;
	MatriculaReposity matriculaRepositorio;
	
	public MatriculaService(AlumnoRepository ar, CursoRepository cr, MatriculaReposity mr){
		this.alumnoRepositorio = ar;
		this.cursoRepositorio = cr;
		this.matriculaRepositorio = mr;
	}
	
	public Matricula guardarMatricula(@RequestBody Matricula matricula){
		boolean flagC = false, flagA = false, flagM = false;
		List<Curso> Cursos = cursoRepositorio.findAll();
		List<Alumno> Alumnos = alumnoRepositorio.findAll();
		List<Matricula> Matriculas = matriculaRepositorio.findAll();
		Alumno a = alumnoRepositorio.findById(matricula.getAlumnoId());
		Curso c = cursoRepositorio.findByCodigo(matricula.getCursoId());
		for(Curso i : Cursos){
			if(i.getCodigo().equals(matricula.getCursoId())){
				flagC = true;
				break;
			}
		}
		for(Alumno i : Alumnos){
			if(i.getId().intValue() == matricula.getAlumnoId().intValue()){
				flagA = true;
				break;
			}
		}
		for(Matricula i : Matriculas){
			if(i.getId().intValue() == matricula.getId().intValue() && i.getAlumnoId().intValue() == matricula.getAlumnoId().intValue()){
				flagM = true;
				break;
			}
		}
		if(flagC && flagA && !flagM){
			if(a.getDesaprobados().size() == 0){
				if(a.getCreditos()+c.getCreditos() <= 20){
					a.aumentarCreditos(c.getCreditos());
					return matriculaRepositorio.save(matricula);
				}
				
			}
			else{
				if(a.findCurso(c) != null){
					if(a.getCreditos()+c.getCreditos() <= 16){
						a.aumentarCreditos(c.getCreditos());
						return matriculaRepositorio.save(matricula);
					}
				}
			}
			
		}
		return null;
		
	}
	@RequestMapping(value = "/matriculas", method = RequestMethod.GET)
	@ResponseBody
	public List<Matricula> matriculas(){
		return matriculaRepositorio.findAll();
	}
}
