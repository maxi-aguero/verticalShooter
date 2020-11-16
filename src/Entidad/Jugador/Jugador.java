package Entidad.Jugador;

import Entidad.Entidad;
import Entidad.Personaje;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoHorizontal;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
		
	public Jugador() {
		
		super(0, 100, 5); 		
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		ruta_dibujo = "img/jugador/jugador.png";
		coorInicialx=50;
		coorInicialy=420;
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visit(this);

	}

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
	}

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
	}

	

	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}	

	


	

}