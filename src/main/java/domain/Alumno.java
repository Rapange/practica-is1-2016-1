package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import domain.Curso;


@Entity
public class Alumno implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Alumno_ID_GENERATOR", sequenceName = "Alumno_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Alumno_ID_GENERATOR")	
	
	private Long id;

	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String dni;
	
	private Integer creditos;

	@ManyToMany
	@JoinTable(name = "Alumno_curso",
		joinColumns = @JoinColumn(name = "Alumno_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "Curso_id", referencedColumnName = "id"))
	private List<Curso> desaprobados;
	
	public Alumno(){
		
	}
	
	public Alumno(String nombres, String apellidoPaterno, String apellidoMaterno, String dni){
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.dni = dni;
		this.creditos = 0; //Por semestre.
	}
	
	public Curso findCurso(Curso i){
		for(Curso k : desaprobados){
			if(i == k){
				return i;
			}
		}
		return null;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public List<Curso> getDesaprobados(){
		return this.desaprobados;
	}
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDNI() {
		return dni;
	}

	public void setDNI(String dNI) {
		dni = dNI;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	
	public void aumentarCreditos(Integer creditos){
		this.creditos += creditos;
	}

}
