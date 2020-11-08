package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Player;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import Entidad.Infectado.Infectado;

public class VisitorDisparoJugador extends Visitor {

	
	public VisitorDisparoJugador(Entidad entidad) {
		super(entidad);
	}

	@Override
	public void visit(Player a) {
		// No debe hacer nada
//		System.out.println("VisitorDisparoAliado.visit(Aliado)");

	}

	@Override
	public void visit(Infectado e) {
		//obj.atacar(e);

//		System.out.println("VisitorDisparoAliado.visit(Enemigo)");
	}

	@Override
	public void visit(DisparoAliado d) {
		// No debe hacer nada
//		System.out.println("VisitorDisparoAliado.visit(DisparoAliado)");

	}

	@Override
	public void visit(DisparoEnemigo d) {
		// No debe hacer nada
//		System.out.println("VisitorDisparoAliado.visit(DisparoEnemigo)");

	}
	/**
	@Override
	public void visit(Premio p) {
		// TODO Auto-generated method stub
		System.out.println("pium");

	}

	@Override
	public void visit(ObjetoMapaTemporal OM) {
		// TODO Auto-generated method stub
		System.out.println("pium");

	}

	@Override
	public void visit(ObjetoMapaVida OM) {
		// TODO Auto-generated method stub
		System.out.println("pium");

		
	}*/
}
