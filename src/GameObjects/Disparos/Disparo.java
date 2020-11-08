package GameObjects.Disparos;


import Entidad.Entidad;


public abstract class Disparo extends Entidad {

	protected Disparo(int danio, int rango) {
		super(0, 0, 0, 0);
		
		ruta_dibujo = "img/disparos/disparo_angosto.gif";
		
	}
	
	
	public boolean interactuar() {
	mover();
	Entidad objIntersectado = mapa.intersectaObjeto(this);
	if(objIntersectado != null) 
		objIntersectado.accept(visitor);	
	return true;
	}

	@Override
	public void atacar(Entidad obj) {
		
	}
	
	@Override
	public void iniciarAtaque(Entidad obj) {
	}	

	
	
	

}
