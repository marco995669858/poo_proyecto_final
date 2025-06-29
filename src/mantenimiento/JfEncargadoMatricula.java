package mantenimiento;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import entidad.EncargadoMatricula;
import repositorio.EncargadoMatriculaDTO;
import util.Constantes;
public class JfEncargadoMatricula extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private EncargadoMatriculaDTO repositorio = new EncargadoMatriculaDTO();
	private int idEncargadoMatricula = 0;
	private JPanel contentPane;
	static JfEncargadoMatricula jEncargadoMatricula;

	JTextField txtDni;
	JTextField txtApellido;
	JTextField txtNombre;
	JTextField txtDireccion;
	JTextField txtCargo;
	JTextField txtTelefono;
	JButton btnListar;
	JButton btnEliminar;
	JButton btnEditar;
	JButton btnGuardar;
	JButton btnCancelar;
	JTable jtListadoEncargadoMatricula;

	/**
	 * Launch the application.
	 */
	public static JfEncargadoMatricula getInstance() {
		if (jEncargadoMatricula == null) {
			jEncargadoMatricula = new JfEncargadoMatricula();
		}
		return jEncargadoMatricula;
	}

	/**
	 * Create the frame.
	 */

	public JfEncargadoMatricula() {
		setTitle("Encargado Matricula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMantenimientoDeEncargado = new JLabel("MANTENIMIENTO DE ENCARGADO MATRICULA");
		lblMantenimientoDeEncargado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMantenimientoDeEncargado.setBounds(143, 10, 416, 35);
		contentPane.add(lblMantenimientoDeEncargado);

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(10, 55, 39, 21);
		contentPane.add(lblDni);

		txtDni = new JTextField();
		txtDni.setText((String) null);
		txtDni.setColumns(10);
		txtDni.setBounds(44, 58, 137, 19);
		contentPane.add(txtDni);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(191, 58, 81, 21);
		contentPane.add(lblApellidos);

		txtApellido = new JTextField();
		txtApellido.setText((String) null);
		txtApellido.setColumns(10);
		txtApellido.setBounds(254, 61, 159, 19);
		contentPane.add(txtApellido);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(423, 58, 64, 21);
		contentPane.add(lblNombres);

		txtNombre = new JTextField();
		txtNombre.setText((String) null);
		txtNombre.setColumns(10);
		txtNombre.setBounds(497, 61, 153, 19);
		contentPane.add(txtNombre);

		JLabel lblDireccin_1 = new JLabel("Dirección:");
		lblDireccin_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin_1.setBounds(10, 86, 64, 21);
		contentPane.add(lblDireccin_1);

		txtDireccion = new JTextField();
		txtDireccion.setText((String) null);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(84, 89, 153, 19);
		contentPane.add(txtDireccion);

		txtCargo = new JTextField();
		txtCargo.setText((String) null);
		txtCargo.setColumns(10);
		txtCargo.setBounds(298, 88, 159, 19);
		contentPane.add(txtCargo);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargo.setBounds(247, 85, 47, 21);
		contentPane.add(lblCargo);

		txtTelefono = new JTextField();
		txtTelefono.setText((String) null);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(535, 88, 115, 19);
		contentPane.add(txtTelefono);

		JLabel lblTelefono_1 = new JLabel("Telefono:");
		lblTelefono_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono_1.setBounds(472, 86, 60, 21);
		contentPane.add(lblTelefono_1);

		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(10, 118, 91, 21);
		btnListar.addActionListener(this);
		contentPane.add(btnListar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(357, 118, 91, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);

		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(458, 118, 91, 21);
		btnEditar.addActionListener(this);
		contentPane.add(btnEditar);

		btnGuardar = new JButton("Registrar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setEnabled(true);
		btnGuardar.setBounds(559, 118, 91, 21);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(273, 405, 91, 21);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);

		jtListadoEncargadoMatricula = new JTable();
		jtListadoEncargadoMatricula.setModel(new DefaultTableModel(null, Constantes.COLUMNAS_ENCARGADO_MATRICULA));
		jtListadoEncargadoMatricula.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(jtListadoEncargadoMatricula);
		scrollPane.setBounds(10, 182, 640, 211);
		contentPane.add(scrollPane);

		llenarTablaEncargadoMatricula();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			registrarEncargadoMatricula();
		} else if (e.getSource() == btnCancelar) {
			JfEncargadoMatricula.this.setVisible(false);
		} else if (e.getSource() == btnListar) {
			llenarTablaEncargadoMatricula();
		} else if (e.getSource() == btnEditar) {
			System.out.println(idEncargadoMatricula);
			editarEncargadoMatricula();
		} else if (e.getSource() == btnEliminar) {
			eliminarEncargadoMatricula();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int filaSeleccionada = jtListadoEncargadoMatricula.getSelectedRow();

		if (filaSeleccionada != -1) {
			TableModel modelo = jtListadoEncargadoMatricula.getModel();
			idEncargadoMatricula = (int) modelo.getValueAt(filaSeleccionada, 0);
			txtCargo.setText((String) modelo.getValueAt(filaSeleccionada, 1));
			txtDni.setText((String) modelo.getValueAt(filaSeleccionada, 2));
			txtDireccion.setText((String) modelo.getValueAt(filaSeleccionada, 3));
			txtApellido.setText((String) modelo.getValueAt(filaSeleccionada, 4));
			txtNombre.setText((String) modelo.getValueAt(filaSeleccionada, 5));
			txtTelefono.setText((String) modelo.getValueAt(filaSeleccionada, 6));
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

	private void registrarEncargadoMatricula() {
		String isValidacion = validarCampos();

		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		EncargadoMatricula nuevoEncargadoMatricula = new EncargadoMatricula(idEncargadoMatricula, txtCargo.getText(), txtDni.getText(), txtDireccion.getText(), txtApellido.getText(),
				txtNombre.getText(), txtTelefono.getText(), Constantes.USUARIO);

		boolean resultado = repositorio.guardarEncargadoMatricula(nuevoEncargadoMatricula);
		if (resultado) {
			JOptionPane.showMessageDialog(this, "Encargado matricula guardado correctamente");
			llenarTablaEncargadoMatricula();
		} else {
			JOptionPane.showMessageDialog(this, "Error al guardar el Encargado matricula", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void llenarTablaEncargadoMatricula() {
		DefaultTableModel modelo = (DefaultTableModel) jtListadoEncargadoMatricula.getModel();
		
		modelo.setRowCount(0);
		
		List<EncargadoMatricula> listaEncargadoMatricula = repositorio.obtenerEncargadoMatriculas();
		
		for (EncargadoMatricula c : listaEncargadoMatricula) {
			Object[] fila = new Object[7];
		
			fila[0] = c.getIdEncargadoMatricula();
			fila[1] = c.getCargo();
			fila[2] = c.getDni();
			fila[3] = c.getDireccion();
			fila[4] = c.getApellidos();
			fila[5] = c.getNombres();
			fila[6] = c.getTelefono();
			modelo.addRow(fila);
		}
		/* RESTABLECER VALORES */
		limpiar();

	}

	private String validarCampos() {
		if (txtDni.getText().isBlank() || txtDni.getText().isEmpty()) {
			return "Ingrese un DNI.";
		}

		if (txtApellido.getText().isBlank() || txtApellido.getText().isEmpty()) {
			return "Ingrese sus apellidos.";
		}

		if (txtNombre.getText().isBlank() || txtNombre.getText().isEmpty()) {
			return "Ingrese sus nombres.";
		}

		if (txtDireccion.getText().isBlank() || txtDireccion.getText().isEmpty()) {
			return "Ingrese una direccion.";
		}

		if (txtCargo.getText().isBlank() || txtCargo.getText().isEmpty()) {
			return "Ingrese su cargo.";
		}

		if (txtTelefono.getText().isBlank() || txtTelefono.getText().isEmpty()) {
			return "Ingrese un número de telefono.";
		}

		return null;
	}

	void limpiar() {
	    idEncargadoMatricula = 0;
	    txtCargo.setText(null);
	    txtDni.setText(null);
	    txtDireccion.setText(null);
	    txtApellido.setText(null);
	    txtNombre.setText(null);
	    txtTelefono.setText(null);
	    btnGuardar.setEnabled(true);
	    btnEditar.setEnabled(false);
	    btnEliminar.setEnabled(false);
	}

	void limpiar(boolean limpiarCamposTexto) {
	    if (limpiarCamposTexto) {
	        txtCargo.setText(null);
	        txtDni.setText(null);
	        txtDireccion.setText(null);
	        txtApellido.setText(null);
	        txtNombre.setText(null);
	        txtTelefono.setText(null);
	    }
	    idEncargadoMatricula = 0;
	    btnGuardar.setEnabled(true);
	    btnEditar.setEnabled(false);
	    btnEliminar.setEnabled(false);
	}

	void editarEncargadoMatricula() {
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (idEncargadoMatricula > 0) {
			EncargadoMatricula nuevoEncargadoMatricula = new EncargadoMatricula(idEncargadoMatricula,
					txtCargo.getText(), txtDni.getText(), txtDireccion.getText(), txtApellido.getText(),
					txtNombre.getText(), txtTelefono.getText(), Constantes.USUARIO);

			boolean resultado = repositorio.actualizarEncargadoMatricula(nuevoEncargadoMatricula);
			if (resultado) {
				JOptionPane.showMessageDialog(this, "Encargado matricula editado correctamente");
				llenarTablaEncargadoMatricula();
			} else {
				JOptionPane.showMessageDialog(this, "Error al editar el Encargado matricula", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	void eliminarEncargadoMatricula() {
		if (idEncargadoMatricula > 0) {
			boolean resultado = repositorio.eliminarEncargadoMatricula(idEncargadoMatricula);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Encargado matricula eliminado correctamente");
				llenarTablaEncargadoMatricula();
			} else {
				JOptionPane.showMessageDialog(this, "Error al eliminar el encargado matricula", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

}