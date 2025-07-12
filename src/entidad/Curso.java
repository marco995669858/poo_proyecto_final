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
	
	public Curso(int idCurso,String nombreCurso) {
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
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
	
	@Override
    public String toString() {
        // Esto es lo que se muestra en el JComboBox
        return nombreCurso; // O puedes usar: return id + " - " + nombre;
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso other = (Curso) o;
        return this.idCurso == other.idCurso; // Solo compara por ID
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idCurso); // Usa solo el ID para el hash
    }
}
