package vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controlador.Acciones;

public class Ventana extends JFrame{
	private static final Ventana instance = new Ventana();
	public static final int ancho=800, alto=800;
	
	public static Ventana getInstance() {
		return instance;
	}
	
	private Ventana() {
		config();
	}
	private void config() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("ancho: "+dimension.width);
		System.out.println("alto: "+dimension.height);
		setBounds((dimension.width/2)-ancho/2, (dimension.height/2)-alto/2, ancho,alto);
		setTitle("Game xD");
		addWindowListener(new Acciones());
		setResizable(false);
		add(PantallaMenu.getInstance());
	}
	
}
