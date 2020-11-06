package mapa;


public abstract class Entidad {

	protected int x;
	protected int y;
	protected int velocidad;
	protected Visitor visitor;
	protected Movimiento movimiento;
	protected String img;
	

	protected Entidad(int x,int y,int velocidad,String img) {
		this.x=x;
		this.y=y;
		this.velocidad=velocidad;
		this.img=img;
		
	}
	
	public abstract void accept(Visitor v);
	
	
	
	
	//hace daño
	public abstract void atacar(Entidad entidad); 
	
	//lanza el ataque
	public abstract void lanzarAtaque(Entidad entidad);
	
	
	
	
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getImagen() {
		return img;
	}
}
