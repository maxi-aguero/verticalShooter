package Entidad.Proyectil;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Visitor.Visitor;
import Visitor.VisitorContagiarVirusAlpha;

public class ProyectilVirusAlpha extends Proyectil {
	public int danio;
	public ProyectilVirusAlpha(int x,int y) {
		super();
		visitor = new VisitorContagiarVirusAlpha(this);	
		velocidad=25;
		direccion = new MovimientoVerticalVirus(this,velocidad);	
		entidadgrafica.setImagen("img/infectados/fire.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		danio=1;
		
	}
	
	
	
		
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarVirusAlpha(this);

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
	
	



	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		iniciarAtaque(obj);
		//ataco el jugador
		//postdata: no esta el jugador, entonces recibo ataque desde jugador
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		//ataco al jugador
		double cargaActualJugador= obj.getVitalactual();
		cargaActualJugador=cargaActualJugador+danio;
		obj.setVitalactual(cargaActualJugador);		
	
	}


	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accionar(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		
	}	
	

}
