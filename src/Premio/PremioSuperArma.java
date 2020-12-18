package Premio;


import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorPremioSuperArma;
//premio super arma
public class PremioSuperArma extends Premio {

	public PremioSuperArma(int x,int y) {
		super();
		visitor = new VisitorPremioSuperArma(this);			
		direccion = new MovimientoVertical(this,1);	
		entidadGrafica.setImagen("img/juego/posionroja.png");
		entidadGrafica.setX(x);
		entidadGrafica.setY(y);
		velocidad=5;
	}

	
	
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub

	}

	
	



	
}
