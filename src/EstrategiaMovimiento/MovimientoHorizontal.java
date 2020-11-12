package EstrategiaMovimiento;

import Entidad.Entidad;

public class MovimientoHorizontal extends EstrategiaMovimiento{
	
	public static final int DERECHA = -2;
	public static final int IZQUIERDA = 2;
	
	public MovimientoHorizontal(Entidad e, int d) {
		super(e, d);
		// TODO Auto-generated constructor stub
	}


	public void mover() {
		// TODO Auto-generated method stub
						
	
		int coordx = entidad.getDibujo().getX();
		if( (coordx>=0) && (coordx<=620)) {
			coordx = coordx - direccion;	
			
			entidad.getDibujo().setLocation(coordx,entidad.getDibujo().getY());
			}
		if(coordx>620)			
			entidad.getDibujo().setLocation(coordx-1,entidad.getDibujo().getY());
			

		if(coordx<0)			
			entidad.getDibujo().setLocation(coordx+1,entidad.getDibujo().getY());

		
	}
	

	

	

	

}
