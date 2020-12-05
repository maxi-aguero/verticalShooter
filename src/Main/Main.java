 package Main;

import Juego.AudioPlayer;

public class Main {
	  private static WindowInicio ventana_inicio;
	  private static WindowDialogos ventana_dialogos;
	 
	  public static void main(String args []){
		 
		  ventana_inicio = new WindowInicio();
		  ventana_inicio.setVisible(true);
		  ventana_inicio.crarAudio();
		  ventana_inicio.setDuracion(4000);
		  //ventana_inicio
		  
	      CargarJuego miCargarJuego=null;
	      ventana_dialogos=null;
	      int i=0    ;
	      AudioPlayer audio_aux =ventana_inicio.getAudio();
	  	 Thread hilo_aux = ventana_inicio.getHiloAudio();

	      while(miCargarJuego==null) {
	    	  	if (i==1334415) {
	    	  		audio_aux= new AudioPlayer("src/img/juego/introsam.mp3");
	    	  		hilo_aux= new Thread(audio_aux);
	    	  		hilo_aux.start();
	    	  		ventana_inicio.setDuracion(4000);
	    	  		i=0;
	    	  	}
	    	  	
	    	  
	    	  	 ventana_dialogos = ventana_inicio.getDialogos();
	        	 if(ventana_dialogos!=null)
	        	 {
	        		 miCargarJuego=ventana_dialogos.getCargarJuego();
	        		 
	        	 }
	        	 if(miCargarJuego!=null)
	        	 {
	       		  	ventana_inicio.setDuracion(0);

	       		  	audio_aux = null;
	       		  	hilo_aux.stop();
	       		
	       		  	
	        		Loading load = miCargarJuego.getLoading();
	        		load.mostrarLoading();
	        		 
	        		miCargarJuego.crearJuego(ventana_dialogos.getConfigJugador()); 

		         }
	        	 i++;
	         }

	         


	    } 
	  
	 
}
