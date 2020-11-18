package EstrategiaMovimiento;

import Entidad.Entidad;

public class MovimientoVerticalVirus extends EstrategiaMovimiento{
	
	public static final int ABAJO = 25;
	public static final int ARRIBA = -5;
	
	public MovimientoVerticalVirus(Entidad e, int d) {
		super(e, d);
		// TODO Auto-generated constructor stub
	}


	public void mover() {
	
		int coordy = entidad.getEntidadGrafica().getDibujo().getY();
		coordy = coordy + direccion;	
		
		entidad.getEntidadGrafica().getDibujo().setLocation(entidad.getEntidadGrafica().getDibujo().getX(),coordy);
		
	}
		
		

}
