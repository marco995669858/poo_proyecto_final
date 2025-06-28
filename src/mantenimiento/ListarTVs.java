package mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entidad.global;

public class ListarTVs extends JInternalFrame implements ActionListener {
	
	JTextArea txtaListado;
	JButton btnCerrar;
	JButton btnListar;

	static ListarTVs listarTelevisor;
	
	public static ListarTVs getInstance() {
		if (listarTelevisor == null) {
			listarTelevisor = new ListarTVs();
		}
		
		return listarTelevisor;
	}

	/**
	 * Create the frame.
	 */
	public ListarTVs() {
		setTitle("Listado de televisores");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		txtaListado = new JTextArea();
		txtaListado.setEditable(false);
		
		JScrollPane scroll = new JScrollPane (txtaListado);
		scroll.setEnabled(false);
		scroll.setBounds(10, 10, 424, 216);
		getContentPane().add(scroll);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(129, 236, 89, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(250, 236, 89, 23);
		btnListar.addActionListener(this);
		getContentPane().add(btnListar);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnCerrar) {
			ListarTVs.this.setVisible(false);
		} else if (e.getSource() == btnListar) {
			ListarTelevisores();
		}
	}
	
	void ListarTelevisores() {
		txtaListado.setText(" LISTADO DE TELEVISORES\n\n");
		txtaListado.append(" Modelo\t\t: " + global.modelo0 + "\n");
		txtaListado.append(" Precio\t\t: S/. " + global.precio0 + "\n");
		txtaListado.append(" Ancho\t\t: " + global.ancho0 + "\n");
		txtaListado.append(" Alto\t\t: " + global.alto0 + "\n");
		txtaListado.append(" Pulgadas\t\t: " + global.pulgada0 + "\n\n");
		
		txtaListado.append(" Modelo\t\t: " + global.modelo1 + "\n");
		txtaListado.append(" Precio\t\t: S/. " + global.precio1 + "\n");
		txtaListado.append(" Ancho\t\t: " + global.ancho1 + "\n");
		txtaListado.append(" Alto\t\t: " + global.alto1 + "\n");
		txtaListado.append(" Pulgadas\t\t: " + global.pulgada1 + "\n\n");
		
		txtaListado.append(" Modelo\t\t: " + global.modelo2 + "\n");
		txtaListado.append(" Precio\t\t: S/. " + global.precio2 + "\n");
		txtaListado.append(" Ancho\t\t: " + global.ancho2 + "\n");
		txtaListado.append(" Alto\t\t: " + global.alto2 + "\n");
		txtaListado.append(" Pulgadas\t\t: " + global.pulgada2 + "\n\n");
		
		txtaListado.append(" Modelo\t\t: " + global.modelo3 + "\n");
		txtaListado.append(" Precio\t\t: S/. " + global.precio3 + "\n");
		txtaListado.append(" Ancho\t\t: " + global.ancho3 + "\n");
		txtaListado.append(" Alto\t\t: " + global.alto3 + "\n");
		txtaListado.append(" Pulgadas\t\t: " + global.pulgada3 + "\n");
	}
}
