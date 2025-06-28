package ventas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.global;

public class GenerarReportes extends JInternalFrame implements ActionListener, ItemListener {
	
	static GenerarReportes frame;
	JComboBox<String> comboBox;
	JButton btnCerrar;
	JTextArea txtaResultado;

	static GenerarReportes generarReportes;
	
	public static GenerarReportes getInstance() {
		if (generarReportes == null) {
			generarReportes = new GenerarReportes();
		}
		
		return generarReportes;
	}

	/**
	 * Create the frame.
	 */
	public GenerarReportes() {
		setTitle("Generar reportes");
		setBounds(100, 100, 622, 380);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 10, 101, 13);
		getContentPane().add(lblNewLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(133, 10, 262, 21);
		comboBox.addItem("Ventas por modelo");
		comboBox.addItem("Ventas en relación a la venta optima");
		comboBox.addItem("Precios en relación al precio promedio");
		comboBox.addItem("Promedios, menores y mayores");
		comboBox.addItemListener(this);
		getContentPane().add(comboBox);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(511, 10, 85, 21);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		txtaResultado = new JTextArea();
		txtaResultado.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtaResultado);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 61, 586, 279);
		getContentPane().add(scrollPane);
		
		Reportes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCerrar) {
			GenerarReportes.this.setVisible(false);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == comboBox) {
			Reportes();
		}
	}
	
	void Reportes() {
		
		txtaResultado.setText("");
		int idx = comboBox.getSelectedIndex();
		
		switch (idx) {
		case 0:
			ReporteVentasModelo();
			break;
		case 1:
			ReporteVentasRelacionVentaOptima();
			break;
		case 2:
			ReportePreciosRelacionPrecioPromedio();
			break;
		case 3:
			ReportePromediosMenoresMayores();
			break;
		default: break;
		}
	}
	
	void ReporteVentasModelo() {
		txtaResultado.setText(" VENTAS POR MODELO\n\n");
		txtaResultado.append(" Modelo\t\t\t: " + global.modelo0 + "\n");
		txtaResultado.append(" Cantidad de ventas\t\t: " + global.numeroVentasAcumuladoModelo0 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t\t: " + global.cantidadVentasAcumuladoModelo0 + "\n");
		txtaResultado.append(" Importe total vendido\t\t: S/. " + global.importeTotalAcumuladoModelo0 + "\n");
		txtaResultado.append(" Aporte de la cuota diaria\t\t: " + ((global.importeTotalAcumuladoModelo0 * 100) / global.cuotaDiaria) + " %\n\n");
		
		txtaResultado.append(" Modelo\t\t\t: " + global.modelo1 + "\n");
		txtaResultado.append(" Cantidad de ventas\t\t: " + global.numeroVentasAcumuladoModelo1 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t\t: " + global.cantidadVentasAcumuladoModelo1 + "\n");
		txtaResultado.append(" Importe total vendido\t\t: S/. " + global.importeTotalAcumuladoModelo1 + "\n");
		txtaResultado.append(" Aporte de la cuota diaria\t\t: " + ((global.importeTotalAcumuladoModelo1 * 100) / global.cuotaDiaria) + " %\n\n");
		
		txtaResultado.append(" Modelo\t\t\t: " + global.modelo2 + "\n");
		txtaResultado.append(" Cantidad de ventas\t\t: " + global.numeroVentasAcumuladoModelo2 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t\t: " + global.cantidadVentasAcumuladoModelo2 + "\n");
		txtaResultado.append(" Importe total vendido\t\t: S/. " + global.importeTotalAcumuladoModelo2 + "\n");
		txtaResultado.append(" Aporte de la cuota diaria\t\t: " + ((global.importeTotalAcumuladoModelo2 * 100) / global.cuotaDiaria) + " %\n\n");
		
		txtaResultado.append(" Modelo\t\t\t: " + global.modelo3 + "\n");
		txtaResultado.append(" Cantidad de ventas\t\t: " + global.numeroVentasAcumuladoModelo3 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t\t: " + global.cantidadVentasAcumuladoModelo3 + "\n");
		txtaResultado.append(" Importe total vendido\t\t: S/." + global.importeTotalAcumuladoModelo3 + "\n");
		txtaResultado.append(" Aporte de la cuota diaria\t\t: " + ((global.importeTotalAcumuladoModelo3 * 100) / global.cuotaDiaria) + " %\n\n");
	}
	
	void ReporteVentasRelacionVentaOptima() {
		
		int cantUnidVendidasModelo0 = global.cantidadVentasAcumuladoModelo0 - global.cantidadOptima;
		int cantUnidVendidasModelo1 = global.cantidadVentasAcumuladoModelo1 - global.cantidadOptima;
		int cantUnidVendidasModelo2 = global.cantidadVentasAcumuladoModelo2 - global.cantidadOptima;
		int cantUnidVendidasModelo3 = global.cantidadVentasAcumuladoModelo3 - global.cantidadOptima;
		
		txtaResultado.setText(" VENTAS EN RELACIÓN A LA VENTA ÓPTIMA\n\n");
		txtaResultado.append(" Modelo\t\t: " + global.modelo0 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t: " + global.cantidadVentasAcumuladoModelo0);
		if (cantUnidVendidasModelo0 < 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo0 * -1 + " menos que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo0 > 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo0 + " más que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo0 == 0) {
			txtaResultado.append(" (igual a la cantidad óptima)\n\n");
		}
		
		txtaResultado.append(" Modelo\t\t: " + global.modelo1 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t: " + global.cantidadVentasAcumuladoModelo1);
		if (cantUnidVendidasModelo1 < 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo1 * -1 + " menos que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo1 > 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo1 + " más que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo1 == 0) {
			txtaResultado.append(" (igual a la cantidad óptima)\n\n");
		}
		
		txtaResultado.append(" Modelo\t\t: " + global.modelo2 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t: " + global.cantidadVentasAcumuladoModelo2);
		if (cantUnidVendidasModelo2 < 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo2 * -1 + " menos que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo2 > 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo2 + " más que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo2 == 0) {
			txtaResultado.append(" (igual a la cantidad óptima)\n\n");
		}
		
		txtaResultado.append(" Modelo\t\t: " + global.modelo3 + "\n");
		txtaResultado.append(" Cantidad de unidades vendidas\t: " + global.cantidadVentasAcumuladoModelo3);
		if (cantUnidVendidasModelo3 < 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo3 * -1 + " menos que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo3 > 0) {
			txtaResultado.append(" (" + cantUnidVendidasModelo3 + " más que la cantidad óptima)\n\n");
		} else if (cantUnidVendidasModelo3 == 0) {
			txtaResultado.append(" (igual a la cantidad óptima)\n\n");
		}
	}
	
	void ReportePreciosRelacionPrecioPromedio() {
		
		double promedio0 = global.importeTotalAcumuladoModelo0 / global.cantidadVentasAcumuladoModelo0;
		double promedio1 = global.importeTotalAcumuladoModelo1 / global.cantidadVentasAcumuladoModelo1;
		double promedio2 = global.importeTotalAcumuladoModelo2 / global.cantidadVentasAcumuladoModelo2;
		double promedio3 = global.importeTotalAcumuladoModelo3 / global.cantidadVentasAcumuladoModelo3;
		
		txtaResultado.setText(" PRECIOS EN RELACIÓN AL PRECIO PROMEDIO\n\n");
		txtaResultado.append(" Modelo\t\t: " + global.modelo0 + "\n");
		txtaResultado.append(" Precio\t\t: S/. " + global.precio0);
		if (global.precio0 > promedio0) {
			txtaResultado.append(" (Mayor al promedio)\n\n");
		} else {
			txtaResultado.append(" (Menor al promedio)\n\n");
		}
		
		txtaResultado.append(" Modelo\t\t: " + global.modelo1 + "\n");
		txtaResultado.append(" Precio\t\t: S/. " + global.precio1);
		if (global.precio1 > promedio1) {
			txtaResultado.append(" (Mayor al promedio)\n\n");
		} else {
			txtaResultado.append(" (Menor al promedio)\n\n");
		}
		
		txtaResultado.append(" Modelo\t\t: " + global.modelo2 + "\n");
		txtaResultado.append(" Precio\t\t: S/. " + global.precio2);
		if (global.precio2 > promedio2) {
			txtaResultado.append(" (Mayor al promedio)\n\n");
		} else {
			txtaResultado.append(" (Menor al promedio)\n\n");
		}
		
		txtaResultado.append(" Modelo\t\t: " + global.modelo3 + "\n");
		txtaResultado.append(" Precio\t\t: S/. " + global.precio3);
		if (global.precio3 > promedio3) {
			txtaResultado.append(" (Mayor al promedio)\n\n");
		} else {
			txtaResultado.append(" (Menor al promedio)\n\n");
		}
	}
	
	void ReportePromediosMenoresMayores() {
		double precioMayor = 0;
		double precioMenor = 0;
		double anchoMayor = 0;
		double anchoMenor = 0;
		
		double[] precios = {global.precio0, global.precio1, global.precio2, global.precio3};
		double[] anchos = {global.ancho0, global.ancho1, global.ancho2, global.ancho3};
		
		precioMayor = precios[0];
		for(int i = 1; i < precios.length; i++) {
			if(precios[i] > precioMayor) {
				precioMayor = precios[i];
			}
		}
		
		precioMenor = precios[0];
		for(int i = 1; i < precios.length; i++) {
			if(precios[i] < precioMenor) {
				precioMenor = precios[i];
			}
		}
		
		anchoMayor = anchos[0];
		for(int i = 1; i < anchos.length; i++) {
			if(anchos[i] > anchoMayor) {
				anchoMayor = anchos[i];
			}
		}
		
		anchoMenor = anchos[0];
		for(int i = 1; i < anchos.length; i++) {
			if(anchos[i] < anchoMenor) {
				anchoMenor = anchos[i];
			}
		}
		
		txtaResultado.setText(" PROMEDIOS, MENORES Y MAYORES\n\n");
		txtaResultado.append(" Precio promedio\t: S/. " + (global.precio0 + global.precio1 + global.precio2 + global.precio3) / 4 + "\n");
		txtaResultado.append(" Precio menor\t\t: S/. " + precioMenor + "\n");
		txtaResultado.append(" Precio mayor\t\t: S/. " + precioMayor + "\n\n");
		txtaResultado.append(" Ancho promedio\t: S/. " + (global.ancho0 + global.ancho1 + global.ancho2 + global.ancho3) / 4 + "\n");
		txtaResultado.append(" Ancho menor\t\t: " + anchoMenor + "\n");
		txtaResultado.append(" Ancho mayor\t\t: " + anchoMayor + "\n\n");
	}
}
