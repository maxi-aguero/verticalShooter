package factory;

import Products.Plane_A;
import Products.Plane_B;

public abstract class PlaneFactory {
	public abstract Plane_A getPlaneA();
	public abstract Plane_B getPlaneB();
}
