package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import EstrategiaMovimiento.MovimientoVertical;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Entidad.Infectado.Infectado;

public class VisitorInfectado extends Visitor {

	public VisitorInfectado(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Jugador a) {
		//obj.atacar(a);

		
	}

	@Override
	public void visit(Infectado e) {
			
			e.getDireccion().setDireccion(MovimientoVertical.ABAJO );
			e.mover(e.getDireccion());

	}

	@Override
	public void visit(DisparoJugador d) {
		//obj.mover();

	}

	@Override
	public void visit(ProyectilVirus d) {
		//obj.mover();

	}
	
}
