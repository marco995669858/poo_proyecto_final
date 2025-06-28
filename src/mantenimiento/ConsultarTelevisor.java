package mantenimiento;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import entidad.global;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarTelevisor extends JInternalFrame implements ActionListener, ItemListener {

	JComboBox<String> cbxModelo;
	JButton btnCerrar;
	JSpinner spnPrecio;
	JSpinner spnAncho;
	JSpinner spnAlto;
	JSpinner spnPulgada;
	
	static ConsultarTelevisor consultarTelevsor;
	
	public static ConsultarTelevisor getInstance() {
		if (consultarTelevsor == null) {
			consultarTelevsor = new ConsultarTelevisor();
		}
		return consultarTelevsor;
	}

	/**
	 * Create the frame.
	 */
	public ConsultarTelevisor() {
		setTitle("Consultar Televisores");
		setBounds(100, 100, 450, 214);
		getContentPane().setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 75, 14);
		getContentPane().add(lblModelo);
		
		cbxModelo = new JComboBox<String>();
		cbxModelo.setBounds(111, 11, 198, 20);
		cbxModelo.addItem(global.modelo0);
		cbxModelo.addItem(global.modelo1);
		cbxModelo.addItem(global.modelo2);
		cbxModelo.addItem(global.modelo3);
		cbxModelo.addItemListener(this);
		getContentPane().add(cbxModelo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 48, 75, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setBounds(10, 79, 75, 14);
		getContentPane().add(lblAncho);
		
		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setBounds(10, 110, 75, 14);
		getContentPane().add(lblAlto);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);

		btnCerrar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnCerrar);
		
		spnPrecio = new JSpinner();
		spnPrecio.setEnabled(false);
		spnPrecio.setBounds(111, 41, 86, 20);
		getContentPane().add(spnPrecio);
		
		spnAncho = new JSpinner();
		spnAncho.setEnabled(false);
		spnAncho.setBounds(111, 73, 86, 20);
		getContentPane().add(spnAncho);
		
		spnAlto = new JSpinner();
		spnAlto.setEnabled(false);
		spnAlto.setBounds(111, 108, 86, 20);
		getContentPane().add(spnAlto);
		
		spnPulgada = new JSpinner();
		spnPulgada.setEnabled(false);
		spnPulgada.setBounds(111, 138, 86, 20);
		getContentPane().add(spnPulgada);
		
		JLabel lblPulgada = new JLabel("Pulgadas");
		lblPulgada.setBounds(10, 141, 91, 13);
		getContentPane().add(lblPulgada);

		CargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnCerrar) {
			consultarTelevsor.setVisible(false);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cbxModelo) {
			CargarDatos();			
		}
	}
	
	void CargarDatos() {
		int idx = cbxModelo.getSelectedIndex();
		
		switch (idx) {
		case 0:
			spnPrecio.setValue(global.precio0);
			spnAncho.setValue(global.ancho0);
			spnAlto.setValue(global.alto0);
			spnPulgada.setValue(global.pulgada0);
			break;
		case 1:
			spnPrecio.setValue(global.precio1);
			spnAncho.setValue(global.ancho1);
			spnAlto.setValue(global.alto1);
			spnPulgada.setValue(global.pulgada1);
			break;
		case 2:
			spnPrecio.setValue(global.precio2);
			spnAncho.setValue(global.ancho2);
			spnAlto.setValue(global.alto2);
			spnPulgada.setValue(global.pulgada2);
			break;
		case 3:
			spnPrecio.setValue(global.precio3);
			spnAncho.setValue(global.ancho3);
			spnAlto.setValue(global.alto3);
			spnPulgada.setValue(global.pulgada3);
			break;
		default: break;
		}
	}
}
