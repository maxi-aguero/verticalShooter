package mapa;

public class InfectadoAlpha extends Infectado {

	protected InfectadoAlpha(int x, int y, int velocidad,String img) {
		super(x, y, velocidad,img);
		// TODO Auto-generated constructor stub
		visitor = new VisitanteInfectado(this);

	}

}
