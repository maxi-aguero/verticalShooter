package Entidad.Disparo;


import Entidad.Entidad;

public abstract class Disparo extends Entidad {

	protected Disparo(int danio, int rango) {
		super(0, 0, 0, 0);		
		//ruta_dibujo = "img/disparos/";
		
	}
	
	
	public boolean interactuar() {	
	return true;
	}

	@Override
	public void atacar(Entidad obj) {
		
	}
	
	@Override
	public void iniciarAtaque(Entidad obj) {
	}	

	
	
	

}
