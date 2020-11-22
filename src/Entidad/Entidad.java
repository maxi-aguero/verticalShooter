package Entidad;


import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;
import java.util.List;


public abstract class Entidad {
	
	protected int velocidad;// 
	protected Visitor visitor;		
	protected EstrategiaMovimiento direccion; //movimiento
	protected EntidadGrafica entidadgrafica;
	
	protected Entidad() {
		entidadgrafica=new EntidadGrafica();
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadgrafica;
	}
	
	
	public abstract List<Entidad> detectarColisiones(List<Entidad>infectados);//por hacer-lo hace mapa?

	
	
	
	public int getVelocidad() {
		return velocidad;
	}
	
	
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}
	
	

	public abstract void accept(Visitor v);	
	public abstract void mover(EstrategiaMovimiento d);
	public abstract void atacar(Entidad obj); 
	public abstract void iniciarAtaque(Entidad obj);
	public abstract void recibirAtaque(Entidad obj); 

	public void morir() {
		
	}
	
	
	

		
	public Visitor getVisitor() { return visitor ;}	
	
	public EstrategiaMovimiento getDireccion() { return direccion ;}	


	public abstract boolean estaVivo();


	
}
