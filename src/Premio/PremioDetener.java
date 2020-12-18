package Premio;


import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorPremioDetener;

public class PremioDetener extends Premio{

	public PremioDetener(int x,int y) {		
		super();
		visitor = new VisitorPremioDetener(this);
		direccion = new MovimientoVertical(this,1); 		
		entidadGrafica.setImagen("img/juego/posionverde.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);
		velocidad=5;
		
	}
	
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioDetener(this);

	}
}
