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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entidad.Curso;
import repositorio.CursoDAO;
import util.Constantes;

public class JfCurso extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private CursoDAO repositorio = new CursoDAO();
	private JPanel contentPane;

	private int idCurso = 0;

	/**
	 * Launch the application.
	 */
	static JfCurso jCurso;
	JTextField txtNombreCurso;
	JButton btnGuardar;
	JButton btnCancelar;
	JButton btnEditar;
	JButton btnListar;
	JButton btnEliminar;
	JTable jtListadoCurso;
	JSpinner jsCredito;

	public static JfCurso getInstance() {
		if (jCurso == null) {
			jCurso = new JfCurso();
		}
		return jCurso;
	}

	/**
	 * Create the frame.
	 */
	public JfCurso() {
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("MANTENIMIENTO DE CURSOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(164, 10, 237, 35);
		contentPane.add(lblTitulo);

		JLabel lblCurso = new JLabel("Nombre curso: ");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurso.setBounds(37, 72, 106, 13);
		contentPane.add(lblCurso);

		JLabel lblCredito = new JLabel("Creditos:");
		lblCredito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCredito.setBounds(321, 72, 64, 13);
		contentPane.add(lblCredito);

		txtNombreCurso = new JTextField();
		txtNombreCurso.setBounds(153, 71, 145, 19);
		contentPane.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);

		btnGuardar = new JButton("Registrar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(441, 127, 91, 21);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(37, 127, 91, 21);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(239, 127, 91, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);

		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(138, 127, 91, 21);
		btnListar.addActionListener(this);
		contentPane.add(btnListar);

		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setBounds(340, 127, 91, 21);
		btnEditar.addActionListener(this);
		contentPane.add(btnEditar);

		jtListadoCurso = new JTable();
		jtListadoCurso.setModel(new DefaultTableModel(null, Constantes.COLUMNAS_CURSOS));
		jtListadoCurso.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(jtListadoCurso);
		scrollPane.setBounds(21, 172, 519, 184);
		contentPane.add(scrollPane);

		jsCredito = new JSpinner();
		jsCredito.setBounds(395, 71, 51, 20);
		contentPane.add(jsCredito);

		llenarTablaCursos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			registrarCurso();
		} else if (e.getSource() == btnCancelar) {
			JfCurso.this.setVisible(false);
		} else if (e.getSource() == btnListar) {
			llenarTablaCursos();
		} else if (e.getSource() == btnEditar) {
			editarCurso();
		} else if (e.getSource() == btnEliminar) {
			eliminarCurso();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int filaSeleccionada = jtListadoCurso.getSelectedRow();

		if (filaSeleccionada != -1) {
			TableModel modelo = jtListadoCurso.getModel();
			idCurso = (int) modelo.getValueAt(filaSeleccionada, 0);
			txtNombreCurso.setText((String) modelo.getValueAt(filaSeleccionada, 1));
			jsCredito.setValue(modelo.getValueAt(filaSeleccionada, 2));
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

	private void registrarCurso() {
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		Curso nuevoCurso = new Curso(0, txtNombreCurso.getText(), (Integer) jsCredito.getValue(), Constantes.USUARIO);
		boolean resultado = repositorio.guardarCurso(nuevoCurso);

		if (resultado) {
			JOptionPane.showMessageDialog(this, "Curso guardado correctamente");
			llenarTablaCursos();
			limpiar();
		} else {
			JOptionPane.showMessageDialog(this, "Error al guardar el curso", "Error", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void llenarTablaCursos() {
		DefaultTableModel modelo = (DefaultTableModel) jtListadoCurso.getModel();
		modelo.setRowCount(0);

		List<Curso> listaCursos = repositorio.obtenerCursos();

		for (Curso c : listaCursos) {
			Object[] fila = new Object[3];
			fila[0] = c.getIdCurso();
			fila[1] = c.getNombreCurso();
			fila[2] = c.getCredito();
			modelo.addRow(fila);
		}
		
		limpiar(false);
	}

	private String validarCampos() {
		if (txtNombreCurso.getText().isBlank() || txtNombreCurso.getText().isEmpty()) {
			return "Ingrese un nombre de curso.";
		}

		if ((Integer) jsCredito.getValue() <= 0) {
			return "Ingrese un credito mayor a cero.";
		}

		return null;
	}

	void limpiar() {
		idCurso = 0;
		txtNombreCurso.setText(null);
		jsCredito.setValue(0);
		btnGuardar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	
	void limpiar(boolean limpiarCamposTexto) {
		if(limpiarCamposTexto) {
			idCurso = 0;
			txtNombreCurso.setText(null);
			jsCredito.setValue(0);
		}		
		btnGuardar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

	void editarCurso() {
		String isValidacion = validarCampos();
		if (isValidacion != null) {
			JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if (idCurso > 0) {
			System.out.println(idCurso);
			Curso nuevoCurso = new Curso(idCurso, txtNombreCurso.getText(), (Integer) jsCredito.getValue(),
					Constantes.USUARIO);
			boolean resultado = repositorio.actualizarCurso(nuevoCurso);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Curso editado correctamente");
				llenarTablaCursos();
				limpiar();
			} else {
				JOptionPane.showMessageDialog(this, "Error al editar el curso", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	void eliminarCurso() {
		if (idCurso > 0) {
			boolean resultado = repositorio.eliminarCurso(idCurso);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Curso eliminado correctamente");
				llenarTablaCursos();
				limpiar();
			} else {
				JOptionPane.showMessageDialog(this, "Error al eliminar el curso", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
