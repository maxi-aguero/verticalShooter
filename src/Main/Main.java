  package Main;


public class Main {
	  private static WindowInicio ventana_inicio;
	  private static WindowDialogos ventana_dialogos;
	 
	  public static void main(String args []){
		 
		  ventana_inicio = new WindowInicio();
		  ventana_inicio.setVisible(true);
	      CargarJuego miCargarJuego=null;
	      ventana_dialogos=null;
	      int i=0;
	      while(miCargarJuego==null) {

	    	  	 ventana_dialogos = ventana_inicio.getDialogos();
	        	 if(ventana_dialogos!=null)
	        	 {
	        		 miCargarJuego=ventana_dialogos.getCargarJuego();
	        	 }
	        	 if(miCargarJuego!=null)
	        	 {
	        		 Loading load = miCargarJuego.getLoading();
	        		 load.mostrarLoading();
	        		 
	        		 miCargarJuego.crearJuego(ventana_dialogos.getConfigJugador());

		         }
	        	 i++;
	        	 System.out.println(i);
	         }

	         


	    }  
}
