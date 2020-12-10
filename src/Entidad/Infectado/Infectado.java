package Entidad.Infectado;


import Entidad.Personaje;
import EstrategiaMovimiento.EstrategiaMovimiento;


public abstract class Infectado extends Personaje   {
	protected Infectado(int cargaViralActual) {

		super(cargaViralActual);
		
		
	}	
	
	//muevo al infectado en una direccion 
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
	}	


}
