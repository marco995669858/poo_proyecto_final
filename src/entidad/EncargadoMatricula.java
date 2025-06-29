package entidad;

public class EncargadoMatricula {

	private int idEncargadoMatricula;
	
	private String cargo;
	
	private String dni;
	
	private String direccion;
	
	private String apellidos;
	
	private String nombres;
	
	private String telefono;
	
	private String usuario;
	
	public EncargadoMatricula() {}

	public EncargadoMatricula(int idEncargadoMatricula, String cargo, String dni, String direccion, String apellidos,
			String nombres, String telefono, String usuario) {
		this.idEncargadoMatricula = idEncargadoMatricula;
		this.cargo = cargo;
		this.dni = dni;
		this.direccion = direccion;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.telefono = telefono;
		this.usuario = usuario;
	}

	public int getIdEncargadoMatricula() {
		return idEncargadoMatricula;
	}

	public void setIdEncargadoMatricula(int idEncargadoMatricula) {
		this.idEncargadoMatricula = idEncargadoMatricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
