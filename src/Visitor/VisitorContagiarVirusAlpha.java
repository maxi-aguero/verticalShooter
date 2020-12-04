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

public class VisitorContagiarVirusAlpha extends Visitor {
	private ProyectilVirusAlpha v;

	public VisitorContagiarVirusAlpha(ProyectilVirusAlpha v) {
		this.v=v;
	}

	@Override
	public void visitarJugador(Jugador j) {		
		v.atacar(j);	//el virus ataca al jugador 
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
	
}
