package mapa;

public class VisitantePropagacionVirus extends Visitor{

	public VisitantePropagacionVirus(Entidad entidad) {
		super(entidad);		
	}

	// le hago daño
	public void visit(Jugador j) {
		
		
	}

	//no hacer nada
	public void visit(Infectado i) {		
		
	}

	//no hacer nada
	public void visit(Arma d) {		
			
	}

	//no hacer nada
	public void visit(Virus v) {		
		
	}
	
}
