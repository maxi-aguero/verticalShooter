package Main;
 

public class Main {
	  private static WindowInicio inicio;
	 
	  public static void main(String args []){
		 
		  inicio = new WindowInicio();
		  inicio.setVisible(true);		  
	      CargarJuego miCargarJuego=null;

	      while(miCargarJuego==null) {
 			 System.out.println("");

	        	 if(inicio.getWindowDialogo()!=null)
	        	 {

	        		 miCargarJuego=inicio.getWindowDialogo().getCargarJuego();
	        	 }
	        	 
	        	 if(miCargarJuego!=null)
	        	 { 		       	

	        		Loading load = miCargarJuego.getLoading();

	        		load.mostrarLoading();	        		 
	        		miCargarJuego.crearJuego(inicio.getWindowDialogo().getConfigJugador()); 

		         }
	        	 
	         }

	         


	    } 
	  
	 
}
