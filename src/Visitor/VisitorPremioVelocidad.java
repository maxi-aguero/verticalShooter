package Visitor;

import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirusAlpha;
import Entidad.Proyectil.ProyectilVirusBeta;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Premio.PremioVida;

public class VisitorPremioVelocidad extends Visitor{
	private PremioVelocidad p;
	
	public  VisitorPremioVelocidad(PremioVelocidad p) {
		this.p=p;
	}
	
	public void visitarJugador(Jugador j) {
		
		
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
	public void visitarArmaSanitaria(DisparoJugador d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVirusAlpha(ProyectilVirusAlpha v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarVirusBeta(ProyectilVirusBeta v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioVida(PremioVida pv) {
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

}
