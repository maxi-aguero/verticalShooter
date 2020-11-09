package Visitor;

import Entidad.Entidad;
import Entidad.Jugador.Player;
import Entidad.Disparo.DisparoJugador;
import Entidad.Disparo.EmitirContagio;
import Entidad.Infectado.Infectado;

public abstract class Visitor {
	
	protected Entidad entidad;
	
	
	public Visitor(Entidad entidad) {
		this.entidad = entidad;		
	}

	
	public abstract void visit(Player a);
	
	public abstract void visit(Infectado e);
	
	public abstract void visit(DisparoJugador d);
	
	public abstract void visit(EmitirContagio d);

	
	
}
