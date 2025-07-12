package entidad;

import java.util.Date;

public class Matricula {
	
	private int idMatricula;
	
	private String ciclo;
	
	private Date fecha;
	
	private String seccion;
	
	private Estudiante estudiante;
	
	private Docente docente;
	
	private Curso curso;
	
	private EncargadoMatricula encargadoMatricula;
	
	private String usuario;
	
	public Matricula() {}

	public Matricula(int idMatricula, String ciclo, Date fecha, String seccion, Estudiante estudiante, Docente docente,
			Curso curso, EncargadoMatricula encargadoMatricula, String usuario) {
		this.idMatricula = idMatricula;
		this.ciclo = ciclo;
		this.fecha = fecha;
		this.seccion = seccion;
		this.estudiante = estudiante;
		this.docente = docente;
		this.curso = curso;
		this.encargadoMatricula = encargadoMatricula;
		this.usuario = usuario;
	}

	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public EncargadoMatricula getEncargadoMatricula() {
		return encargadoMatricula;
	}

	public void setEncargadoMatricula(EncargadoMatricula encargadoMatricula) {
		this.encargadoMatricula = encargadoMatricula;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
}
