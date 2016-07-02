package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Matricula implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Matricula_ID_GENERATOR", sequenceName = "Matricula_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Matricula_ID_GENERATOR")	
	private Long id;

	@OneToMany(mappedBy = "id")
	private String curso_codigo;

	@OneToMany(mappedBy = "id")
	private Long alumno_id;

	private Double nota;

	private String semestre;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCursoId() {
		return curso_codigo;
	}

	public void setCursoId(String curso) {
		this.curso_codigo = curso;
	}

	public Long getAlumnoId() {
		return alumno_id;
	}

	public void setAlumnoId(Long alumno) {
		this.alumno_id = alumno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
