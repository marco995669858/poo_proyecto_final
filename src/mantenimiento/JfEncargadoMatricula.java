package mantenimiento;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JfEncargadoMatricula extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JfEncargadoMatricula jEncargadoMatricula;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

}
