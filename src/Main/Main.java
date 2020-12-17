    package Main;


public class Main {
	  private static WindowInicio ventana_inicio;
	 
	  public static void main(String args []){
		 
		  ventana_inicio = new WindowInicio();
		  ventana_inicio.setVisible(true);		  
	      CargarJuego miCargarJuego=null;

	      while(miCargarJuego==null) {
 			 System.out.println("");//extraña razon x la cual solo necesita ese system.out

	        	 if(ventana_inicio.getWindowDialogo()!=null)
	        	 {

	        		 miCargarJuego=ventana_inicio.getWindowDialogo().getCargarJuego();
	        	 }
	        	 
	        	 if(miCargarJuego!=null)
	        	 { 		       	

	        		Loading load = miCargarJuego.getLoading();

	        		load.mostrarLoading();	        		 
	        		miCargarJuego.crearJuego(ventana_inicio.getWindowDialogo().getConfigJugador()); 

		         }
	        	 
	         }

	         


	    } 
	  
	 
}
