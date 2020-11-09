package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Player;
import Entidad.Disparo.DisparoJugador;
import Entidad.Disparo.EmitirContagio;
import Entidad.Infectado.Infectado;

public class VisitorContagiarVirus extends Visitor {

	public VisitorContagiarVirus(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Player a) {
		//obj.atacar(a);	
	}

	@Override
	public void visit(Infectado e) {

	}

	@Override
	public void visit(DisparoJugador d) {

	}

	@Override
	public void visit(EmitirContagio d) {

	}
	
}
