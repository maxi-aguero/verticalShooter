    package Main;


public class Main {
	  private static WindowInicio ventana_inicio;
	 
	  public static void main(String args []){
		 
		  ventana_inicio = new WindowInicio();
		  ventana_inicio.setVisible(true);		  
	      CargarJuego miCargarJuego=null;

	      while(miCargarJuego==null) {
	    	  
	        	 if(ventana_inicio.getWindowDialogos()!=null)
	        	 {
	        		 miCargarJuego=ventana_inicio.getWindowDialogos().getCargarJuego();
	        		 
	        	 }
	        	 
	        	 if(miCargarJuego!=null)
	        	 { 		       		  	
	        		Loading load = miCargarJuego.getLoading();
	        		load.mostrarLoading();	        		 
	        		miCargarJuego.crearJuego(ventana_inicio.getWindowDialogos().getConfigJugador()); 

		         }
	        	 
	         }

	         


	    } 
	  
	 
}
