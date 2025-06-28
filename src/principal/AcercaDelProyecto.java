package principal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class AcercaDelProyecto extends JInternalFrame implements ActionListener {
	
	JButton btnCancelar;

	static AcercaDelProyecto acercaTienda;
	
	public static AcercaDelProyecto getInstance() {
		if (acercaTienda == null) {
			acercaTienda = new AcercaDelProyecto();
		}
		
		return acercaTienda;
	}

	/**
	 * Create the frame.
	 */
	public AcercaDelProyecto() {
		setBounds(100, 100, 458, 259);
		getContentPane().setLayout(null);
		
		JLabel lblTienda = new JLabel("COLEGIO FE Y ALEGRIA 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTienda.setBounds(165, 11, 98, 14);
		getContentPane().add(lblTienda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 414, 2);
		getContentPane().add(separator);
		
		JLabel lblAutores = new JLabel("Autores");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(187, 49, 64, 14);
		getContentPane().add(lblAutores);
		
		JLabel lblMarco = new JLabel("MARCO ANTONIO MUÑOZ MELENDEZ");
		lblMarco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarco.setBounds(110, 73, 245, 15);
		getContentPane().add(lblMarco);
		
		btnCancelar = new JButton("Cerrar");
		btnCancelar.setBounds(165, 194, 87, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		JLabel lblLuis = new JLabel("LUIS ENRIQUE TAPIA ROJAS");
		lblLuis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLuis.setBounds(110, 159, 175, 14);
		getContentPane().add(lblLuis);
		
		JLabel lblErick = new JLabel("ERICK ENRIQUE FARFAN ROSALES");
		lblErick.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErick.setBounds(110, 127, 203, 14);
		getContentPane().add(lblErick);
		
		JLabel lblAylen = new JLabel("AYLEN DANIELA GUTIERREZ TAMARA");
		lblAylen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAylen.setBounds(110, 98, 232, 14);
		getContentPane().add(lblAylen);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCancelar) {
			AcercaDelProyecto.this.setVisible(false);
		}
	}
}
