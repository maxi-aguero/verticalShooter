package Entidad.Proyectil;

import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Visitor.Visitor;

public class ProyectilVirus extends Proyectil {

	public ProyectilVirus(int x,int y) {
		super();

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
	

}
