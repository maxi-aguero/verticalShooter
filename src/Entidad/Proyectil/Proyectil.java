package Entidad.Proyectil;


import Entidad.Entidad;


public abstract class Proyectil extends Entidad {
	protected int danio;

	protected Proyectil() {
		super(); 

		
	}
	
	public int getDanio() {
		return danio;
	}
	
	public void setDanio(int d) {
		danio=d;
	}
	
	
	
	


}
