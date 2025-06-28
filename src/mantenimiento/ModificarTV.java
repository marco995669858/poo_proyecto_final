	package mantenimiento;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import entidad.global;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarTV extends JInternalFrame implements ActionListener, ItemListener {

	JComboBox<String> cbxModelo;
	JButton btnCerrar;
	JSpinner spnPrecio;
	JSpinner spnAncho;
	JSpinner spnAlto;
	JSpinner spnPulgada;
	JButton btnGrabar;
	
	static ModificarTV modificarTelevisor;
	
	public static ModificarTV getInstance() {
		if (modificarTelevisor == null) {
			modificarTelevisor = new ModificarTV();
		}
		return modificarTelevisor;
	}

	/**
	 * Create the frame.
	 */
	public ModificarTV() {
		setTitle("Modificar Televisor");
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
		//cbxModelo.setSelectedIndex(0);
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
		spnPrecio.setBounds(111, 41, 86, 20);
		getContentPane().add(spnPrecio);
		
		spnAncho = new JSpinner();
		spnAncho.setBounds(111, 73, 86, 20);
		getContentPane().add(spnAncho);
		
		spnAlto = new JSpinner();
		spnAlto.setBounds(111, 108, 86, 20);
		getContentPane().add(spnAlto);
		
		spnPulgada = new JSpinner();
		spnPulgada.setBounds(111, 138, 86, 20);
		getContentPane().add(spnPulgada);
		
		JLabel lblPulgada = new JLabel("Pulgadas");
		lblPulgada.setBounds(10, 141, 91, 13);
		getContentPane().add(lblPulgada);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(335, 40, 85, 21);
		btnGrabar.addActionListener(this);
		getContentPane().add(btnGrabar);

		AutocompletarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCerrar) {
			ModificarTV.this.setVisible(false);
		} else if (e.getSource() == btnGrabar) {
			GrabarTelevisor();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cbxModelo) {
			AutocompletarDatos();			
		}
	}
	
	void AutocompletarDatos() {
		
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
	
	void GrabarTelevisor() {
		
		double precio = Double.parseDouble(spnPrecio.getValue().toString());
		double ancho = Double.parseDouble(spnAncho.getValue().toString());
		double alto = Double.parseDouble(spnAlto.getValue().toString());
		double pulgada = Double.parseDouble(spnPulgada.getValue().toString());
		
		if (precio <= 0) {
			JOptionPane.showMessageDialog(null, "El PRECIO no puede ser cero.", "Validación", JOptionPane.WARNING_MESSAGE);
			return;
		} else if (ancho <= 0) {
			JOptionPane.showMessageDialog(null, "El ANCHO no puede ser cero.", "Validación", JOptionPane.WARNING_MESSAGE);
			return;
		} else if (alto <= 0) {
			JOptionPane.showMessageDialog(null, "El ALTO no puede ser cero.", "Validación", JOptionPane.WARNING_MESSAGE);
			return;
		} else if (pulgada <= 0) {
			JOptionPane.showMessageDialog(null, "La PULGADA no puede ser cero.", "Validación", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro de grabar los datos ingresados?", "Confirmación",
				JOptionPane.YES_NO_OPTION, JOptionPane.OK_OPTION);
		
		if (respuesta == JOptionPane.YES_OPTION) {
			int idx = cbxModelo.getSelectedIndex();
			
			switch (idx) {
			case 0:
				global.precio0 = precio;
				global.ancho0 = ancho;
				global.alto0 = alto;
				global.pulgada0 = pulgada;
				break;
			case 1:
				global.precio1 = precio;
				global.ancho1 = ancho;
				global.alto1 = alto;
				global.pulgada1 = pulgada;
				break;
			case 2:
				global.precio2 = precio;
				global.ancho2 = ancho;
				global.alto2 = alto;
				global.pulgada2 = pulgada;
				break;
			case 3:
				global.precio3 = precio;
				global.ancho3 = ancho;
				global.alto3 = alto;
				global.pulgada3 = pulgada;
				break;
			default: break;
			}
			
			ModificarTV.this.setVisible(false);
		}	
	}
}
