package Visitor;

import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Entidad.Infectado.Infectado;

public class VisitorJugador extends Visitor {

	public VisitorJugador(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Jugador a) {

	}

	@Override
	public void visit(Infectado e) {
		//obj.atacar(e);
	}

	@Override
	public void visit(DisparoJugador d) {

	}

	@Override
	public void visit(ProyectilVirus d) {

	}

	
}
