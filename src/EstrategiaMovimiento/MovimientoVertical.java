package EstrategiaMovimiento;

import Entidad.Entidad;

public class MovimientoVertical extends EstrategiaMovimiento{
	
	public MovimientoVertical(Entidad e, int d) {
		super(e, d);		
	}


	public void mover() {
		
		int coordy = entidad.getEntidadGrafica().getDibujo().getY();
		
		coordy = coordy + direccion;	
		entidad.getEntidadGrafica().setY(coordy);
		entidad.getEntidadGrafica().getDibujo().setLocation(entidad.getEntidadGrafica().getDibujo().getX(),coordy);
		
	}
		
		

}
