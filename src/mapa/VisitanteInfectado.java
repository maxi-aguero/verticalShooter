package mapa;

public class VisitanteInfectado extends Visitor{

	public VisitanteInfectado(Entidad entidad) {
		super(entidad);		
	}

	// Le propago virus
	public void visit(Jugador j) {
		
		
	}

	//no hacer nada
	public void visit(Infectado i) {		
		
	}

	//recibir cura
	public void visit(Disparo d) {		
			
	}

	//no hacer nada
	public void visit(Virus v) {		
		
	}
	
}
