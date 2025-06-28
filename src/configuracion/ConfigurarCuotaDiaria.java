package configuracion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;

import entidad.global;

public class ConfigurarCuotaDiaria extends JInternalFrame implements ActionListener {

	JSpinner spinner;
	JButton btnAceptar;
	JButton btnCancelar;
	
	static ConfigurarCuotaDiaria configCuotaDiaria;
	
	public static ConfigurarCuotaDiaria getInstance() {
		if (configCuotaDiaria == null) {
			configCuotaDiaria = new ConfigurarCuotaDiaria();
		}
		return configCuotaDiaria;
	}

	/**
	 * Create the frame.
	 */
	public ConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 119);
		getContentPane().setLayout(null);
		
		JLabel lblCuotaDiaraEsperada = new JLabel("Cuota Diar\u00EDa Esperada (S/.)");
		lblCuotaDiaraEsperada.setBounds(28, 32, 170, 14);
		getContentPane().add(lblCuotaDiaraEsperada);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(335, 11, 89, 23);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 45, 89, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		spinner = new JSpinner();
		spinner.setBounds(189, 30, 70, 20);
		getContentPane().add(spinner);

		CargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAceptar) {
			ModificarDatos();
		} else if (e.getSource() == btnCancelar) {
			ConfigurarCuotaDiaria.this.setVisible(false);
		}
	}
	
	void CargarDatos() {
		spinner.setValue(global.cuotaDiaria);
	}
	
	void ModificarDatos() {
		global.cuotaDiaria = Double.parseDouble(spinner.getValue().toString());
		ConfigurarCuotaDiaria.this.setVisible(false);
	}

}
