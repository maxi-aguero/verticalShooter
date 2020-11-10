package Entidad.Jugador;

import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoHorizontal;
import Visitor.VisitorJugador;

public class Player1 extends Player {
		
	public Player1() {
		super(0, 100, 5, 1, 20, 35, 30); 
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		ruta_dibujo = "img/jugador/jugador.png";
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
			
		
	}

	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}	

	

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
		
	}

	

}
