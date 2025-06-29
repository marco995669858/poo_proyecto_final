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
import entidad.EncargadoMatricula;
import util.Constantes;

public class EncargadoMatriculaDTO {

	public List<EncargadoMatricula> obtenerEncargadoMatriculas() {
		String sql = "SELECT * FROM tb_encargado_matricula where TX_FSITREG = '1'";
		List<EncargadoMatricula> estudiante = new ArrayList<EncargadoMatricula>();

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				estudiante.add(new EncargadoMatricula(rs.getInt("ID_ENCARGADO_MATRICULA"), rs.getString("CARGO"),
						rs.getString("DNI"), rs.getString("DIRECCION"), rs.getString("APELLIDOS"),
						rs.getString("NOMBRES"), rs.getString("TELEFONO"), rs.getString("TX_USUREG")));
			}
		} catch (Exception e) {
			System.err.println("Error al obtener estudiantes: " + e.getMessage());
			e.printStackTrace();
		}

		return estudiante;
	}

	public boolean guardarEncargadoMatricula(EncargadoMatricula encargadoMatricula) {
		String sql = "INSERT INTO tb_encargado_matricula(CARGO, DNI, DIRECCION, APELLIDOS, NOMBRES, TELEFONO, TX_USUREG) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, encargadoMatricula.getCargo());
			pstmt.setString(2, encargadoMatricula.getDni());
			pstmt.setString(3, encargadoMatricula.getDireccion());
			pstmt.setString(4, encargadoMatricula.getApellidos());
			pstmt.setString(5, encargadoMatricula.getNombres());
			pstmt.setString(6, encargadoMatricula.getTelefono());
			pstmt.setString(7, encargadoMatricula.getUsuario());

			int filasInsertadas = pstmt.executeUpdate();

			if (filasInsertadas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						int idGenerado = rs.getInt(1);
						System.out.println("✅ Encargado Matricula guardado con ID: " + idGenerado);
					}
				}
				return true;
			}

		} catch (SQLException e) {
			System.err.println("❌ Error al guardar encargado Matricula: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public boolean actualizarEncargadoMatricula(EncargadoMatricula encargadoMatricula) {
		// Consulta SQL parametrizada para actualizar un estudiante por su ID
		String sql = "UPDATE tb_encargado_matricula SET CARGO = ?, DNI = ?, DIRECCION = ?, APELLIDOS = ?, NOMBRES = ?, TELEFONO = ?, TX_USUACT = ? , FE_FECHA_ACT = ? WHERE ID_ENCARGADO_MATRICULA = ?";

		try (Connection conn = ConexionBD.getConnection(); // Obtiene conexión a la BD
				PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL

			// Asignar valores a los parámetros de la consulta
			pstmt.setString(1, encargadoMatricula.getCargo());
			pstmt.setString(2, encargadoMatricula.getDni());
			pstmt.setString(3, encargadoMatricula.getDireccion());
			pstmt.setString(4, encargadoMatricula.getApellidos());
			pstmt.setString(5, encargadoMatricula.getNombres());
			pstmt.setString(6, encargadoMatricula.getTelefono());
			pstmt.setString(7, encargadoMatricula.getUsuario());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(9, encargadoMatricula.getIdEncargadoMatricula());

			// Ejecutar la actualización
			int filasActualizadas = pstmt.executeUpdate();

			// Devolver true si se actualizó al menos una fila
			return filasActualizadas > 0;

		} catch (SQLException e) {
			// Manejo de errores en la base de datos
			System.err.println("❌ Error al actualizar encargado matricula: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarEncargadoMatricula(Integer idEncargadoMatricula) {
		String sql = "UPDATE tb_encargado_matricula SET TX_FSITREG = ?, TX_USUELI = ?, FE_FECHA_ELI = ? WHERE ID_ENCARGADO_MATRICULA = ?";

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, "0");
			pstmt.setString(2, Constantes.USUARIO);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, idEncargadoMatricula);

			int filasActualizadas = pstmt.executeUpdate();

			return filasActualizadas > 0;

		} catch (SQLException e) {
			System.err.println("❌ Error al eliminar el  encargado matricula: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}