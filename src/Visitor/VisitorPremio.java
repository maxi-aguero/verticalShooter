package Visitor;

import Entidad.Entidad;
import Entidad.Jugador.Player;
import GameObjects.Disparos.DisparoAliado;
import GameObjects.Disparos.DisparoEnemigo;
import Entidad.Infectado.Infectado;

public class VisitorPremio extends Visitor {

	public VisitorPremio(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Player a) {
		

	}

	@Override
	public void visit(Infectado e) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void visit(DisparoAliado d) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void visit(DisparoEnemigo d) {

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