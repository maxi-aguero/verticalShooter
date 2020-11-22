package Entidad.Proyectil;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Proyectil {

	public DisparoJugador(int x,int y) {
		super();
		visitor = new VisitorDisparoJugador(this);	

		direccion = new MovimientoVerticalVirus(this,1);	
		entidadgrafica.setImagen("img/jugador/munic.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
	}
	
	public void setX(int x) {
		entidadgrafica.setX(x);
	}
	
	public void setY(int y) {
		entidadgrafica.setX(y);
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarArmaSanitaria(this);

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
	
	

	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub

		//ataco el infectado, recibo ataque infectado
		//postdata: no esta el jugador, entonces recibo ataque desde jugador
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recibirAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
