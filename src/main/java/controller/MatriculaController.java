package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import domain.Alumno;
import domain.Curso;
import domain.Matricula;
import repository.AlumnoRepository;
import repository.CursoRepository;
import repository.MatriculaReposity;

@RestController
public class MatriculaController {
	@Autowired
	AlumnoRepository alumnoRepositorio;

	@Autowired
	CursoRepository cursoRepositorio;

	@Autowired
	MatriculaReposity matriculaRepositorio;
	
	@RequestMapping(value = "/alumnos", method = RequestMethod.POST)
	@ResponseBody
	public Alumno guardarAlumno(@RequestBody Alumno alumno){
		return alumnoRepositorio.save(alumno);
	}
	//@RequestMapping("/alumnos")
	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	@ResponseBody
	public List<Alumno> alumnos() {
		return alumnoRepositorio.findAll();
	}
	
	@RequestMapping(value = "/cursos", method = RequestMethod.POST)
	@ResponseBody
	public Curso guardarCurso(@RequestBody Curso curso) {
		return cursoRepositorio.save(curso);
	}

	//@RequestMapping("/cursos")
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> cursos() {
		return cursoRepositorio.findAll();
	}

	/*@RequestMapping(value = "/matriculas", method = RequestMethod.POST)
	@ResponseBody
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
		if(flagC && flagA && !flagM && a.getCreditos()+c.getCreditos() <= 20){
			a.aumentarCreditos(c.getCreditos());
			return matriculaRepositorio.save(matricula);
			
		}
		return null;
		
	}*/
	@RequestMapping(value = "/matriculas", method = RequestMethod.GET)
	@ResponseBody
	public List<Matricula> matriculas(){
		return matriculaRepositorio.findAll();
	}
}