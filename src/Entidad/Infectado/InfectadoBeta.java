package Entidad.Infectado;

import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.VisitorInfectado;

public class InfectadoBeta extends Infectado {
		
	public InfectadoBeta() {
		super(40, 5, 5, 3, 20, 35, 30); 
		visitor = new VisitorInfectado(this);	
		direccion = new MovimientoVertical(this,1);
		ruta_dibujo = "img/infectados/beta.png";
		
	}
	
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;	
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
