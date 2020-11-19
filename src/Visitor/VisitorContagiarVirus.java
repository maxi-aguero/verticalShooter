package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Entidad.Infectado.Infectado;

public class VisitorContagiarVirus extends Visitor {

	public VisitorContagiarVirus(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Jugador a) {		
		entidad.atacar(a);	
	}

	@Override
	public void visit(Infectado e) {
		System.out.println("20");

	}

	@Override
	public void visit(DisparoJugador d) {
		System.out.println("30");

	}

	@Override
	public void visit(ProyectilVirus d) {
		System.out.println("40");

	}
	
}
