package Entidad.Infectado;



import Entidad.Personaje;
import EstrategiaMovimiento.EstrategiaMovimiento;
import Mapa.MapaProyectil;
import Premio.Premio;
import Premio.PremioVida;


public abstract class Infectado extends Personaje   {
	protected Infectado(int cargaViralActual, int cargaViralPierde, int rango) {

		super(cargaViralActual, cargaViralPierde, rango);
		
		
	}	
	

 
	
	
	
	
	
	
	
	//public boolean interactuar() {		}

	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
	}	


}
