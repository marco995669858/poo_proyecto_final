package configuracion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidad.global;

import javax.swing.JButton;

public class ConfigurarObsequio extends JInternalFrame implements ActionListener {
	private JTextField txf1;
	private JTextField txf2;
	private JTextField txf3;
	JButton btnAceptar;
	JButton btnCancelar;

	static ConfigurarObsequio configurarObsequio;
	
	public static ConfigurarObsequio getInstance() {
		if (configurarObsequio == null) {
			configurarObsequio = new ConfigurarObsequio();
		}
		return configurarObsequio;
	}

	/**
	 * Create the frame.
	 */
	public ConfigurarObsequio() {
		setTitle("Configurar obsequio");
		setBounds(100, 100, 450, 180);
		getContentPane().setLayout(null);
		
		JLabel lblUnidad = new JLabel("1 unidad");
		lblUnidad.setBounds(24, 26, 77, 14);
		getContentPane().add(lblUnidad);
		
		txf1 = new JTextField();
		txf1.setBounds(147, 24, 86, 20);
		getContentPane().add(txf1);
		txf1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("2 a 5 unidades");
		lblNewLabel.setBounds(24, 68, 95, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblMsDe = new JLabel("6 a más unidades");
		lblMsDe.setBounds(24, 111, 113, 14);
		getContentPane().add(lblMsDe);
		
		txf2 = new JTextField();
		txf2.setBounds(147, 66, 86, 20);
		getContentPane().add(txf2);
		txf2.setColumns(10);
		
		txf3 = new JTextField();
		txf3.setBounds(147, 109, 86, 20);
		getContentPane().add(txf3);
		txf3.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(322, 22, 89, 23);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(322, 64, 89, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);

		CargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCancelar) {
			ConfigurarObsequio.this.setVisible(false);
		} else if (e.getSource() == btnAceptar) {
			CambiarDatos();
		}
	}
	
	void CargarDatos() {
		txf1.setText(global.obsequio1);
		txf2.setText(global.obsequio2);
		txf3.setText(global.obsequio3);
	}
	
	void CambiarDatos() {
		global.obsequio1 = txf1.getText();
		global.obsequio2 = txf2.getText();
		global.obsequio3 = txf3.getText();
		ConfigurarObsequio.this.setVisible(false);
	}

}
