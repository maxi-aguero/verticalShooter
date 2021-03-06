package Visitor;

import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirusAlpha;
import Entidad.Proyectil.ProyectilVirusBeta;
import Premio.PremioDetener;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Premio.PremioVida;
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
	public void visitarVirusAlpha(ProyectilVirusAlpha d) {
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

	@Override
	public void visitarVirusBeta(ProyectilVirusBeta v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioSuperArma(PremioSuperArma psa) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void visitarPremioVelocidad(PremioVelocidad p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioDetener(PremioDetener p) {
		// TODO Auto-generated method stub
		
	}

	
}
