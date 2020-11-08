package Entidad.Jugador;


import javax.swing.ImageIcon;

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
		
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo));		
		dibujo.setIcon(imagen);	
		
		
		int coordx = this.getDibujo().getX();
		if (coordx<400) {
			coordx = coordx + 2;		
			
			dibujo.setLocation(coordx,this.getDibujo().getY());
			}
		else
		{
			
			
			dibujo.setLocation(this.getX(),this.getY());
		}
			
				
	}
		
	


	public void accept(Visitor v){
		v.visit(this);
	} 
	
	public void morir() {      
			
	}



}
