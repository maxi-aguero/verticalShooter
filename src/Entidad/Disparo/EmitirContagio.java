package Entidad.Disparo;

import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;
import Visitor.VisitorContagiarVirus;

public class EmitirContagio extends Disparo {

	public EmitirContagio(int danio,  int rango) {
		super(danio,  rango);
		visitor = new VisitorContagiarVirus(this);
	}
	
	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 


	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		
	}


	

}
