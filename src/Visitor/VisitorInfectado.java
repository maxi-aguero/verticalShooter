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
	public void visit(Jugador a) {//cuando veo un jugador ataco, o recibo danio
		entidad.atacar(a);
		
	}

	@Override
	public void visit(Infectado e) {
			//cuando veo a un infectado me muevo
			entidad.mover(entidad.getDireccion());

			//e.getDireccion().setDireccion(MovimientoVertical.ABAJO );
			//e.mover(e.getDireccion());

	}

	@Override
	public void visit(DisparoJugador d) {
		//obj.mover();
		//entidad.mover(entidad.getDireccion());


	}

	@Override
	public void visit(ProyectilVirus d) {
		//obj.mover();
		//entidad.mover(entidad.getDireccion());


	}
	
}
