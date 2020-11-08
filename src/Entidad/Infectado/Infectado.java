package Entidad.Infectado;

import javax.swing.ImageIcon;
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
		

		if (this.getDibujo().getY()<555) {					
			dibujo.setLocation(this.getDibujo().getX(),this.getDibujo().getY()+2);
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
