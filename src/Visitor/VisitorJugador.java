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
 * Clase usada por aliados
 */
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
	public void visit(DisparoAliado d) {

	}

	@Override
	public void visit(DisparoEnemigo d) {

	}

	
}
