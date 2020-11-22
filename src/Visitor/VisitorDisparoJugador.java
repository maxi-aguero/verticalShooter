package Visitor;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorDisparoJugador extends Visitor {
	private DisparoJugador d;

	public VisitorDisparoJugador(DisparoJugador d) {
		this.d=d;
	}

	@Override
	public void visitarJugador(Jugador j) {		

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
	public void visitarInfectadoBeta(InfectadoBeta i) {
		// TODO Auto-generated method stub
		
	}
	
}
