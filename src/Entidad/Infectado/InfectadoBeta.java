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
		ruta_dibujo = "img/infectados/beta.gif";

		
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
		return cargaViralActual>0?true:false;
	}

	



	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}

	

}
