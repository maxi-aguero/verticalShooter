package Entidad.Infectado;

import Entidad.Entidad;

import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.VisitorInfectado;

public class InfectadoAlpha extends Infectado {
		
	public InfectadoAlpha() {
		super(100, 0, 5, 3, 20, 35, 30); 
		visitor = new VisitorInfectado(this);	
		direccion = new MovimientoVertical(this,1);		
		ruta_dibujo = "img/infectados/alpha.png";

		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;	
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();

		
	}

	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}

	

}
