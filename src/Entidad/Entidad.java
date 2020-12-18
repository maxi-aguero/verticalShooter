package Entidad;


import EstrategiaMovimiento.EstrategiaMovimiento;
import Mapa.MapaProyectil;
import Visitor.Visitor;

public abstract class Entidad {
	protected double resistencia;
	protected double cargaViralActual; 									
	protected int velocidad;
	protected Visitor visitor;		
	protected EstrategiaMovimiento direccion; 
	protected EntidadGrafica entidadGrafica;
	protected int rango_x;
	protected int rango_y;
	protected MapaProyectil ListaDeProyectil;//listaDeProyectil: guarda virus para infectados

	
	protected Entidad() {
		entidadGrafica=new EntidadGrafica();
		rango_x=25;
		rango_y=50;
		resistencia=20;
	}
	
	public int getRangoX() {
		return rango_x;
	}
	
	public int getRangoY() {
		return rango_y;
	}	
	
	public double getResistencia() {
		return resistencia;
	}
	
	public void setResistencia(double r) {
		this.resistencia=r;
	}
	
	public void setMapaBalas(MapaProyectil mb) {
		ListaDeProyectil=mb;
	}
	
	public MapaProyectil getMapaBalas() {
		return ListaDeProyectil;
	}
	
	
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	public double getVitalactual() { return cargaViralActual ;}
	public void setVitalactual(double cvital) { this.cargaViralActual = cvital ;}
	
	
	public int getVelocidad() {
		return velocidad;
	}
	
	
	public void setVelocidad(int velocidad) {
		this.velocidad=velocidad;
	}
	
	public abstract void accept(Visitor v);	
	public abstract void atacar(Entidad obj); 
	public abstract void iniciarAtaque(Entidad obj);
	
	public Visitor getVisitor() { return visitor ;}	
	
	public EstrategiaMovimiento getDireccion() { return direccion ;}
	

	public abstract boolean estaVivo();	
	public abstract void AumentarVelocidad();

	//muevo a una Entidad en una direccion d
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
	}
	
	
	
	

}
