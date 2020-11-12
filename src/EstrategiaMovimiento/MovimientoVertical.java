package EstrategiaMovimiento;

import Entidad.Entidad;

public class MovimientoVertical extends EstrategiaMovimiento{
	
	public static final int ABAJO = 5;
	
	public MovimientoVertical(Entidad e, int d) {
		super(e, d);
		// TODO Auto-generated constructor stub
	}


	public void mover() {
	
		
		int coordy = entidad.getDibujo().getY();
		coordy = coordy + direccion;	
		
		entidad.getDibujo().setLocation(entidad.getDibujo().getX(),coordy);
		entidad.getDibujo().setLocation(entidad.getDibujo().getX(),coordy);
		
		if(coordy>555)			
			entidad.getDibujo().setLocation(entidad.getX(),entidad.getY());
			

	}
		
		

}
