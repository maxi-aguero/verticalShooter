package GameObjects.Disparos;

import Visitor.Visitor;
import Visitor.VisitorContagiarVirus;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int danio,  int rango) {
		super(danio,  rango);
		visitor = new VisitorContagiarVirus(this);
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
