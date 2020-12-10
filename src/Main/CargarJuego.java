package Main;

import Juego.Juego;

public class CargarJuego {
	private  Loading loading;
	private Juego nuevojuego;

    public CargarJuego() {    	
    	   loading= new Loading(14000);
    	   
    }
    
    public Loading getLoading() {
    	return loading;
    }   
   
    
    public void crearJuego(int tipoJugador) {
    	
    	 nuevojuego= new Juego(tipoJugador);  
	
    	 
    }
    
    
    
    

    	
      
    
}

