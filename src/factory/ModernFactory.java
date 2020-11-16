package factory;

import Products.Plane_A;
import Products.Plane_B;
import Products.modern.Modern1;
import Products.modern.Modern2;

public class ModernFactory extends PlaneFactory{

	@Override
	public Plane_A getPlaneA() {
		// TODO Auto-generated method stub
		return new Modern1();
	}

	@Override
	public Plane_B getPlaneB() {
		// TODO Auto-generated method stub
		return new Modern2();
	}
	
	

}
