package principal;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import configuracion.ConfigurarCantidadOptima;
import configuracion.ConfigurarCuotaDiaria;
import configuracion.ConfigurarDescuento;
import configuracion.ConfigurarObsequio;
import mantenimiento.ConsultarTelevisor;
import mantenimiento.ListarTVs;
import mantenimiento.ModificarTV;
import ventas.GenerarReportes;
import ventas.Vender;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Cursor;
import java.awt.Dimension;

public class Principal extends JFrame implements ActionListener {

	static Principal frame;
	private JPanel contentPane;
	JMenuItem mntmSalir;
	JMenuItem mntmConsultarTv;
	JDesktopPane desktopPane;
	JMenuItem mntmListarTv;
	JMenuItem mntmModificarTv;
	JMenuItem mntmVender;
	JMenuItem mntmGenerarReportes;
	ConsultarTelevisor consultarTV;
	ModificarTV modificarTV;
	JMenuItem mntmConfigurarDescuentos;
	JMenuItem mntmConfigurarObsequios;
	JMenuItem mntmConfigurarCantidadOptima;
	JMenuItem mntmConfigurarCuotaDiaria;
	JMenuItem mntmAcercaDeTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(frame, "¿Seguro que desea cerrar el programa?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Ventas de Televisores");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//setUndecorated(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarTv = new JMenuItem("Consultar TV");
		mntmConsultarTv.addActionListener(this);
		mnMantenimiento.add(mntmConsultarTv);
		
		mntmModificarTv = new JMenuItem("Modificar TV");
		mntmModificarTv.addActionListener(this);
		mnMantenimiento.add(mntmModificarTv);
		
		mntmListarTv = new JMenuItem("Listar TVs");
		mntmListarTv.addActionListener(this);
		mnMantenimiento.add(mntmListarTv);
		
		JMenu mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		JMenu mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad optima");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de tienda");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == mntmSalir) {
			Salir();
		} else if (e.getSource() == mntmConsultarTv) {
			Mostrar(ConsultarTelevisor.getInstance(), desktopPane);
		} else if (e.getSource() ==  mntmModificarTv) {
			Mostrar(ModificarTV.getInstance(), desktopPane);
		} else if(e.getSource() == mntmListarTv){
			Mostrar(ListarTVs.getInstance(), desktopPane);
		} else if(e.getSource() == mntmVender){
			Mostrar(Vender.getInstance(), desktopPane);
		} else if(e.getSource() == mntmGenerarReportes){
			Mostrar(GenerarReportes.getInstance(), desktopPane);
		} else if (e.getSource() == mntmConfigurarDescuentos) {
			Mostrar(ConfigurarDescuento.getInstance(), desktopPane);
		} else if (e.getSource() == mntmConfigurarObsequios) {
			Mostrar(ConfigurarObsequio.getInstance(), desktopPane);
		} else if (e.getSource() == mntmConfigurarCantidadOptima) {
			Mostrar(ConfigurarCantidadOptima.getInstance(), desktopPane);
		} else if (e.getSource() == mntmConfigurarCuotaDiaria) {
			Mostrar(ConfigurarCuotaDiaria.getInstance(), desktopPane);
		} else if (e.getSource() == mntmAcercaDeTienda) {
			Mostrar(AcercaDeTienda.getInstance(), desktopPane);
		}
	}
	
	void Mostrar(JInternalFrame jif, JDesktopPane dp) {
		if (jif.isVisible()) {
			jif.toFront();
			jif.requestFocus();
		} else {
			dp.remove(jif);
			dp.add(jif);
			jif.setVisible(true);
		}
		
		Dimension desktopSize = dp.getSize();
		Dimension frameSize = jif.getSize();
		jif.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height- frameSize.height)/2);
	}
	
	void Salir() {
		int respuesta = JOptionPane.showConfirmDialog(frame, "¿Seguro que desea cerrar el programa?", "Confirmación",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
