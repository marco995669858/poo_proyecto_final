package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import conexionbd.ConexionBD;
import entidad.Estudiante;
import util.Constantes;

public class EstudianteDTO {
	
	public List<Estudiante> obtenerEstudiantes() {
		String sql = "SELECT * FROM tb_estudiante where TX_FSITREG = '1'";
		List<Estudiante> estudiante = new ArrayList<Estudiante>();

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				estudiante.add(new Estudiante(rs.getInt("ID_ESTUDIANTE"), rs.getString("DNI"), rs.getString("ANIO_INGRESO"),
						rs.getString("ESCUELA"), rs.getString("FACULTAD"), rs.getString("APELLIDOS"),
						rs.getString("NOMBRES"), rs.getString("DIRECCION"), rs.getString("TELEFONO"), rs.getString("TX_USUREG")));
			}
		} catch (Exception e) {
			System.err.println("Error al obtener estudiantes: " + e.getMessage());
			e.printStackTrace();
		}

		return estudiante;
	}

	public boolean guardarEstudiante(Estudiante estudiante) {
		String sql = "INSERT INTO tb_estudiante(DNI, ANIO_INGRESO, ESCUELA, FACULTAD, APELLIDOS, NOMBRES, DIRECCION, TELEFONO, TX_USUREG) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, estudiante.getDni());
			pstmt.setString(2, estudiante.getAnioIngreso());
			pstmt.setString(3, estudiante.getEscuela());
			pstmt.setString(4, estudiante.getFacultad());
			pstmt.setString(5, estudiante.getApellidos());
			pstmt.setString(6, estudiante.getNombres());
			pstmt.setString(7, estudiante.getDireccion());
			pstmt.setString(8, estudiante.getTelefono());
			pstmt.setString(9, estudiante.getUsuario());

			int filasInsertadas = pstmt.executeUpdate();

			if (filasInsertadas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						int idGenerado = rs.getInt(1);
						System.out.println("✅ Estudiante guardado con ID: " + idGenerado);
					}
				}
				return true;
			}

		} catch (SQLException e) {
			System.err.println("❌ Error al guardar estudiante: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public boolean actualizarEstudiante(Estudiante estudiante) {
		// Consulta SQL parametrizada para actualizar un estudiante por su ID
		String sql = "UPDATE tb_estudiante SET DNI = ?, ANIO_INGRESO = ?, ESCUELA = ?, FACULTAD = ?, APELLIDOS = ?, NOMBRES = ?, DIRECCION = ? , TELEFONO = ? , TX_USUACT = ? , FE_FECHA_ACT = ? WHERE ID_ESTUDIANTE = ?";

		try (Connection conn = ConexionBD.getConnection(); // Obtiene conexión a la BD
				PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL

			// Asignar valores a los parámetros de la consulta
			pstmt.setString(1, estudiante.getDni());
			pstmt.setString(2, estudiante.getAnioIngreso());
			pstmt.setString(3, estudiante.getEscuela());
			pstmt.setString(4, estudiante.getFacultad());
			pstmt.setString(5, estudiante.getApellidos());
			pstmt.setString(6, estudiante.getNombres());
			pstmt.setString(7, estudiante.getDireccion());
			pstmt.setString(8, estudiante.getTelefono());
			pstmt.setString(9, estudiante.getUsuario());
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(11, estudiante.getIdEstudiante());

			// Ejecutar la actualización
			int filasActualizadas = pstmt.executeUpdate();

			// Devolver true si se actualizó al menos una fila
			return filasActualizadas > 0;

		} catch (SQLException e) {
			// Manejo de errores en la base de datos
			System.err.println("❌ Error al estudiante docente: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarEstudiante(Integer idEstudiante) {
		String sql = "UPDATE tb_estudiante SET TX_FSITREG = ?, TX_USUELI = ?, FE_FECHA_ELI = ? WHERE ID_ESTUDIANTE = ?";

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, "0");
			pstmt.setString(2, Constantes.USUARIO);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, idEstudiante);

			int filasActualizadas = pstmt.executeUpdate();

			return filasActualizadas > 0;

		} catch (SQLException e) {
			System.err.println("❌ Error al eliminar estudiante: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
