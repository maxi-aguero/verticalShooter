package Premio;


import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;


public abstract class Premio extends Entidad {

	protected Premio() {
		super(); 		
	}	
		
	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
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
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}	


}
