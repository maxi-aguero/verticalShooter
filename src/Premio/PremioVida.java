package Premio;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Visitor.Visitor;
import Visitor.VisitorPremioVida;
//premio recuperar vida
public class PremioVida extends Premio {

	public PremioVida(int x,int y) {
		super();
		visitor = new VisitorPremioVida(this);	
		direccion = new MovimientoVerticalVirus(this,1);	
		entidadgrafica.setImagen("img/juego/posionazul.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		velocidad=5;
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioVida(this);

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
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void accionar(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		
	}

}
