package Entidad.Infectado;


import Entidad.Entidad;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.VisitorInfectado;

public class InfectadoAlpha extends Infectado {
		
	public InfectadoAlpha() {
		super(100, 0, 5); 
		visitor = new VisitorInfectado(this);	
		direccion = new MovimientoVertical(this,1);		
		entidadgrafica.setImagen("img/infectados/alpha.gif");

		
	}



	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;
	}



	@Override
	public void recibirAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	




	

}
