package Premio;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.*;

public class PremioVelocidad extends Premio{

	public PremioVelocidad(int x,int y) {
		super();
		visitor=new VisitorPremioVelocidad(this);
		direccion=new MovimientoVertical(this,1);
		entidadGrafica.setImagen("img/juego/posionamarilla.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);
		velocidad=5;
	}
	

	@Override
	public void accept(Visitor v) {
		v.visitarPremioVelocidad(this);
	}




}
