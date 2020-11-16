package Entidad;

import javax.swing.JLabel;

import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;

public abstract class Entidad {
	
	protected int velocidad;// 
	protected JLabel dibujo;// label de gui
	protected Visitor visitor;		
	protected String ruta_dibujo;	
	protected int coorInicialx;//coordenadas iniciales
	protected int coorInicialy;
	protected EstrategiaMovimiento direccion; //movimiento


	
	protected Entidad() {
	}
	
	public void setX(int x) {
		this.coorInicialx=x;
	}
	
	public void setY(int y) {
		this.coorInicialy=y;
	}
	
	public int getX() {
		return coorInicialx;
	}
	
	public int getY() {
		return coorInicialy;
	}
	
	public String getImagen() {
		return ruta_dibujo;
	}
	
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

	public void morir() {
		
	}
	
	
	public JLabel getDibujo() { return dibujo ;}
	public void setDibujo(JLabel dibujo) { this.dibujo = dibujo ;}

		
	public Visitor getVisitor() { return visitor ;}	
	
	public EstrategiaMovimiento getDireccion() { return direccion ;}	


	public abstract boolean estaVivo();


	
}
