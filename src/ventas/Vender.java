package ventas;
import java.awt.EventQueue;

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
import javax.swing.JTextArea;

public class Vender extends JInternalFrame implements ActionListener, ItemListener {
	static Vender frame;
	JComboBox<String> cbxModelo;
	JButton btnCerrar;
	JSpinner spnPrecio;
	JSpinner spnCantidad;
	private JButton btnVender;
	private JTextArea txtaResultado;

	static Vender vender;
	
	public static Vender getInstance() {
		if (vender == null) {
			vender = new Vender();
		}
		
		return vender;
	}
	
	/**
	 * Create the frame.
	 */
	public Vender() {
		setTitle("Vender Televisores");
		setBounds(100, 100, 450, 309);
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
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 79, 75, 14);
		getContentPane().add(lblCantidad);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(339, 39, 85, 23);
		getContentPane().add(btnCerrar);
		
		spnPrecio = new JSpinner();
		spnPrecio.setEnabled(false);
		spnPrecio.setBounds(111, 41, 86, 20);
		//spnPrecio.setValue(global.precio0);
		getContentPane().add(spnPrecio);
		
		spnCantidad = new JSpinner();
		spnCantidad.setBounds(111, 73, 86, 20);
		getContentPane().add(spnCantidad);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(339, 8, 85, 21);
		btnVender.addActionListener(this);
		getContentPane().add(btnVender);
		
		txtaResultado = new JTextArea();
		txtaResultado.setEditable(false);
		txtaResultado.setBounds(10, 103, 414, 167);
		getContentPane().add(txtaResultado);

		AutocompletarPrecio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCerrar) {
			Vender.this.setVisible(false);
		} else if (e.getSource() == btnVender) {
			VenderTelevisor();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cbxModelo) {
			AutocompletarPrecio();
		}
	}
	
	void AutocompletarPrecio() {
		
		int idx = cbxModelo.getSelectedIndex();
		spnCantidad.setValue(0);
		
		switch (idx) {
		case 0:
			spnPrecio.setValue(global.precio0);
			break;
		case 1:
			spnPrecio.setValue(global.precio1);
			break;
		case 2:
			spnPrecio.setValue(global.precio2);
			break;
		case 3:
			spnPrecio.setValue(global.precio3);
			break;
		default: break;
		}
	}
	
	void VenderTelevisor() {
		
		int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
		
		if(cantidad <= 0) {
			JOptionPane.showMessageDialog(null, "Por favor digitar una cantidad.");
			return;
		}
		
		global.numeroVentasAcumulado += 1;
		double precio = Double.parseDouble(spnPrecio.getValue().toString());
		double importeCompra = cantidad * precio;
		double importeDescuento = 0;
		String obsequio = "";
		
		if (cantidad <= 5) {
			importeDescuento = importeCompra * (global.porcentaje1 / 100);
			
		} else if (cantidad >= 6 && cantidad <= 10) {
			importeDescuento = importeCompra * (global.porcentaje2 / 100);
		} else if (cantidad >= 11 && cantidad <= 15) {
			importeDescuento = importeCompra * (global.porcentaje3 / 100);
		} else if (cantidad > 15) {
			importeDescuento = importeCompra * (global.porcentaje4 / 100);
		}
		
		double importePagar = importeCompra - importeDescuento;
		global.totalGeneralAcumulado += importePagar;
		
		if (cantidad == 1) {
			obsequio = global.obsequio1;
		} else if (cantidad > 1 && cantidad <= 5) {
			obsequio = global.obsequio2;
		} else if (cantidad > 5) {
			obsequio = global.obsequio3;
		}
		
		int idx = cbxModelo.getSelectedIndex();
		
		switch (idx) {
		case 0:
			global.numeroVentasAcumuladoModelo0 += 1;
			global.cantidadVentasAcumuladoModelo0 += cantidad;
			global.importeTotalAcumuladoModelo0 += importePagar;
			break;
		case 1:
			global.numeroVentasAcumuladoModelo1 += 1;
			global.cantidadVentasAcumuladoModelo1 += cantidad;
			global.importeTotalAcumuladoModelo1 += importePagar;
			break;
		case 2:
			global.numeroVentasAcumuladoModelo2 += 1;
			global.cantidadVentasAcumuladoModelo2 += cantidad;
			global.importeTotalAcumuladoModelo2 += importePagar;
			break;
		case 3:
			global.numeroVentasAcumuladoModelo3 += 1;
			global.cantidadVentasAcumuladoModelo3 += cantidad;
			global.importeTotalAcumuladoModelo3 += importePagar;
			break;
		default: break;
		}
		
		txtaResultado.setText(" BOLETA DE VENTA\n\n");
		txtaResultado.append(" Precio\t\t: S/. " + precio + "\n");
		txtaResultado.append(" Cantidad\t\t: " + cantidad + "\n");
		txtaResultado.append(" Importe compra\t: S/. " + importeCompra + "\n");
		txtaResultado.append(" Importe descuento\t: S/. " + importeDescuento + "\n");
		txtaResultado.append(" Importe pagar\t\t: S/. " + importePagar + "\n");
		txtaResultado.append(" Obsequio\t\t: " + obsequio + "\n");
		
		if((global.numeroVentasAcumulado % 5) == 0) {
			JOptionPane.showMessageDialog(null, "Venta Nro. " + global.numeroVentasAcumulado
					+ "\nImporte total general acumulado : S/. " + global.totalGeneralAcumulado + "\n"
					+ "Porcentaje de la cuota diaria :" + ((global.totalGeneralAcumulado * 100) / global.cuotaDiaria),
					"Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
		}
		
		spnCantidad.setValue(0);
	}
}
