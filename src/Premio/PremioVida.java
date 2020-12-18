package Premio;

import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorPremioVida;
//premio recuperar vida
public class PremioVida extends Premio {
	
	public PremioVida(int x,int y) {
		super();
		visitor = new VisitorPremioVida(this);	
		direccion = new MovimientoVertical(this,1);	
		entidadGrafica.setImagen("img/juego/posionazul.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);
		velocidad=5;
	}	
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioVida(this);

	}
	
	
}
