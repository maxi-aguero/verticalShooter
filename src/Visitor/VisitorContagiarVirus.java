package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Player;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
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
	public void visit(DisparoAliado d) {

	}

	@Override
	public void visit(DisparoEnemigo d) {

	}
	
}
