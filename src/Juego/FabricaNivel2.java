package Juego;


//ModernFactory
public class FabricaNivel2 extends FabricaNivel {

	@Override
	protected Lista_Nivel1 getlistaN1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Lista_Nivel2 getlistaN2() {
		// TODO Auto-generated method stub
		return new Nivel2();
	}

	

	
	
	

	

}