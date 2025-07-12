package entidad;

public class Estudiante {

	private int idEstudiante;
	
	private String dni;
	
	private String anioIngreso;
	
	private String escuela;
	
	private String facultad;
	
	private String apellidos;
	
	private String nombres;
	
	private String direccion;
	
	private String telefono;
	
	private String usuario;
	
	public Estudiante() {}

	public Estudiante(int idEstudiante, String dni, String anioIngreso, String escuela, String facultad, String apellidos,
			String nombres, String direccion, String telefono, String usuario) {
		this.idEstudiante = idEstudiante;
		this.dni = dni;
		this.anioIngreso = anioIngreso;
		this.escuela = escuela;
		this.facultad = facultad;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
	}
	
	public Estudiante(int idEstudiante,String apellidos, String nombres) {
		this.idEstudiante = idEstudiante;
		this.apellidos = apellidos;
		this.nombres = nombres;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(String anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
        return apellidos + " " + nombres; // O puedes usar: return id + " - " + nombre;
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante other = (Estudiante) o;
        return this.idEstudiante == other.idEstudiante; // Solo compara por ID
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idEstudiante); // Usa solo el ID para el hash
    }
	
}
