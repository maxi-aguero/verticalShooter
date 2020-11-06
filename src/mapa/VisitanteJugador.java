package mapa;

public class VisitanteJugador extends Visitor{

	public VisitanteJugador(Entidad entidad) {
		super(entidad);		
	}

	// No hago nada es un amigo!
	public void visit(Jugador j) {
		
		
	}

	//cargo municiones y disparo
	public void visit(Infectado i) {		
		
	}

	//No me hace daño mis municiones
	public void visit(Arma d) {		
			
	}

	//Las municiones no le afectan al virus, pero si al Infectado
	public void visit(Virus v) {		
		
	}
	
}
