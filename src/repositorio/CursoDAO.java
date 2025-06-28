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
import util.Constantes;

public class CursoDAO {

	public List<Curso> obtenerUsuarios() {
		String sql = "SELECT * FROM tb_curso where TX_FSITREG = '1'";
		List<Curso> curso = new ArrayList<Curso>();

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				curso.add(new Curso(rs.getInt("ID_CURSO"), rs.getString("NOMBRE_CURSO"), rs.getInt("CREDITO"),
						rs.getString("TX_USUREG")));
			}
		} catch (Exception e) {
			System.err.println("Error al obtener usuarios: " + e.getMessage());
			e.printStackTrace();
		}
		
		return curso;
	}
	
	public boolean guardarCurso(Curso curso) {
        String sql = "INSERT INTO tb_curso(NOMBRE_CURSO, CREDITO, TX_USUREG) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, curso.getNombreCurso());
            pstmt.setInt(2, curso.getCredito());
            pstmt.setString(3, curso.getUsuario());

            int filasInsertadas = pstmt.executeUpdate();

            if (filasInsertadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        System.out.println("✅ Curso guardado con ID: " + idGenerado);
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al guardar curso: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
	
	public boolean actualizarCurso(Curso curso) {
	    // Consulta SQL parametrizada para actualizar un curso por su ID
        String sql = "UPDATE tb_curso SET NOMBRE_CURSO = ?, CREDITO = ?,TX_USUACT = ?, FE_FECHA_ACT = ? WHERE ID_CURSO = ?";

        try (Connection conn = ConexionBD.getConnection(); // Obtiene conexión a la BD
             PreparedStatement pstmt = conn.prepareStatement(sql)) { // Preparar la consulta SQL
        	
        	// Asignar valores a los parámetros de la consulta
            pstmt.setString(1, curso.getNombreCurso());
            pstmt.setInt(2, curso.getCredito());
            pstmt.setString(3, curso.getUsuario());
            pstmt.setTimestamp(4,  new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(5, curso.getIdCurso());
            
            // Ejecutar la actualización
            int filasActualizadas = pstmt.executeUpdate();
            
         	// Devolver true si se actualizó al menos una fila
            return filasActualizadas > 0;

        } catch (SQLException e) {
        	// Manejo de errores en la base de datos
            System.err.println("❌ Error al actualizar curso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean eliminarCurso(Integer idCurso) {
        String sql = "UPDATE tb_curso SET TX_FSITREG = ?, TX_USUELI = ?, FE_FECHA_ELI = ? WHERE ID_CURSO = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "0");
            pstmt.setString(2, Constantes.USUARIO);
            pstmt.setTimestamp(3,  new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(4, idCurso);

            int filasActualizadas = pstmt.executeUpdate();

            return filasActualizadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar curso: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
