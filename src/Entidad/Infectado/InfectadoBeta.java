package Entidad.Infectado;

import Entidad.Entidad;

import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorInfectado;

public class InfectadoBeta extends Infectado {
		
	public InfectadoBeta() {
		super(100, 0, 5); 
		visitor = new VisitorInfectado(this);	
		direccion = new MovimientoVertical(this,1);		
		entidadgrafica.setImagen("img/infectados/beta.gif");

		
	}




	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;
	}

	
	

}
