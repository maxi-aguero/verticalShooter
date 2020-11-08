package Entidad.Jugador;

import Visitor.VisitorJugador;

public class Player1 extends Player {
		
	public Player1() {
		super(0, 100, 100, 1, 20, 35, 30); 
		visitor = new VisitorJugador(this);				
		ruta_dibujo = "img/jugador/jugador.png";
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
			
		
	}	
	

}
