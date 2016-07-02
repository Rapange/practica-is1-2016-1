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

@Entity
public class Curso implements BaseEntity<Long> {
	@Id
	@SequenceGenerator(name = "Curso_ID_GENERATOR", sequenceName = "Curso_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Curso_ID_GENERATOR")	
	
	private Long id;

	@Id
	private String codigo;

	private String nombre;

	private Integer creditos;

	@ManyToMany
	@JoinTable(name = "Prerequisitos",
		joinColumns = @JoinColumn(name = "Curso_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "Curso_prerequisito_id", referencedColumnName = "id"))
	private List<Curso> prerequisitos;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public List<Curso> getPrerequisitos() {
		return prerequisitos;
	}

	public void setPrerequisitos(List<Curso> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

}
