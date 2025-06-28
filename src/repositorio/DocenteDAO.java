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
import entidad.Docente;
import util.Constantes;

public class DocenteDAO {
	public List<Docente> obtenerDocentes() {
		String sql = "SELECT * FROM tb_docente where TX_FSITREG = '1'";
		List<Docente> docente = new ArrayList<Docente>();

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				docente.add(new Docente(rs.getInt("ID_DOCENTE"), rs.getString("DNI"), rs.getString("APELLIDOS"),
						rs.getString("NOMBRES"),rs.getString("EPECIALIDAD"),rs.getString("DIRECCION"),rs.getString("TELEFONO"),rs.getString("TX_USUREG")));
			}
		} catch (Exception e) {
			System.err.println("Error al obtener usuarios: " + e.getMessage());
			e.printStackTrace();
		}

		return docente;
	}

	public boolean guardarDocente(Docente docente) {
		String sql = "INSERT INTO tb_docente(DNI, APELLIDOS, NOMBRES, EPECIALIDAD, DIRECCION, TELEFONO, TX_USUREG) VALUES (?, ?, ?,?, ?, ?,?)";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, docente.getDni());
			pstmt.setString(2, docente.getApellidos());
			pstmt.setString(3, docente.getNombres());
			pstmt.setString(4, docente.getEspecialidad());
			pstmt.setString(5, docente.getDireccion());
			pstmt.setString(6, docente.getTelefono());
			pstmt.setString(7, docente.getUsuario());

			int filasInsertadas = pstmt.executeUpdate();

			if (filasInsertadas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						int idGenerado = rs.getInt(1);
						System.out.println("✅ Docente guardado con ID: " + idGenerado);
					}
				}
				return true;
			}

		} catch (SQLException e) {
			System.err.println("❌ Error al guardar docente: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public boolean actualizarDocente(Docente docente) {
		// Consulta SQL parametrizada para actualizar un docente por su ID
		String sql = "UPDATE tb_docente SET DNI = ?, APELLIDOS = ?,NOMBRES = ?, EPECIALIDAD = ? , DIRECCION = ? , TELEFONO = ? , TX_USUACT = ? , FE_FECHA_ACT = ? WHERE ID_DOCENTE = ?";

		try (Connection conn = ConexionBD.getConnection(); // Obtiene conexión a la BD
				PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL
			
			// Asignar valores a los parámetros de la consulta
			pstmt.setString(1, docente.getDni());
			pstmt.setString(2, docente.getApellidos());
			pstmt.setString(3, docente.getNombres());
			pstmt.setString(4, docente.getEspecialidad());
			pstmt.setString(5, docente.getDireccion());
			pstmt.setString(6, docente.getTelefono());
			pstmt.setString(7, docente.getUsuario());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(9, docente.getIdDocente());
			
			// Ejecutar la actualización
			int filasActualizadas = pstmt.executeUpdate();
			
			// Devolver true si se actualizó al menos una fila
			return filasActualizadas > 0;

		} catch (SQLException e) {
			// Manejo de errores en la base de datos
			System.err.println("❌ Error al actualizar docente: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarDocente(Integer idDocente) {
		String sql = "UPDATE tb_docente SET TX_FSITREG = ?, TX_USUELI = ?, FE_FECHA_ELI = ? WHERE ID_DOCENTE = ?";

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, "0");
			pstmt.setString(2, Constantes.USUARIO);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, idDocente);

			int filasActualizadas = pstmt.executeUpdate();

			return filasActualizadas > 0;

		} catch (SQLException e) {
			System.err.println("❌ Error al eliminar docente: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
