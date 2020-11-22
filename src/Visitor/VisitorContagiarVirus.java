package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorContagiarVirus extends Visitor {
	private ProyectilVirus v;

	public VisitorContagiarVirus(ProyectilVirus v) {
		this.v=v;
	}

	@Override
	public void visitarJugador(Jugador j) {		
		v.atacar(j);	
	}

	

	@Override
	public void visitarArmaSanitaria(DisparoJugador d) {

	}

	@Override
	public void visitarVirus(ProyectilVirus v) {

	}

	@Override
	public void visitarPremioVida(PremioVida pv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta b) {
		// TODO Auto-generated method stub
		
	}
	
}
