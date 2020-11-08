package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Player;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import Entidad.Infectado.Infectado;
//import GameObjects.ObjetosMapa.ObjetoMapaTemporal;
//import GameObjects.ObjetosMapa.ObjetoMapaVida;
//import GameObjects.Premios.Premio;

/*
 * Clase usada por enemigos
 */
public class VisitorInfectado extends Visitor {

	public VisitorInfectado(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Player a) {
		//obj.atacar(a);

		
	}

	@Override
	public void visit(Infectado e) {
		//obj.mover();

	}

	@Override
	public void visit(DisparoAliado d) {
		//obj.mover();

	}

	@Override
	public void visit(DisparoEnemigo d) {
		//obj.mover();

	}
	
}
