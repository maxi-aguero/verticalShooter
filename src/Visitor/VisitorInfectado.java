package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Player;
import EstrategiaMovimiento.MovimientoVertical;
import Entidad.Disparo.DisparoJugador;
import Entidad.Disparo.EmitirContagio;
import Entidad.Infectado.Infectado;

public class VisitorInfectado extends Visitor {

	public VisitorInfectado(Entidad o) {
		super(o);
	}

	@Override
	public void visit(Player a) {
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
	public void visit(EmitirContagio d) {
		//obj.mover();

	}
	
}
