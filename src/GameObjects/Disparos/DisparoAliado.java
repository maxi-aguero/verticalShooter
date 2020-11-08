package GameObjects.Disparos;


import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoAliado extends Disparo {

	public DisparoAliado(int danio, int rango) {
		super(danio, rango);
		visitor = new VisitorDisparoJugador(this);
	}

	@Override
	public void accept(Visitor v){
		v.visit(this);  
	} 

	public void mover() {	
		
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}

}
