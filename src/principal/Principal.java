package principal;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimiento.JfCurso;
import mantenimiento.JfDocente;
import mantenimiento.JfEncargadoMatricula;
import mantenimiento.JfEstudiante;
import mantenimiento.JfMatricula;

public class Principal extends JFrame implements ActionListener {

	static Principal frame;
	private JPanel contentPane;
	JMenuItem mntmSalir;
	JMenuItem mntmCursos;
	JDesktopPane desktopPane;
	JMenuItem mntmEstudiantes;
	JMenuItem mntmEncargadoMatricula;
	JMenuItem mntmDocente;
	JMenuItem mntmMatricula;
	JMenuItem mntmAcercaDeTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "¿Seguro que desea cerrar el programa?",
						"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Colegio Fe y Alegria");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		// setUndecorated(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmCursos = new JMenuItem("Mantenimiento Cursos");
		mntmCursos.addActionListener(this);
		mnMantenimiento.add(mntmCursos);

		mntmEstudiantes = new JMenuItem("Mantenimiento Estudiantes");
		mntmEstudiantes.addActionListener(this);
		mnMantenimiento.add(mntmEstudiantes);

		mntmEncargadoMatricula = new JMenuItem("Mantenimiento Encargado Matricula");
		mntmEncargadoMatricula.addActionListener(this);
		mnMantenimiento.add(mntmEncargadoMatricula);
		
		mntmDocente = new JMenuItem("Mantenimiento Docente");
		mntmDocente.addActionListener(this);
		mnMantenimiento.add(mntmDocente);
		
		mntmMatricula = new JMenuItem("Mantenimiento Matricula");
		mntmMatricula.addActionListener(this);
		mnMantenimiento.add(mntmMatricula);

		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcercaDeTienda = new JMenuItem("Acerca de tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == mntmSalir) {
			Salir();
		} else if (e.getSource() == mntmCursos) {
			Mostrar(JfCurso.getInstance(), desktopPane);

		} else if (e.getSource() == mntmDocente) {
			Mostrar(JfDocente.getInstance(), desktopPane);
		} else if (e.getSource() ==  mntmEstudiantes) {
			Mostrar(JfEstudiante.getInstance(), desktopPane);
		} else if(e.getSource() == mntmEncargadoMatricula){
			Mostrar(JfEncargadoMatricula.getInstance(), desktopPane);
		} else if(e.getSource() == mntmMatricula){
			Mostrar(JfMatricula.getInstance(), desktopPane);
		} else if (e.getSource() == mntmAcercaDeTienda) {
			Mostrar(AcercaDelProyecto.getInstance(), desktopPane);
		}
	}

	void Mostrar(JInternalFrame jif, JDesktopPane dp) {
		if (jif.isVisible()) {
			jif.toFront();
			jif.requestFocus();
		} else {
			dp.remove(jif);
			dp.add(jif);
			jif.setVisible(true);
		}

		Dimension desktopSize = dp.getSize();
		Dimension frameSize = jif.getSize();
		jif.setLocation((desktopSize.width - frameSize.width) / 4, (desktopSize.height - frameSize.height) / 4);
	}

	void Salir() {
		int respuesta = JOptionPane.showConfirmDialog(frame, "¿Seguro que desea cerrar el programa?", "Confirmación",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
