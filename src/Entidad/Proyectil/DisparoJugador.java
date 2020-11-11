package Entidad.Proyectil;


import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Proyectil {

	public DisparoJugador() {
		visitor = new VisitorDisparoJugador(this);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		
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



	



}
