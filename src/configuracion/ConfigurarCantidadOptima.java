package configuracion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import entidad.global;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class ConfigurarCantidadOptima extends JInternalFrame implements ActionListener {
	JButton btnAceptar;
	JButton btnCancelar;
	private JSpinner spinner;

	static ConfigurarCantidadOptima configCantidadOptima;
	
	public static ConfigurarCantidadOptima getInstance() {
		if (configCantidadOptima == null) {
			configCantidadOptima = new ConfigurarCantidadOptima();
		}
		
		return configCantidadOptima;
	}

	/**
	 * Create the frame.
	 */
	public ConfigurarCantidadOptima() {
		setTitle("Configurar cantidad óptma");
		setBounds(100, 100, 450, 119);
		getContentPane().setLayout(null);
		
		JLabel lblCantidadptimaDe = new JLabel("Cantidad \u00D3ptima de Unidades Vendidas");
		lblCantidadptimaDe.setBounds(10, 22, 236, 14);
		getContentPane().add(lblCantidadptimaDe);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(335, 18, 89, 23);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 52, 89, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		spinner = new JSpinner();
		spinner.setBounds(256, 20, 69, 20);
		getContentPane().add(spinner);

		CargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAceptar) {
			ModificarDatos();
		} else if (e.getSource() == btnCancelar) {
			ConfigurarCantidadOptima.this.setVisible(false);
		}
	}
	
	void CargarDatos() {
		spinner.setValue(global.cantidadOptima);
	}
	
	void ModificarDatos() {
		global.cantidadOptima = Integer.parseInt(spinner.getValue().toString());
		ConfigurarCantidadOptima.this.setVisible(false);
	}

}
