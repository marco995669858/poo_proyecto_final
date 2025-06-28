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

import entidad.Docente;
import repositorio.DocenteDAO;
import util.global;

public class JfDocente extends JInternalFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private DocenteDAO repositorio = new DocenteDAO();
	private JPanel contentPane;
	static JfDocente jDocente;
	
	private int idDocente = 0;
	
	JTextField txtDni;
	JTextField txtApellidos;
	JTextField txtNombres;
	JTextField txtEspecialidad;
	JTextField txtDireccion;
	JTextField txtTelefono;
	JButton btnGuardar;
	JButton btnCancelar;
	JButton btnEditar;
	JButton btnListar;
	JButton btnEliminar;
	JTable jtListadoDocente;
	/**
	 * Launch the application.
	 */
	public static JfDocente getInstance() {
		if (jDocente == null) {
			jDocente = new JfDocente();
		}
		return jDocente;
	}

	/**
	 * Create the frame.
	 */
	public JfDocente() {
		setTitle("Docente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(36, 51, 39, 21);
		contentPane.add(lblDni);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(310, 414, 91, 21);		
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(10, 145, 91, 21);
		btnListar.addActionListener(this);
		contentPane.add(btnListar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(422, 145, 91, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		btnEliminar.setEnabled(false);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(523, 145, 91, 21);
		btnEditar.addActionListener(this);
		contentPane.add(btnEditar);
		btnEditar.setEnabled(false);
		
		btnGuardar = new JButton("Registrar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(624, 145, 91, 21);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);
		btnGuardar.setEnabled(true);
		
		txtDni = new JTextField();
		txtDni.setBounds(96, 54, 159, 19);
		contentPane.add(txtDni);
		txtDni.setText((String) null);
		txtDni.setColumns(10);
		
		JLabel lblTitulo = new JLabel("MANTENIMIENTO DE DOCENTES");
		lblTitulo.setBounds(257, 10, 259, 35);
		contentPane.add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(265, 51, 64, 21);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setText((String) null);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(330, 54, 153, 19);
		contentPane.add(txtApellidos);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(493, 51, 64, 21);
		contentPane.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setText((String) null);
		txtNombres.setColumns(10);
		txtNombres.setBounds(562, 54, 153, 19);
		contentPane.add(txtNombres);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEspecialidad.setBounds(10, 94, 81, 21);
		contentPane.add(lblEspecialidad);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setText((String) null);
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(96, 97, 159, 19);
		contentPane.add(txtEspecialidad);
		
		JLabel lblDireccin = new JLabel("Dirección:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(265, 94, 64, 21);
		contentPane.add(lblDireccin);
		
		txtDireccion = new JTextField();
		txtDireccion.setText((String) null);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(330, 97, 153, 19);
		contentPane.add(txtDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(493, 94, 64, 21);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setText((String) null);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(562, 97, 153, 19);
		contentPane.add(txtTelefono);
		
		jtListadoDocente = new JTable();
		jtListadoDocente.setModel(new DefaultTableModel(null, global.columnasDocentes));
		jtListadoDocente.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(jtListadoDocente);
		scrollPane.setBounds(10, 189, 705, 215);
		contentPane.add(scrollPane);
		
		llenarTablaDocente();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			registrarDocente();
		} else if (e.getSource() == btnCancelar) {
			JfDocente.this.setVisible(false);
		} else if (e.getSource() == btnListar) {
			llenarTablaDocente();
		} else if (e.getSource() == btnEditar) {
			System.out.println(idDocente);
			editarDocente();
		} else if (e.getSource() == btnEliminar) {
			eliminarDocente();
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int filaSeleccionada = jtListadoDocente.getSelectedRow();

		if (filaSeleccionada != -1) {
			TableModel modelo = jtListadoDocente.getModel();
			idDocente = (int) modelo.getValueAt(filaSeleccionada, 0);
			txtDni.setText((String) modelo.getValueAt(filaSeleccionada, 1));
			txtApellidos.setText((String) modelo.getValueAt(filaSeleccionada, 2));
			txtNombres.setText((String) modelo.getValueAt(filaSeleccionada, 3));
			txtEspecialidad.setText((String) modelo.getValueAt(filaSeleccionada, 4));
			txtDireccion.setText((String) modelo.getValueAt(filaSeleccionada, 5));
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

	private void registrarDocente() {
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Docente nuevoDocente= new Docente(0, txtDni.getText(), txtApellidos.getText(),txtNombres.getText(),txtEspecialidad.getText(),txtDireccion.getText(),txtTelefono.getText(), global.usuario);
		boolean resultado = repositorio.guardarDocente(nuevoDocente);

		if (resultado) {
			JOptionPane.showMessageDialog(this, "Docente guardado correctamente");
			llenarTablaDocente();
		} else {
			JOptionPane.showMessageDialog(this, "Error al guardar el Docente", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void llenarTablaDocente() {
		DefaultTableModel modelo = (DefaultTableModel) jtListadoDocente.getModel();
		modelo.setRowCount(0);

		List<Docente> listaDocentes = repositorio.obtenerDocentes();

		for (Docente c : listaDocentes) {
			Object[] fila = new Object[7];
			fila[0] = c.getIdDocente();
			fila[1] = c.getDni();
			fila[2] = c.getApellidos();
			fila[3] = c.getNombres();
			fila[4] = c.getEspecialidad();
			fila[5] = c.getDireccion();
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

		if (txtApellidos.getText().isBlank() || txtApellidos.getText().isEmpty()) {
			return "Ingrese sus apellidos.";
		}
		
		if (txtNombres.getText().isBlank() || txtNombres.getText().isEmpty()) {
			return "Ingrese sus nombres.";
		}
		
		if (txtEspecialidad.getText().isBlank() || txtEspecialidad.getText().isEmpty()) {
			return "Ingrese una especialidad.";
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
		idDocente = 0;
		txtDni.setText(null);
		txtApellidos.setText(null);
		txtNombres.setText(null);
		txtEspecialidad.setText(null);
		txtDireccion.setText(null);
		txtTelefono.setText(null);
		btnGuardar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

	void editarDocente() {
		System.out.println(idDocente);
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		System.out.println(idDocente);
		if (idDocente > 0) {
			Docente nuevoDocente = new Docente(idDocente, txtDni.getText(), txtApellidos.getText(),txtNombres.getText(),txtEspecialidad.getText(),txtDireccion.getText(),txtTelefono.getText(), global.usuario);
			boolean resultado = repositorio.actualizarDocente(nuevoDocente);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Docente editado correctamente");
				llenarTablaDocente();
			} else {
				JOptionPane.showMessageDialog(this, "Error al editar el Docente", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	void eliminarDocente() {
		if (idDocente > 0) {
			boolean resultado = repositorio.eliminarDocente(idDocente);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Docente eliminado correctamente");
				llenarTablaDocente();
			} else {
				JOptionPane.showMessageDialog(this, "Error al eliminar el Docente", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
