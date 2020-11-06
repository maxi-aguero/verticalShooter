package mapa;

import mapa.GameConfig.Direction;

public abstract class Movimiento {
	protected Direction direccion;
	protected Entidad entidad;
	
	public Movimiento(Entidad entidad, Direction direccion){
		this.entidad  = entidad;
		this.direccion = direccion; 
	}
	
	public Direction getDireccion()
	{
		return direccion;
	}
	
	//dice que si se mueve a derecha o izquierda o abajo
	public void setDireccion(Direction d)
	{
		this.direccion = d;
	}
	
	public abstract void mover();


}
