package Premio;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorPremioDetener;

public class PremioDetener extends Premio{

	public PremioDetener(int x,int y) {		
		super();
		visitor = new VisitorPremioDetener(this);
		direccion = new MovimientoVertical(this,1); 		
		entidadgrafica.setImagen("img/juego/posionverde.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		velocidad=5;
		
	}
	
	@Override
	public List<Entidad> detectarColisiones(List<Entidad> infectados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioDetener(this);

	}

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();

	}

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accionar(List<Entidad> infectados) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
