package entidad;

public class Estudiante {

	private int idEstudiante;
	
	private String dni;
	
	private int anioIngreso;
	
	private String escuela;
	
	private String facultad;
	
	private String apellidos;
	
	private String nombres;
	
	private String direccion;
	
	private String telefono;
	
	private String usuario;
	
	public Estudiante() {}

	public Estudiante(int idEstudiante, String dni, int anioIngreso, String escuela, String facultad, String apellidos,
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

	public int getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(int anioIngreso) {
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
	
}
