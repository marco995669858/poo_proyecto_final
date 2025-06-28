package entidad;

public class Curso {
	
	private int idCurso;
	
	private String nombreCurso;
	
	private int credito;
	
	private String usuario;
	
	public Curso() {
		
	}
	
	public Curso(int idCurso,String nombreCurso,int credito,String usuario) {
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.credito = credito;
		this.usuario = usuario;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

}
