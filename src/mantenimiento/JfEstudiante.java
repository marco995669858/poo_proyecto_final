package mantenimiento;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entidad.Docente;
import entidad.Estudiante;
import repositorio.EstudianteDTO;
import util.Constantes;

public class JfEstudiante extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private EstudianteDTO repositorio = new EstudianteDTO();
	private JPanel contentPane;
	static JfEstudiante jEstudiante;	
	private int idEstudiante = 0;
	
	JTextField txtDni;
	JTextField txtEscuela;
	JTextField txtTelefono;
	JTextField txtFacultad;
	JTextField txtApellidos;
	JTextField txtNombres;
	JTextField txtDireccion;
	JSpinner spAnioIngreso;
	JButton btnCancelar;
	JButton btnListar;
	JButton btnEliminar;
	JButton btnEditar;
	JButton btnGuardar;
	JTable jtListadoEstudiante;
	
	/**
	 * Launch the application.
	 */
	public static JfEstudiante getInstance() {
		if (jEstudiante == null) {
			jEstudiante = new JfEstudiante();
		}
		return jEstudiante;
	}

	/**
	 * Create the frame.
	 */
	public JfEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(26, 51, 39, 21);
		contentPane.add(lblDni);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(405, 451, 91, 21);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(26, 151, 91, 21);
		contentPane.add(btnListar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(579, 151, 91, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(680, 151, 91, 21);
		btnEditar.addActionListener(this);
		contentPane.add(btnEditar);
		
		btnGuardar = new JButton("Registrar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setEnabled(true);
		btnGuardar.setBounds(781, 151, 91, 21);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		
		txtDni = new JTextField();
		txtDni.setText((String) null);
		txtDni.setColumns(10);
		txtDni.setBounds(60, 54, 102, 19);
		contentPane.add(txtDni);
		
		JLabel lblMantenimientoDeEstudiantes = new JLabel("MANTENIMIENTO DE ESTUDIANTES");
		lblMantenimientoDeEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMantenimientoDeEstudiantes.setBounds(306, 9, 281, 35);
		contentPane.add(lblMantenimientoDeEstudiantes);
		
		JLabel lblAnioDeIngreso = new JLabel("Año de ingreso:");
		lblAnioDeIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnioDeIngreso.setBounds(214, 91, 100, 21);
		contentPane.add(lblAnioDeIngreso);
		
		JLabel lblEscuela = new JLabel("Escuela:");
		lblEscuela.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscuela.setBounds(405, 91, 64, 21);
		contentPane.add(lblEscuela);
		
		txtEscuela = new JTextField();
		txtEscuela.setText((String) null);
		txtEscuela.setColumns(10);
		txtEscuela.setBounds(478, 94, 153, 19);
		contentPane.add(txtEscuela);
		
		JLabel lblTelefono_1 = new JLabel("Telefono:");
		lblTelefono_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono_1.setBounds(26, 93, 60, 21);
		contentPane.add(lblTelefono_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setText((String) null);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(89, 95, 115, 19);
		contentPane.add(txtTelefono);
		
		spAnioIngreso = new JSpinner();
		spAnioIngreso.setBounds(324, 94, 71, 20);
		contentPane.add(spAnioIngreso);
		
		JLabel lblFacultad = new JLabel("Facultad:");
		lblFacultad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFacultad.setBounds(641, 91, 81, 21);
		contentPane.add(lblFacultad);
		
		txtFacultad = new JTextField();
		txtFacultad.setText((String) null);
		txtFacultad.setColumns(10);
		txtFacultad.setBounds(719, 94, 153, 19);
		contentPane.add(txtFacultad);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(172, 51, 81, 21);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setText((String) null);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(235, 54, 159, 19);
		contentPane.add(txtApellidos);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(404, 51, 64, 21);
		contentPane.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setText((String) null);
		txtNombres.setColumns(10);
		txtNombres.setBounds(478, 54, 153, 19);
		contentPane.add(txtNombres);
		
		JLabel lblDireccin_1 = new JLabel("Dirección:");
		lblDireccin_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin_1.setBounds(641, 51, 64, 21);
		contentPane.add(lblDireccin_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setText((String) null);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(719, 54, 153, 19);
		contentPane.add(txtDireccion);

		jtListadoEstudiante = new JTable();
		jtListadoEstudiante.setModel(new DefaultTableModel(null, Constantes.COLUMNAS_ESTUDIANTES));
		jtListadoEstudiante.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(jtListadoEstudiante);
		scrollPane.setBounds(10, 182, 862, 248);
		contentPane.add(scrollPane);
		
		llenarTablaEstudiante();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			registrarEstudiante();
		} else if (e.getSource() == btnCancelar) {
			JfEstudiante.this.setVisible(false);
		} else if (e.getSource() == btnListar) {
			llenarTablaEstudiante();
		} else if (e.getSource() == btnEditar) {
			System.out.println(idEstudiante);
			editarEstudiante();
		} else if (e.getSource() == btnEliminar) {
			eliminarEstudiante();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int filaSeleccionada = jtListadoEstudiante.getSelectedRow();

		if (filaSeleccionada != -1) {
			TableModel modelo = jtListadoEstudiante.getModel();
			idEstudiante = (int) modelo.getValueAt(filaSeleccionada, 0);
			txtDni.setText((String) modelo.getValueAt(filaSeleccionada, 1));
			spAnioIngreso.setValue(Integer.parseInt((String) modelo.getValueAt(filaSeleccionada, 2)));
			txtEscuela.setText((String) modelo.getValueAt(filaSeleccionada, 3));
			txtFacultad.setText((String) modelo.getValueAt(filaSeleccionada, 4));
			txtApellidos.setText((String) modelo.getValueAt(filaSeleccionada, 5));
			txtNombres.setText((String) modelo.getValueAt(filaSeleccionada, 6));
			txtDireccion.setText((String) modelo.getValueAt(filaSeleccionada, 7));
			txtTelefono.setText((String) modelo.getValueAt(filaSeleccionada, 8));
			btnGuardar.setEnabled(false);
			btnEditar.setEnabled(true);
			btnEliminar.setEnabled(true);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private void registrarEstudiante() {
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		Estudiante nuevoEstudiante = new Estudiante(0, txtDni.getText(), String.valueOf(spAnioIngreso.getValue()), txtEscuela.getText(), txtFacultad.getText(), txtApellidos.getText(),
				txtNombres.getText(), txtDireccion.getText(), txtTelefono.getText(),
				Constantes.USUARIO);
		boolean resultado = repositorio.guardarEstudiante(nuevoEstudiante);

		if (resultado) {
			JOptionPane.showMessageDialog(this, "Estudiante guardado correctamente");
			llenarTablaEstudiante();
		} else {
			JOptionPane.showMessageDialog(this, "Error al guardar el Estudiante", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void llenarTablaEstudiante() {
		DefaultTableModel modelo = (DefaultTableModel) jtListadoEstudiante.getModel();
		modelo.setRowCount(0);

		List<Estudiante> listaEstudiantes = repositorio.obtenerEstudiantes();

		for (Estudiante c : listaEstudiantes) {
			Object[] fila = new Object[9];
			fila[0] = c.getIdEstudiante();
			fila[1] = c.getDni();
			fila[2] = c.getAnioIngreso();
			fila[3] = c.getEscuela();
			fila[4] = c.getFacultad();
			fila[5] = c.getApellidos();
			fila[6] = c.getNombres();
			fila[7] = c.getDireccion();
			fila[8] = c.getTelefono();
			modelo.addRow(fila);
		}
		/* RESTABLECER VALORES */
		limpiar();
	}

	private String validarCampos() {
		if (txtDni.getText().isBlank() || txtDni.getText().isEmpty()) {
			return "Ingrese un DNI.";
		}

		if ((Integer) spAnioIngreso.getValue() <= 3) {
			return "Ingrese una especialidad.";
		}

		if (txtEscuela.getText().isBlank() || txtEscuela.getText().isEmpty()) {
			return "Ingrese su escuela.";
		}
		
		if (txtFacultad.getText().isBlank() || txtFacultad.getText().isEmpty()) {
			return "Ingrese su facultad.";
		}
		
		if (txtApellidos.getText().isBlank() || txtApellidos.getText().isEmpty()) {
			return "Ingrese sus apellidos.";
		}

		if (txtNombres.getText().isBlank() || txtNombres.getText().isEmpty()) {
			return "Ingrese sus nombres.";
		}

		if (txtDireccion.getText().isBlank() || txtDireccion.getText().isEmpty()) {
			return "Ingrese una direccion.";
		}

		if (txtTelefono.getText().isBlank() || txtTelefono.getText().isEmpty()) {
			return "Ingrese un número de telefono.";
		}

		return null;
	}

	void limpiar() {
		idEstudiante = 0;
		txtDni.setText(null);
		spAnioIngreso.setValue(0);
		txtEscuela.setText(null);
		txtFacultad.setText(null);
		txtApellidos.setText(null);
		txtNombres.setText(null);
		txtDireccion.setText(null);
		txtTelefono.setText(null);
		btnGuardar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

	void editarEstudiante() {
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		System.out.println(idEstudiante);
		if (idEstudiante > 0) {
			Estudiante nuevoEstudiante = new Estudiante(idEstudiante, txtDni.getText(), String.valueOf(spAnioIngreso.getValue()), txtEscuela.getText(), txtFacultad.getText(), txtApellidos.getText(),
					txtNombres.getText(), txtDireccion.getText(), txtTelefono.getText(),
					Constantes.USUARIO);
			boolean resultado = repositorio.actualizarEstudiante(nuevoEstudiante);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Estudiante editado correctamente");
				llenarTablaEstudiante();
			} else {
				JOptionPane.showMessageDialog(this, "Error al editar el Estudiante", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	void eliminarEstudiante() {
		if (idEstudiante > 0) {
			boolean resultado = repositorio.eliminarEstudiante(idEstudiante);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Estudiante eliminado correctamente");
				llenarTablaEstudiante();
			} else {
				JOptionPane.showMessageDialog(this, "Error al eliminar el Estudiante", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	
}
