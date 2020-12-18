package Entidad.Proyectil;


import java.util.List;

import Entidad.Entidad;


public abstract class Proyectil extends Entidad {

	protected Proyectil() {
		super();		
	}
	
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		iniciarAtaque(obj);		
	}
	
	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void accionar(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		
	}	
		


}
