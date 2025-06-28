package configuracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entidad.global;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ConfigurarDescuento extends JInternalFrame implements ActionListener {
	JButton btnAceptar;
	JButton btnCancelar;
	JSpinner spn1;
	JSpinner spn2;
	JSpinner spn3;
	JSpinner spn4;

	static ConfigurarDescuento configurarDescuento;
	
	public static ConfigurarDescuento getInstance() {
		if (configurarDescuento == null) {
			configurarDescuento = new ConfigurarDescuento();
		}
		
		return configurarDescuento;
	}

	/**
	 * Create the frame.
	 */
	public ConfigurarDescuento() {
		setTitle("Configurar Descuentos");
		setBounds(100, 100, 449, 206);
		getContentPane().setLayout(null);
		
		JLabel lblA = new JLabel("1 a 5 unidades");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblA.setBounds(22, 21, 105, 14);
		getContentPane().add(lblA);
		
		JLabel lbl4 = new JLabel("6 a 10 unidades");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl4.setBounds(22, 60, 105, 14);
		getContentPane().add(lbl4);
		
		JLabel lblA_1 = new JLabel("11 a 15 unidades");
		lblA_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblA_1.setBounds(22, 101, 105, 14);
		getContentPane().add(lblA_1);
		
		JLabel lblMasDe = new JLabel("Mas de 15 unidades");
		lblMasDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMasDe.setBounds(22, 139, 129, 14);
		getContentPane().add(lblMasDe);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(334, 18, 89, 23);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(334, 57, 89, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		JLabel label = new JLabel("%");
		label.setBounds(244, 22, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("%");
		label_1.setBounds(244, 61, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("%");
		label_2.setBounds(244, 102, 46, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("%");
		label_3.setBounds(244, 140, 46, 14);
		getContentPane().add(label_3);
		
		spn1 = new JSpinner();
		spn1.setBounds(153, 20, 81, 20);
		getContentPane().add(spn1);
		
		spn2 = new JSpinner();
		spn2.setBounds(153, 59, 81, 20);
		getContentPane().add(spn2);
		
		spn3 = new JSpinner();
		spn3.setBounds(153, 100, 81, 20);
		getContentPane().add(spn3);
		
		spn4 = new JSpinner();
		spn4.setBounds(153, 138, 81, 20);
		getContentPane().add(spn4);

		CargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAceptar) {
			GrabarValores();
		} else if (e.getSource() == btnCancelar) {
			ConfigurarDescuento.this.setVisible(false);
		}
	}
	
	void CargarDatos() {
		spn1.setValue(global.porcentaje1);
		spn2.setValue(global.porcentaje2);
		spn3.setValue(global.porcentaje3);
		spn4.setValue(global.porcentaje4);
	}
	
	void GrabarValores() {
		global.porcentaje1 = Double.parseDouble(spn1.getValue().toString());
		global.porcentaje2 = Double.parseDouble(spn2.getValue().toString());
		global.porcentaje3 = Double.parseDouble(spn3.getValue().toString());
		global.porcentaje4 = Double.parseDouble(spn4.getValue().toString());
		ConfigurarDescuento.this.setVisible(false);
	}

}
