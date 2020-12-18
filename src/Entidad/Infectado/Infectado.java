package Entidad.Infectado;

import Entidad.Entidad;
import Entidad.Personaje;

public abstract class Infectado extends Personaje   {
	
	protected Infectado(int cargaViralActual) {
		super(cargaViralActual);		
	}	
	
	
	//condicion de vida del infectado
		@Override
	public boolean estaVivo() {
			// TODO Auto-generated method stub
			return cargaViralActual>0?true:false;
	}

		
	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		iniciarAtaque(obj);
		
	}	
	
	

	
	
}
