package entidad;

import java.util.Date;

public class Matricula {
	
	private int idMatricula;
	
	private String ciclo;
	
	private Date fecha;
	
	private String seccion;
	
	private int idEstudiante;
	
	private int idDocente;
	
	private int idCurso;
	
	private int idEncargadoMatricula;
	
	private String usuario;
	
	public Matricula() {}

	public Matricula(int idMatricula, String ciclo, Date fecha, String seccion, int idEstudiante, int idDocente,
			int idCurso, int idEncargadoMatricula, String usuario) {
		this.idMatricula = idMatricula;
		this.ciclo = ciclo;
		this.fecha = fecha;
		this.seccion = seccion;
		this.idEstudiante = idEstudiante;
		this.idDocente = idDocente;
		this.idCurso = idCurso;
		this.idEncargadoMatricula = idEncargadoMatricula;
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

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdEncargadoMatricula() {
		return idEncargadoMatricula;
	}

	public void setIdEncargadoMatricula(int idEncargadoMatricula) {
		this.idEncargadoMatricula = idEncargadoMatricula;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
