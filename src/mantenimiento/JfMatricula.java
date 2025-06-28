package mantenimiento;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JfMatricula extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JfMatricula jMatricula;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

}
