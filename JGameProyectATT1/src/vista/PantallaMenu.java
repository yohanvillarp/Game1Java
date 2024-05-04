package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controlador.Acciones;

public class PantallaMenu extends JPanel{
	public static final PantallaMenu instance = new PantallaMenu();
	
	public static PantallaMenu getInstance() {
		return instance;
	}
	
	private Font fuente = new Font("Comic Sans MS",Font.BOLD,30);
	private JButton btnIniciar, btnConfiguraciones, btnSalir;
	private JPanel pnlCentral;
	private JLabel lblTitulo;
	private static final String titulo = "SIMPLE GAME";
	
	private PantallaMenu() {
		config();
		cargarAtributos();
	}
	private void config() {
		setLayout(null);
	}
	private void cargarAtributos() {
		btnIniciar = crearBoton("Iniciar","iniciar.png");
		btnConfiguraciones = crearBoton("Configuraciones","configuraciones.png");
		btnSalir = crearBoton("Salir","salir.png");
		cargarPanel();
	}
	
	private void cargarPanel() {
		int ancho = 450, alto= 450;
		pnlCentral = new JPanel();
		pnlCentral.setBackground(new Color(0, 0, 0, 70));
		pnlCentral.setBorder(new EtchedBorder(Color.WHITE, Color.RED));
		
		//titulo
		lblTitulo = new JLabel(titulo, JLabel.CENTER);
		lblTitulo.setFont(new Font("Jokerman",Font.BOLD,40));
		lblTitulo.setBounds(100,100, 100, 30);
		lblTitulo.setBackground(new Color(0, 0, 0, 250));
		lblTitulo.setForeground(Color.WHITE);
		
		//centrar marco
		pnlCentral.setBounds((Ventana.ancho/2)-ancho/2,(Ventana.alto/2)-alto/2 , ancho, alto);
		
		//cajas
		Box caja = Box.createVerticalBox();
		Box cajaH = Box.createHorizontalBox();
		Box cajaH2 = Box.createHorizontalBox();
		Box cajaH3 = Box.createHorizontalBox();
		Box cajaH4 = Box.createHorizontalBox();
		
		caja.add(Box.createVerticalStrut(10));
		cajaH4.add(lblTitulo);
		caja.add(cajaH4);
		
		caja.add(Box.createVerticalStrut(50));
		
		cajaH.add(btnIniciar);
		caja.add(cajaH);
		
		caja.add(Box.createVerticalStrut(30));
		
		cajaH2.add(btnConfiguraciones);
		caja.add(cajaH2);
		
		caja.add(Box.createVerticalStrut(30));
		
		cajaH3.add(btnSalir);
		caja.add(cajaH3);
		
		pnlCentral.add(caja);
		add(pnlCentral);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images"+File.separator+"fondo.png"), 0, 0, null);
		revalidate();
		repaint();
	}
	
	
	private JButton crearBoton(String nombre, String nombreIcono) {
		JButton btn = new JButton("  "+nombre, new ImageIcon("Images"+File.separator+nombreIcono));
		btn.setFont(fuente);
		btn.setBorder(null);
		btn.setForeground(Color.YELLOW);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.addActionListener(new Acciones());
		return btn;
	}
}
