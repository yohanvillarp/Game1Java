package controlador;

import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Rexy {
	
	private static final Clip clip = createClip();
	
	public static Clip getClip() {
		return clip;
	}
	
	private static Clip createClip() {
		Clip clipInterno;
		try {
			clipInterno = AudioSystem.getClip();
			return clipInterno;
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean detenerReproduccion() {
		try {
			if(clip.isActive()) {
				clip.stop();
				clip.close();
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	//Permite reproducir musica wav
	public static boolean reproductor(String cancion) {
		String ruta="musica\\"+cancion;
		
		
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
			
			System.out.println(ruta);
			
			if(!clip.isRunning()) {
				System.out.println("Abriendo");
				clip.open(audioInputStream);
			}else {
				//detención de clip
				clip.stop();
				//liberación de recursos
				clip.close();
				clip.open(audioInputStream);
			}
			clip.start();
			clip.flush();
			
			return true;
			
		}catch (Exception es) {
			return false;
		}
	}
	
	public static JFrame getVentanaComandos(ArrayList<ArrayList> lista) {
		JFrame frm = new JFrame("Panel de comandos");
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pnl = new JPanel(new GridLayout(3,1));
		JLabel comando;
		ArrayList<String> listaAct;
		JComboBox<String> acciones;
		
		for(int i=0; i<lista.size();i++) {
			listaAct = lista.get(i);

			comando = new JLabel(listaAct.get(0),JLabel.CENTER);
			
			pnl.add(comando);
			acciones = new JComboBox<String>();
			
			for(int j=1; j<listaAct.size();j++) {
				acciones.addItem(listaAct.get(j));
			}
			
			pnl.add(acciones);
		}
		
		frm.add(pnl);
		
		return frm;
	}
}
