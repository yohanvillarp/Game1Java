package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

public class Acciones implements WindowListener,ActionListener{

	
	public void actionPerformed(ActionEvent	e) {
		JButton btn = (JButton) e.getSource();
		ClaseMusic.getInstanceEffects().setMusic("efectoDisparo.wav", true);
		ClaseMusic.getInstanceEffects().run();
		System.out.println(btn.getText());;
		if(btn.getText().equalsIgnoreCase("  Salir")) System.exit(0);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Iniciando musica");
		ClaseMusic.getInstanceMusic().run();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
