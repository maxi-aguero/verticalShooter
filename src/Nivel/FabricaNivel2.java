package Nivel;


//ModernFactory
public class FabricaNivel2 extends FabricaNivel {

	public FabricaNivel2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Lista_Nivel1 getlistaN1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lista_Nivel2 getlistaN2() {
		// TODO Auto-generated method stub
		return new Nivel2();
	}

	

	
	
	

	

}