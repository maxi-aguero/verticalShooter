package Entidad.Proyectil;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorContagiarVirusBeta;

public class ProyectilVirusBeta extends Proyectil {
	public int danio;

	public ProyectilVirusBeta(int x,int y) {
		super();
		visitor = new VisitorContagiarVirusBeta(this);	
		velocidad=25;
		direccion = new MovimientoVertical(this,velocidad);	
		entidadGrafica.setImagen("img/infectados/fire.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);
		danio=2;
	}
	

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarVirusBeta(this);

	}
	

	


	

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		double cargaActualJugador= obj.getVitalactual();
		cargaActualJugador=cargaActualJugador+danio;
		obj.setVitalactual(cargaActualJugador);	
	}



	


	
	

}
