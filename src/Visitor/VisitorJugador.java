package Visitor;

import Entidad.Entidad;
import Entidad.Jugador.Player;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Entidad.Infectado.Infectado;

public class VisitorJugador extends Visitor {

	public VisitorJugador(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Player a) {

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
