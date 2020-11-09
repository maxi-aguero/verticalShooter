package Entidad.Jugador;


import Entidad.Entidad;
import Visitor.Visitor;

public abstract class Player extends Entidad   {
	
	

	protected Player(int cargaViralActual, int cargaViralPierde, int rango, int velMov, int velAt, int puntos, int monedas) {

		super(cargaViralActual, cargaViralPierde, rango, velMov);
	}	
	
	@Override
	public void atacar(Entidad obj) {
		
	}
	
	public void iniciarAtaque(Entidad obj) {
			
	}
	
	
	public boolean interactuar() {		
		Entidad objIntersectado = mapa.intersectaRangoDeEnemigo(this);
		if(objIntersectado!=null) 
			objIntersectado.accept(visitor);
		else
			mover();
			
		
		return true;
		
	}
	
	public void mover() {		
				
	}
	
	public abstract void moverizquierda();
	public abstract void moverderecha();

		
	
	
	


	public void accept(Visitor v){
		v.visit(this);
	} 
	
	public void morir() {      
			
	}



}
