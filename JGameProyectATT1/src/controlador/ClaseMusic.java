package controlador;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;


public class ClaseMusic{
	
	private final static ClaseMusic instanceMusic = new ClaseMusic();
	private final static ClaseMusic instanceEffects = new ClaseMusic(true);
	
	private String nombreCancion;
	private boolean efecto;
	private static final Clip clipMusic = createClip();
	private static final Clip clipEfectos = createClip();
	
	public static ClaseMusic getInstanceMusic() {
		return instanceMusic;
	}
	public static ClaseMusic getInstanceEffects() {
		return instanceEffects;
	}
	
	public void setMusic(String nombreCancion, boolean efecto) {
		this.nombreCancion = nombreCancion;
		this.efecto = efecto;
	}


	private ClaseMusic() {
		nombreCancion = "PixelPig.wav";
		efecto = false;
	}
	private ClaseMusic(boolean efecto) {
		efecto = true;
	}
	
	
	
	public void run() {
		reproductor(nombreCancion, efecto);
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
	
	private AudioInputStream audioInputStream;
	public boolean reproductor(String cancion, boolean efecto) {
		String ruta="music"+File.separator;
		if(efecto) 	ruta="effects"+File.separator;
		ruta+=cancion;
		
		if(efecto) {
			try {
				
				audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
				
				if(!clipEfectos.isRunning()) {
					clipEfectos.open(audioInputStream);
					
				}else {
					//detención de clip
					clipEfectos.stop();
					//liberación de recursos
					clipEfectos.close();
					clipEfectos.open(audioInputStream);
				}
				clipEfectos.start();
				clipEfectos.flush();
				
				
				return true;
				
			}catch (Exception es) {
				System.out.println("problema en la ruta o audio dañado");
				return false;
			}
		}else {
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ruta));
				
				if(!clipMusic.isRunning())	clipMusic.open(audioInputStream);
				else {
					//detención de clip
					clipMusic.stop();
					//liberación de recursos
					clipMusic.close();
					clipMusic.open(audioInputStream);
				}
				clipMusic.start();
				clipMusic.flush();
				
				return true;
				
			}catch (Exception es) {
				return false;
			}
		}

	}
	
	
}
