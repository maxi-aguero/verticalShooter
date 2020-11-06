package mapa;

public class VisitanteDisparo extends Visitor{

	public VisitanteDisparo(Entidad entidad) {
		super(entidad);		
	}

	// no le hago daño
	public void visit(Jugador j) {
		
		
	}

	//cura al infectado
	public void visit(Infectado i) {		
		
	}

	//no hacer nada
	public void visit(Disparo d) {		
			
	}

	//no hacer nada
	public void visit(Virus v) {		
		
	}
	
}
