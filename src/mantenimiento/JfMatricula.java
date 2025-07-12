package mantenimiento;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entidad.Curso;
import entidad.Docente;
import entidad.EncargadoMatricula;
import entidad.Estudiante;
import entidad.Matricula;
import repositorio.CursoDAO;
import repositorio.DocenteDAO;
import repositorio.EncargadoMatriculaDTO;
import repositorio.EstudianteDTO;
import repositorio.MatriculaDTO;
import util.Constantes;

public class JfMatricula extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private int idMatricula = 0;
	private MatriculaDTO repositorio = new MatriculaDTO();
	private EstudianteDTO repositorioEstudiante = new EstudianteDTO();
	private DocenteDAO repositorioDocente = new DocenteDAO();
	private CursoDAO repositorioCurso = new CursoDAO();
	private EncargadoMatriculaDTO repositorioEncargadoMatricula = new EncargadoMatriculaDTO();
	private JPanel contentPane;
	static JfMatricula jMatricula;

	JTextField txtCiclo;
	JTextField txtFecha;
	JTextField txtSeccion;
	JComboBox<Estudiante> cboEstudiante;
	JComboBox<Docente> cboDocente;
	JComboBox<Curso> cboCurso;
	JComboBox<EncargadoMatricula> cboEncargadoMatricula;
	JButton btnListar;
	JButton btnEliminar;
	JButton btnEditar;
	JButton btnGuardar;
	JButton btnCancelar;
	JTable jtListadoMatricula;

	LocalDate fechaHoy = LocalDate.now();
	Estudiante estudiante;
	Docente docente;
	Curso curso;
	EncargadoMatricula encargadoMatricula;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static JfMatricula getInstance() {
		if (jMatricula == null) {
			jMatricula = new JfMatricula();
		}
		return jMatricula;
	}

	/**
	 * Create the frame.
	 */
	public JfMatricula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMantenimientoDeEncargado = new JLabel("MANTENIMIENTO DE MATRICULA");
		lblMantenimientoDeEncargado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMantenimientoDeEncargado.setBounds(322, 10, 263, 35);
		contentPane.add(lblMantenimientoDeEncargado);

		JLabel lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCiclo.setBounds(10, 55, 39, 21);
		contentPane.add(lblCiclo);

		txtCiclo = new JTextField();
		txtCiclo.setText((String) null);
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(92, 55, 171, 19);
		contentPane.add(txtCiclo);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(275, 55, 49, 21);
		contentPane.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setText((String) null);
		txtFecha.setColumns(10);
		txtFecha.setBounds(344, 55, 171, 19);
		txtFecha.setEditable(false);
		contentPane.add(txtFecha);

		JLabel lblSeccion = new JLabel("Sección:");
		lblSeccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeccion.setBounds(525, 55, 60, 21);
		contentPane.add(lblSeccion);

		txtSeccion = new JTextField();
		txtSeccion.setText((String) null);
		txtSeccion.setColumns(10);
		txtSeccion.setBounds(595, 58, 171, 19);
		contentPane.add(txtSeccion);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurso.setBounds(525, 86, 49, 21);
		contentPane.add(lblCurso);

		JLabel lblDocente = new JLabel("Docente:");
		lblDocente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDocente.setBounds(277, 85, 75, 21);
		contentPane.add(lblDocente);

		JLabel lblEstudiante = new JLabel("Estudiante:");
		lblEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstudiante.setBounds(10, 86, 85, 21);
		contentPane.add(lblEstudiante);

		btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListar.setBounds(10, 199, 91, 21);
		btnListar.addActionListener(this);
		contentPane.add(btnListar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(473, 199, 91, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);

		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditar.setEnabled(false);
		btnEditar.setBounds(574, 199, 91, 21);
		btnEditar.addActionListener(this);
		contentPane.add(btnEditar);

		btnGuardar = new JButton("Registrar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setEnabled(true);
		btnGuardar.setBounds(675, 199, 91, 21);
		btnGuardar.addActionListener(this);
		contentPane.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(371, 450, 91, 21);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);

		cboEstudiante = new JComboBox<>();
		cboEstudiante.setBounds(92, 84, 171, 21);
		cboEstudiante.addActionListener(this::manejarSeleccionEstudiante);
		contentPane.add(cboEstudiante);

		cboDocente = new JComboBox<>();
		cboDocente.setBounds(344, 84, 171, 21);
		cboDocente.addActionListener(this::manejarSeleccionDocente);
		contentPane.add(cboDocente);

		cboCurso = new JComboBox<>();
		cboCurso.setBounds(595, 86, 171, 21);
		cboCurso.addActionListener(this::manejarSeleccionCurso);
		contentPane.add(cboCurso);

		JLabel lblEncargadoMatricula = new JLabel("Encargado");
		lblEncargadoMatricula.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEncargadoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEncargadoMatricula.setBounds(10, 119, 75, 21);
		contentPane.add(lblEncargadoMatricula);

		cboEncargadoMatricula = new JComboBox<>();
		cboEncargadoMatricula.setBounds(92, 131, 171, 21);
		cboEncargadoMatricula.addActionListener(this::manejarSeleccionEncargadoMatricula);
		contentPane.add(cboEncargadoMatricula);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(10, 142, 75, 21);
		contentPane.add(lblMatricula);

		jtListadoMatricula = new JTable();
		jtListadoMatricula.setModel(new DefaultTableModel(null, Constantes.COLUMNAS_MATRICULA));
		jtListadoMatricula.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(jtListadoMatricula);
		scrollPane.setBounds(10, 230, 879, 211);
		contentPane.add(scrollPane);

		llenarTablaMatricula();
		listarCombos();
		
		for (int i = 8; i <= 11; i++) {
	        jtListadoMatricula.getColumnModel().getColumn(i).setMinWidth(0);
	        jtListadoMatricula.getColumnModel().getColumn(i).setMaxWidth(0);
	        jtListadoMatricula.getColumnModel().getColumn(i).setPreferredWidth(0);
	        jtListadoMatricula.getColumnModel().getColumn(i).setPreferredWidth(0);
	    }

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			registrarMatricula();
		} else if (e.getSource() == btnCancelar) {
			JfMatricula.this.setVisible(false);
		} else if (e.getSource() == btnListar) {
			llenarTablaMatricula();
		} else if (e.getSource() == btnEditar) {
			editarMatricula();
		} else if (e.getSource() == btnEliminar) {
			eliminarMatricula();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int filaSeleccionada = jtListadoMatricula.getSelectedRow();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (filaSeleccionada != -1) {
			TableModel modelo = jtListadoMatricula.getModel();

			idMatricula = (int) modelo.getValueAt(filaSeleccionada, 0);
			txtCiclo.setText((String) modelo.getValueAt(filaSeleccionada, 1));

			Date utilDate = (Date) modelo.getValueAt(filaSeleccionada, 2);
			txtFecha.setText(sdf.format(utilDate));
			txtSeccion.setText((String) modelo.getValueAt(filaSeleccionada, 3));

			cboEstudiante.setSelectedItem(new Estudiante((int) modelo.getValueAt(filaSeleccionada, 8), null , null));
			cboDocente.setSelectedItem(new Docente((int) modelo.getValueAt(filaSeleccionada, 9), null , null));
			cboCurso.setSelectedItem(new Curso((int) modelo.getValueAt(filaSeleccionada, 10), null));
			int ss = (int) modelo.getValueAt(filaSeleccionada, 11);
			System.out.println(ss);
			cboEncargadoMatricula.setSelectedItem(new EncargadoMatricula((int) modelo.getValueAt(filaSeleccionada, 11), null , null));

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

	private void registrarMatricula() {
		try {
			String isValidacion = validarCampos();

			if (isValidacion != null) {
				JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = sdf.parse(txtFecha.getText());

			Matricula nuevaMatricula = new Matricula(0, txtCiclo.getText(), fecha, txtSeccion.getText(),
					new Estudiante(estudiante.getIdEstudiante(), estudiante.getApellidos(), estudiante.getNombres()),
					new Docente(docente.getIdDocente(), docente.getApellidos(), docente.getNombres()),
					new Curso(curso.getIdCurso(), curso.getNombreCurso()),
					new EncargadoMatricula(encargadoMatricula.getIdEncargadoMatricula(),
							encargadoMatricula.getApellidos(), encargadoMatricula.getNombres()),
					Constantes.USUARIO);

			boolean resultado = repositorio.guardarMatricula(nuevaMatricula);
			if (resultado) {
				JOptionPane.showMessageDialog(this, "Encargado matricula guardado correctamente");
				llenarTablaMatricula();
			} else {
				JOptionPane.showMessageDialog(this, "Error al guardar el Encargado matricula", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al guardar el Encargado matricula", "Error",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void llenarTablaMatricula() {
		DefaultTableModel modelo = (DefaultTableModel) jtListadoMatricula.getModel();

		modelo.setRowCount(0);

		List<Matricula> listaMatricula = repositorio.obtenerMatriculas();

		for (Matricula c : listaMatricula) {
			Object[] fila = new Object[12];

			fila[0] = c.getIdMatricula();
			fila[1] = c.getCiclo();
			fila[2] = c.getFecha();
			fila[3] = c.getSeccion();
			fila[4] = c.getEstudiante().getNombres() + " " + c.getEstudiante().getApellidos();
			fila[5] = c.getDocente().getNombres() + " " + c.getDocente().getApellidos();
			fila[6] = c.getCurso().getNombreCurso();
			fila[7] = c.getEncargadoMatricula().getNombres() + " " + c.getEncargadoMatricula().getApellidos();
			// PKS
			fila[8] = c.getEstudiante().getIdEstudiante();
			fila[9] = c.getDocente().getIdDocente();
			fila[10] = c.getCurso().getIdCurso();
			fila[11] = c.getEncargadoMatricula().getIdEncargadoMatricula();
			modelo.addRow(fila);
		}
		/* RESTABLECER VALORES */
		limpiar();

	}

	private String validarCampos() {
		if (txtCiclo.getText().isBlank() || txtCiclo.getText().isEmpty()) {
			return "Ingrese un ciclo.";
		}

		if (txtFecha.getText().isBlank() || txtFecha.getText().isEmpty()) {
			return "Ingrese la fecha.";
		}

		if (txtSeccion.getText().isBlank() || txtSeccion.getText().isEmpty()) {
			return "Ingrese una sección.";
		}

		if (cboEstudiante.getSelectedItem() == null) {
			return "Seleccione un estudiante.";
		}

		if (cboDocente.getSelectedItem() == null) {
			return "Seleccione un docente.";
		}

		if (cboCurso.getSelectedItem() == null) {
			return "Seleccione un curso.";
		}

		if (cboEncargadoMatricula.getSelectedItem() == null) {
			return "Seleccione un encargado de matricula.";
		}

		return null;
	}

	void limpiar() {
		idMatricula = 0;
		txtCiclo.setText(null);
		txtFecha.setText(fechaHoy.format(formatter));
		txtSeccion.setText(null);
		cboEstudiante.setSelectedItem(null);
		cboDocente.setSelectedItem(null);
		cboCurso.setSelectedItem(null);
		cboEncargadoMatricula.setSelectedItem(null);
		btnGuardar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}

	void editarMatricula() {
		try {
			String isValidacion = validarCampos();
			if (isValidacion != null) {
				JOptionPane.showMessageDialog(null, isValidacion, "Validación de datos.",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			if (idMatricula > 0) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fecha = sdf.parse(txtFecha.getText());

				Matricula actualizarMatricula = new Matricula(idMatricula, txtCiclo.getText(), fecha, txtSeccion.getText(),
						new Estudiante(estudiante.getIdEstudiante(), estudiante.getApellidos(),
								estudiante.getNombres()),
						new Docente(docente.getIdDocente(), docente.getApellidos(), docente.getNombres()),
						new Curso(curso.getIdCurso(), curso.getNombreCurso()),
						new EncargadoMatricula(encargadoMatricula.getIdEncargadoMatricula(),
								encargadoMatricula.getApellidos(), encargadoMatricula.getNombres()),
						Constantes.USUARIO);

				boolean resultado = repositorio.actualizarMatricula(actualizarMatricula);
				if (resultado) {
					JOptionPane.showMessageDialog(this, "Encargado matricula editado correctamente");
					llenarTablaMatricula();
				} else {
					JOptionPane.showMessageDialog(this, "Error al editar el Encargado matricula", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al editar el Encargado matricula", "Error",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	void eliminarMatricula() {
		if (idMatricula > 0) {
			boolean resultado = repositorio.eliminarMatricula(idMatricula);

			if (resultado) {
				JOptionPane.showMessageDialog(this, "Matricula eliminado correctamente");
				llenarTablaMatricula();
			} else {
				JOptionPane.showMessageDialog(this, "Error al eliminar la matricula", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	/* PARA MANEJAR LOS EVENTOS DE LOS COMBOX */
	private void manejarSeleccionEstudiante(ActionEvent e) {
		estudiante = (Estudiante) cboEstudiante.getSelectedItem();
	}

	private void manejarSeleccionDocente(ActionEvent e) {
		docente = (Docente) cboDocente.getSelectedItem();
	}

	private void manejarSeleccionCurso(ActionEvent e) {
		curso = (Curso) cboCurso.getSelectedItem();
	}

	private void manejarSeleccionEncargadoMatricula(ActionEvent e) {
		encargadoMatricula = (EncargadoMatricula) cboEncargadoMatricula.getSelectedItem();
	}

	/* PARA LLENAR LOS COMBOX */
	private void listarCombos() {
		List<Estudiante> listaEstudiante = repositorioEstudiante.obtenerEstudiantes();
		cboEstudiante.addItem(null);
		for (Estudiante e : listaEstudiante) {
			cboEstudiante.addItem(e);
		}

		List<Docente> listaDocente = repositorioDocente.obtenerDocentes();
		cboDocente.addItem(null);
		for (Docente d : listaDocente) {
			cboDocente.addItem(d);
		}

		List<Curso> listaCurso = repositorioCurso.obtenerCursos();
		cboCurso.addItem(null);
		for (Curso c : listaCurso) {
			cboCurso.addItem(c);
		}

		List<EncargadoMatricula> listaEncargadoMatricula = repositorioEncargadoMatricula.obtenerEncargadoMatriculas();
		cboEncargadoMatricula.addItem(null);
		for (EncargadoMatricula em : listaEncargadoMatricula) {
			cboEncargadoMatricula.addItem(em);
		}
	}
}
