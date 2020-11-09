package Entidad;

import javax.swing.JLabel;

import Juego.Mapa;
import Visitor.Visitor;

public abstract class Entidad {
	
	protected int cargaViralActual; //jugador pierde con 100 - comienza con 0									
	protected int cargaViralPierde; //infectado pierde con 0- comienza con 100
	protected int velocidad; // de movimiento 
	protected int rango; //rango de tiro	
	protected Mapa mapa;	//necesito
	protected JLabel dibujo;// label de gui
	protected Visitor visitor;	
	protected String ruta_dibujo;
	private int x;//coordenadas iniciales
	private int y;

	
	protected Entidad(int cargaViralActual, int cargaViralPierde, int rango, int velocidad) {
		this.cargaViralActual = cargaViralActual; //ok
		this.cargaViralPierde=cargaViralPierde;
		this.rango = rango;
		this.velocidad = velocidad;	
		
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getImagen() {
		return ruta_dibujo;
	}
	

	public abstract void accept(Visitor v);	
	public abstract boolean interactuar();
	public abstract void mover();
	public abstract void atacar(Entidad obj); 
	public abstract void iniciarAtaque(Entidad obj);

	public void morir() {
		
	}
	
	
	public int getRango() {	return rango ;}
	public void setRango(int rango) { this.rango = rango ;}
	
	public int getVitalactual() { return cargaViralActual ;}
	public void setVitalactual(int cvital) { this.cargaViralActual = cvital ;}
	

	public JLabel getDibujo() { return dibujo ;}
	public void setDibujo(JLabel dibujo) { this.dibujo = dibujo ;}

	
	public void setMapa(Mapa mapa) { this.mapa = mapa ;}
	public Mapa getMapa() { return mapa ;}
	

	public int getVelocidad_movimiento() { return velocidad ;}
	
	public Visitor getVisitor() { return visitor ;}	


	public abstract boolean estaVivo();


	
}
