package principal;

import conexionBD.CursoDAO;

public class Main {
    public static void main(String[] args) {
        CursoDAO cursoDAO = new CursoDAO();
        cursoDAO.obtenerUsuarios(); // Llama a la consulta sin repetir datos de conexión
    }
}