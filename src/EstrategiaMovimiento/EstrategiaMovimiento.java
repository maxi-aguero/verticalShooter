package EstrategiaMovimiento;

import Entidad.Entidad;

public abstract class EstrategiaMovimiento {
	protected int direccion;
	protected Entidad entidad;
	
	public EstrategiaMovimiento(Entidad e, int d)
	{
		this.entidad  = e;
		this.direccion = d; ;
	}
	
	public int getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(int d)
	{
		this.direccion = d;
	}
	
	public abstract void mover();


}
