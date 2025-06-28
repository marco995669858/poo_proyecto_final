package entidad;

public class Docente {
	
	private int idDocente;
	
	private String dni;
	
	private String apellidos;
	
	private String nombres;
	
	private String especialidad;
	
	private String direccion;
	
	private String telefono;
	
	private String usuario;
	
	public Docente() {
		
	}

	public Docente(int idDocente, String dni, String apellidos,String nombres, String especialidad, String direccion, String telefono,
			String usuario) {
		this.idDocente = idDocente;
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.especialidad = especialidad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.usuario = usuario;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
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
