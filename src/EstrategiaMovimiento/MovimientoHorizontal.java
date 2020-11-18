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
						
	
		int coordx = entidad.getEntidadGrafica().getDibujo().getX();
		if( (coordx>=0) && (coordx<=620)) {
			coordx = coordx - direccion;	
			
			entidad.getEntidadGrafica().getDibujo().setLocation(coordx,entidad.getEntidadGrafica().getDibujo().getY());
			entidad.getEntidadGrafica().setX(coordx);
			
			}
		if(coordx>620)			
			{entidad.getEntidadGrafica().getDibujo().setLocation(coordx-1,entidad.getEntidadGrafica().getDibujo().getY());
			entidad.getEntidadGrafica().setX(coordx-1);

			}
			

		if(coordx<0)			
			{entidad.getEntidadGrafica().getDibujo().setLocation(coordx+1,entidad.getEntidadGrafica().getDibujo().getY());
			entidad.getEntidadGrafica().setX(coordx+1);
			}

		
	}
	

	

	

	

}
