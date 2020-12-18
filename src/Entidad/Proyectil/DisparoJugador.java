package Entidad.Proyectil;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Proyectil {

	public DisparoJugador(int x,int y) {
		super();
		visitor = new VisitorDisparoJugador(this);	
		velocidad=-5;
		direccion = new MovimientoVertical(this,velocidad);	
		entidadGrafica.setImagen("img/jugador/munic.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);		
	}
		
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarArmaSanitaria(this);

	}

	

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		 double cargaViral = obj.getVitalactual();
		 cargaViral=cargaViral-obj.getResistencia();
		 obj.setVitalactual(cargaViral);

	}

	

	

}
