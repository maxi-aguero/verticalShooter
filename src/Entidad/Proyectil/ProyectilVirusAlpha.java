package Entidad.Proyectil;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorContagiarVirusAlpha;

public class ProyectilVirusAlpha extends Proyectil {
	public int danio;
	public ProyectilVirusAlpha(int x,int y) {
		super();
		visitor = new VisitorContagiarVirusAlpha(this);	
		velocidad=25;
		direccion = new MovimientoVertical(this,velocidad);	
		entidadGrafica.setImagen("img/infectados/fire.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);
		danio=1;
		
	}
	
	
	
		
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarVirusAlpha(this);

	}
	

	

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		//ataco al jugador
		double cargaActualJugador= obj.getVitalactual();
		cargaActualJugador=cargaActualJugador+danio;
		obj.setVitalactual(cargaActualJugador);		
	}

	

}
