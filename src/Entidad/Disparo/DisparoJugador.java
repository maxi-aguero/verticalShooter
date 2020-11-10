package Entidad.Disparo;


import EstrategiaMovimiento.EstrategiaMovimiento;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Disparo {

	public DisparoJugador(int danio, int rango) {
		super(danio, rango);
		visitor = new VisitorDisparoJugador(this);
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
