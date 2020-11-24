package Entidad.Proyectil;

public class Arma {
	protected DisparoJugador municion;
	protected DisparoJugador superMunicion;
	public Arma() {
		
	}
	
	public DisparoJugador crearArmaBasica(int x,int y) {
		municion=new DisparoJugador(x,y);
		return municion;
	}
	
	public DisparoJugador crearArmaSuper(int x,int y) {
		superMunicion=new DisparoJugador(x,y);
		superMunicion.setVelocidad(155);
		return superMunicion;

	}
	
	
}
