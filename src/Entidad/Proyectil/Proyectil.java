package Entidad.Proyectil;


import Entidad.Entidad;


public abstract class Proyectil extends Entidad {
	protected int danio;
	
	protected Proyectil() {		
		super(); 
	}
	
	public int getDanio() {
		return danio;
	}
	
	public void setDanio(int d) {
		danio=d;
	}
	
	@Override
	public void atacar(Entidad obj) {
		//iniciarAtaque(obj);
		//if(obj.getVida()<=0)
			//obj.morir();
		//morir();
	}
	
	@Override
	public void iniciarAtaque(Entidad obj) {

		//obj.setVida(obj.getVida()-danio); // los disparos hacen daño directamente		
	}	



	
	
	

}
