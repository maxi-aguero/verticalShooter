package Entidad.Infectado;


import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.MovimientoVerticalDeInfectado;
import Visitor.Visitor;
import Visitor.VisitorInfectadoAlpha;

public class InfectadoAlpha extends Infectado {
		
	public InfectadoAlpha() {
		super(100, 0, 5); 
		visitor = new VisitorInfectadoAlpha(this);	
		direccion = new MovimientoVerticalDeInfectado(this,1);		
		entidadgrafica.setImagen("img/infectados/zombie.gif");

	}



	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;
	}



	@Override
	public void recibirAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		cargaViralActual=cargaViralActual - 20;		
		System.out.println("mi carga:" +cargaViralActual);
		//mostrat en un JProgressBar
		

	}



	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoAlpha(this);
	}



	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}

	




	

}
