package mapa;


public class Jugador extends Entidad{

	protected Jugador(int x, int y, int velocidad,String img) {
		super(x, y, velocidad,img);
		// TODO Auto-generated constructor stub
		visitor = new VisitanteJugador(this);
		
		

	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void atacar(Entidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lanzarAtaque(Entidad entidad) {
		// TODO Auto-generated method stub
		
	}

	

}