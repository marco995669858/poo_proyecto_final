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
import entidad.Curso;
import entidad.Docente;
import entidad.EncargadoMatricula;
import entidad.Estudiante;
import entidad.Matricula;
import util.Constantes;

public class MatriculaDTO {

	public List<Matricula> obtenerMatriculas() {
		String sql = "select m.ID_MATRICULA, m.CICLO, m.FECHA, m.SECCION, m.ID_ESTUDIANTE, e.APELLIDOS APELLIDOESTUDIANTE, e.NOMBRES NOMBREESTUDIANTE, m.ID_DOCENTE, d.APELLIDOS APELLIDODOCENTE, "
				+	 "d.NOMBRES NOMBREDOCENTE, m.ID_CURSO, c.NOMBRE_CURSO,m.ID_ENCARGADO_MATRICULA, em.APELLIDOS APELLIDOENCARGADOMATRICULA, em.NOMBRES NOMBRESENCARGADOMATRICULA, m.TX_USUREG "
				+ 	 "from tb_matricula m "
				+	 "inner join tb_estudiante e on m.ID_ESTUDIANTE = e.ID_ESTUDIANTE and e.TX_FSITREG = '1' "
				+    "inner join tb_curso c on m.ID_CURSO = c.ID_CURSO and c.TX_FSITREG = '1' "
				+    "inner join tb_docente d on m.ID_DOCENTE = d.ID_DOCENTE and d.TX_FSITREG = '1' "
				+    "inner join tb_encargado_matricula em on m.ID_ENCARGADO_MATRICULA = em.ID_ENCARGADO_MATRICULA and em.TX_FSITREG = '1' "
				+    "where m.TX_FSITREG = '1'";
		List<Matricula> matriculas = new ArrayList<Matricula>();

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				matriculas.add(new Matricula(rs.getInt("ID_MATRICULA"), rs.getString("CICLO"),
						rs.getDate("FECHA"), rs.getString("SECCION"), new Estudiante(rs.getInt("ID_ESTUDIANTE"), rs.getString("APELLIDOESTUDIANTE"), rs.getString("NOMBREESTUDIANTE")),
						new Docente(rs.getInt("ID_DOCENTE"),rs.getString("APELLIDODOCENTE"), rs.getString("NOMBREDOCENTE")), new Curso(rs.getInt("ID_CURSO"), rs.getString("NOMBRE_CURSO")), 
						new EncargadoMatricula(rs.getInt("ID_ENCARGADO_MATRICULA"), rs.getString("APELLIDOENCARGADOMATRICULA"), rs.getString("NOMBRESENCARGADOMATRICULA")), rs.getString("TX_USUREG")));
			}
		} catch (Exception e) {
			System.err.println("Error al obtener matriculas: " + e.getMessage());
			e.printStackTrace();
		}

		return matriculas;
	}

	public boolean guardarMatricula(Matricula matricula) {
		String sql = "INSERT INTO tb_matricula(CICLO, FECHA, SECCION, ID_ESTUDIANTE, ID_DOCENTE, ID_CURSO, ID_ENCARGADO_MATRICULA, TX_USUREG) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, matricula.getCiclo());
			pstmt.setTimestamp(2, new Timestamp(matricula.getFecha().getTime()));
			pstmt.setString(3, matricula.getSeccion());
			pstmt.setInt(4, matricula.getEstudiante().getIdEstudiante());
			pstmt.setInt(5, matricula.getDocente().getIdDocente());
			pstmt.setInt(6, matricula.getCurso().getIdCurso());
			pstmt.setInt(7, matricula.getEncargadoMatricula().getIdEncargadoMatricula());
			pstmt.setString(8, matricula.getUsuario());

			int filasInsertadas = pstmt.executeUpdate();

			if (filasInsertadas > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						int idGenerado = rs.getInt(1);
						System.out.println("✅ Matricula guardado con ID: " + idGenerado);
					}
				}
				return true;
			}

		} catch (SQLException e) {
			System.err.println("❌ Error al guardar Matricula: " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public boolean actualizarMatricula(Matricula matricula) {
		// Consulta SQL parametrizada para actualizar un estudiante por su ID
		String sql = "UPDATE tb_matricula SET CICLO = ?, FECHA = ?, SECCION = ?, ID_ESTUDIANTE = ?, ID_DOCENTE = ?, ID_CURSO = ?, ID_ENCARGADO_MATRICULA = ?, TX_USUACT = ? , FE_FECHA_ACT = ?"
				   + "WHERE ID_MATRICULA = ?";

		try (Connection conn = ConexionBD.getConnection(); // Obtiene conexión a la BD
				PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL

			// Asignar valores a los parámetros de la consulta
			pstmt.setString(1, matricula.getCiclo());
			pstmt.setTimestamp(2, new Timestamp(matricula.getFecha().getTime()));
			pstmt.setString(3, matricula.getSeccion());
			pstmt.setInt(4, matricula.getEstudiante().getIdEstudiante());
			pstmt.setInt(5, matricula.getDocente().getIdDocente());
			pstmt.setInt(6, matricula.getCurso().getIdCurso());
			pstmt.setInt(7, matricula.getEncargadoMatricula().getIdEncargadoMatricula());
			pstmt.setString(8, matricula.getUsuario());
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(10, matricula.getIdMatricula());

			// Ejecutar la actualización
			int filasActualizadas = pstmt.executeUpdate();

			// Devolver true si se actualizó al menos una fila
			return filasActualizadas > 0;

		} catch (SQLException e) {
			// Manejo de errores en la base de datos
			System.err.println("❌ Error al actualizar matricula: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarMatricula(Integer idMatricula) {
		String sql = "UPDATE tb_matricula SET TX_FSITREG = ?, TX_USUELI = ?, FE_FECHA_ELI = ? WHERE ID_MATRICULA = ?";

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, "0");
			pstmt.setString(2, Constantes.USUARIO);
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, idMatricula);

			int filasActualizadas = pstmt.executeUpdate();

			return filasActualizadas > 0;

		} catch (SQLException e) {
			System.err.println("❌ Error al eliminar la matricula: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}