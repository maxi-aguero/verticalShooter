package Entidad.Proyectil;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Visitor.Visitor;
import Visitor.VisitorContagiarVirus;

public class ProyectilVirus extends Proyectil {

	public ProyectilVirus(int x,int y) {
		super();
		visitor = new VisitorContagiarVirus(this);	

		direccion = new MovimientoVerticalVirus(this,1);	
		entidadgrafica.setImagen("img/infectados/fire.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
	}
	
	public void setX(int x) {
		entidadgrafica.setX(x);
	}
	
	public void setY(int y) {
		entidadgrafica.setX(y);
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



	
	
	
	
	//no estan en disparo-enemigo

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
		//ataco el jugador
		//postdata: no esta el jugador, entonces recibo ataque desde jugador
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}	
	

}
