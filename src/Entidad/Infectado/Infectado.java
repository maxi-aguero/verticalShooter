package Entidad.Infectado;

import Entidad.Entidad;
import Visitor.Visitor;

public abstract class Infectado extends Entidad   {
	
	
	protected Infectado(int cargaViralActual, int cargaViralPierde, int rango, int velocidad, int velAt, int puntos, int monedas) {

		super(cargaViralActual, cargaViralPierde, rango, velocidad);
	}	
	
	@Override
	public void atacar(Entidad obj) {
	
	}
	
	public void iniciarAtaque(Entidad obj) {
			
	}
	

	public void accept(Visitor v){
		v.visit(this);
	} 
	
	public void morir() {    
		
	}

	


}
