package Entidad;


public abstract class Personaje extends Entidad {
	protected double cargaViralActual; //jugador pierde con 100 - comienza con 0									
	protected int cargaViralPierde; //infectado pierde con 0- comienza con 100
	protected int rango; //rango de tiro
	
	
	protected Personaje(int cargaViralActual, int cargaViralPierde, int rango) {
		super();

		this.cargaViralActual = cargaViralActual; 
		this.cargaViralPierde=cargaViralPierde;
		this.rango = rango;
				
	}
	
	public int getRango() {	return rango ;}
	public void setRango(int rango) { this.rango = rango ;}
	
	public double getVitalactual() { return cargaViralActual ;}
	public void setVitalactual(int cvital) { this.cargaViralActual = cvital ;}
	

	
	
	
	
	
}
