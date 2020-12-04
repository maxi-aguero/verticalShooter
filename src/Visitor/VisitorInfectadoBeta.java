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

public class VisitorInfectadoBeta extends Visitor {
	private InfectadoBeta b;

	public VisitorInfectadoBeta(InfectadoBeta b) {
		this.b=b;
	}

	@Override
	public void visitarJugador(Jugador j) {
		b.atacar(j);// es solo lanzar virus
		
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
		b.mover(b.getDireccion());
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta be) {
		// TODO Auto-generated method stub
		b.mover(b.getDireccion());
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
