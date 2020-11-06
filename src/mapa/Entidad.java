package mapa;


public abstract class Entidad {

	protected int x;
	protected int y;
	protected int velocidad;
	protected Visitor visitor;

	

	protected Entidad(int x,int y,int velocidad) {
		this.x=x;
		this.y=y;
		this.velocidad=velocidad;
		
		
	}
	
	public abstract void accept(Visitor v);
	
	
	//se mueve el objeto
	public abstract void mover();
	
	//hace daño
	public abstract void atacar(Entidad entidad); 
	
	//lanza el ataque
	public abstract void lanzarAtaque(Entidad entidad);
	
	
	
	



	
}
