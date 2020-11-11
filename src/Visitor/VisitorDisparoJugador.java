package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Player;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Entidad.Infectado.Infectado;

public class VisitorDisparoJugador extends Visitor {

	
	public VisitorDisparoJugador(Entidad entidad) {
		super(entidad);
	}

	@Override
	public void visit(Player a) {
		// No debe hacer nada

	}

	@Override
	public void visit(Infectado e) {
		//obj.atacar(e);

	}

	@Override
	public void visit(DisparoJugador d) {
		// No debe hacer nada

	}

	@Override
	public void visit(ProyectilVirus d) {
		// No debe hacer nada

	}

}
