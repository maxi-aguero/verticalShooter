package EstrategiaMovimiento;

import Entidad.Entidad;
//de infectado
public class MovimientoVerticalDeInfectado extends EstrategiaMovimiento{
	
	
	public MovimientoVerticalDeInfectado(Entidad e, int d) {		

		super(e, d);
		
		// TODO Auto-generated constructor stub
	}


	public void mover() {
	
		int coordy = entidad.getEntidadGrafica().getDibujo().getY();
		coordy = coordy + direccion;	
		
		entidad.getEntidadGrafica().getDibujo().setLocation(entidad.getEntidadGrafica().getDibujo().getX(),coordy);
		
		
		if(coordy>555)							

			entidad.getEntidadGrafica().getDibujo().setLocation(entidad.getEntidadGrafica().getX(),entidad.getEntidadGrafica().getY());
			

	}
		
		

}
