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
		entidadgrafica.setImagen("img/juego/posionamarilla.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		velocidad=5;
	}
	
	public List<Entidad> detectarColisiones(List<Entidad> infectados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(Visitor v) {
		v.visitarPremioVelocidad(this);
	}

	@Override
	public void mover(EstrategiaMovimiento d) {
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

	@Override
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		
	}
	

}
