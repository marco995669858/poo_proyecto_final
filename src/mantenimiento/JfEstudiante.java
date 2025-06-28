package mantenimiento;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JfEstudiante extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JfEstudiante jEstudiante;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

}
