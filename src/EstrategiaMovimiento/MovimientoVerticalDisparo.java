package EstrategiaMovimiento;

import Entidad.Entidad;
//para virus
//no para premio porque los virus baja mas rapido
//puede ser ABAJOLENTO o ABAJOPREMIO= 5
import Entidad.Proyectil.DisparoJugador;

public class MovimientoVerticalDisparo extends EstrategiaMovimiento{
	
	//public static final int ABAJOPREMIO = 5;//premio abajo
	
	
	public MovimientoVerticalDisparo(Entidad e, int d) {
		super(e, d);
		
		// TODO Auto-generated constructor stub
	}


	public void mover() {
		
		int coordy = entidad.getEntidadGrafica().getDibujo().getY();
		
		coordy = coordy + direccion;	
		entidad.getEntidadGrafica().setY(coordy);

		entidad.getEntidadGrafica().getDibujo().setLocation(entidad.getEntidadGrafica().getDibujo().getX(),coordy);
		
	}
		
		

}
