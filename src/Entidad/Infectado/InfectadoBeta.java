package Entidad.Infectado;

import java.util.List;

import Entidad.Entidad;

import EstrategiaMovimiento.MovimientoVerticalDeInfectado;
import Visitor.Visitor;
import Visitor.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {
		
	public InfectadoBeta() {
		super(100, 0, 5); 
		visitor = new VisitorInfectadoBeta(this);	
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
		cargaViralActual=cargaViralActual - 50;		
		System.out.println("mi carga:" +cargaViralActual);
	}


	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoBeta(this);
	}


	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
