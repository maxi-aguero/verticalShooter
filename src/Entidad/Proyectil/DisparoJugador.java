package Entidad.Proyectil;


import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalBalas;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Proyectil {

	public DisparoJugador(int x,int y) {
		super();
		visitor = new VisitorDisparoJugador(this);
		direccion = new MovimientoVerticalBalas(this,1);	//setear movimiento arriba
		entidadgrafica.setImagen("img/jugador/munic.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		this.getDireccion().setDireccion(MovimientoVerticalBalas.ARRIBA);
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
		return false;
	}

	@Override
	public void recibirAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}



	



}
