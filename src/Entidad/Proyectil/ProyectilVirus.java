package Entidad.Proyectil;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;
import Visitor.VisitorContagiarVirus;

public class ProyectilVirus extends Proyectil {

	public ProyectilVirus() {
		
		visitor = new VisitorContagiarVirus(this);
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
	
	


	

}
