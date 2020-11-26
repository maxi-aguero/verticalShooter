package Premio;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;

public class PremioTemporal extends Premio {

	protected PremioTemporal(int x,int y) {
		super();
		// TODO Auto-generated constructor stub
		entidadgrafica.setImagen("img/jugador/munic.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		
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
