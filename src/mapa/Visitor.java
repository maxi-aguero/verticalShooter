package mapa;


public abstract class Visitor {
	
	protected Entidad entidad;
	
	
	public Visitor(Entidad entidad) {
		this.entidad = entidad;		
	}	

	public abstract void visit(Jugador j);
	public abstract void visit(Infectado i);
	public abstract void visit(Arma d);
	public abstract void visit(Virus v);
	
	
	
	
}
