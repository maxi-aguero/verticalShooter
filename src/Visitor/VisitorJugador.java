package Visitor;

import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirusAlpha;
import Entidad.Proyectil.ProyectilVirusBeta;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Premio.PremioVida;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorJugador extends Visitor {
	private Jugador j;

	public VisitorJugador(Jugador j) {
		this.j = j;	
	}

	@Override
	public void visitarJugador(Jugador j) {
		
	}

	

	@Override
	public void visitarArmaSanitaria(DisparoJugador d) {

	}

	@Override
	public void visitarVirusAlpha(ProyectilVirusAlpha v) {

	}

	@Override
	public void visitarPremioVida(PremioVida pv) {
		// TODO Auto-generated method stub
		//coger el premio
		j.cogerPremioVida(pv);

	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha a) {
		// TODO Auto-generated method stub
		//no ataco a alpha porque el que ataca es la arma sanitaria
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta b) {
		// TODO Auto-generated method stub
		//no ataco a beta porque el que ataca es la arma sanitaria

	}

	@Override
	public void visitarVirusBeta(ProyectilVirusBeta v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioSuperArma(PremioSuperArma psa) {
		// TODO Auto-generated method stub
		
		j.cogerPremioSuperArma(psa);

	}

	@Override
	public void visitarPremioVelocidad(PremioVelocidad pv) {
		// TODO Auto-generated method stub
		
		j.cogerPremioVelocidad(pv);
	}

	
}
