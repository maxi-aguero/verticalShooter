package Entidad;


import EstrategiaMovimiento.EstrategiaMovimiento;
import Mapa.MapaProyectil;
import Visitor.Visitor;
import java.util.List;


public abstract class Entidad {
	protected double resistencia;
	protected double cargaViralActual; //jugador pierde con 100 - comienza con 0									
	protected int cargaViralPierde; //infectado pierde con 0- comienza con 100
	protected int velocidad;// 
	protected Visitor visitor;		
	protected EstrategiaMovimiento direccion; //movimiento
	protected EntidadGrafica entidadgrafica;
	protected int rango_x;
	protected int rango_y;
	protected MapaProyectil mapaProyectil;

	
	protected Entidad() {
		entidadgrafica=new EntidadGrafica();
		rango_x=25;
		rango_y=50;
		resistencia=20;
	}
	
	public int getRangoX() {
		return rango_x;
	}
	
	public void setRangoX(int x) {
		this.rango_x=x;
	}
	
	public double getResistencia() {
		return resistencia;
	}
	
	public void setResistencia(int r) {
		this.resistencia=r;
	}
	
	public void setMapaBalas(MapaProyectil mb) {
		mapaProyectil=mb;
	}
	
	public MapaProyectil getMapaBalas() {
		return mapaProyectil;
	}
	
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadgrafica;
	}
	
	public double getVitalactual() { return cargaViralActual ;}
	public void setVitalactual(double cvital) { this.cargaViralActual = cvital ;}
	
	
	public int getRangoY() {
		return rango_y;
	}
	
	public void setRangoY(int y) {
		this.rango_y=y;
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
	public abstract void accionar(List<Entidad>infectados); 

	public void morir() {
		
	}
	
	
	

		
	public Visitor getVisitor() { return visitor ;}	
	
	public EstrategiaMovimiento getDireccion() { return direccion ;}	


	public abstract boolean estaVivo();


	
}
