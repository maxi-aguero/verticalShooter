package Visitor;

import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorPremioVida extends Visitor {
	private PremioVida p;

	public VisitorPremioVida(PremioVida p) {
		this.p=p;
	}

	@Override
	public void visitarJugador(Jugador j) {

	}

	
	

	@Override
	public void visitarArmaSanitaria(DisparoJugador d) {

	}

	@Override
	public void visitarVirus(ProyectilVirus d) {
	}

	@Override
	public void visitarPremioVida(PremioVida pv) {

		
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
