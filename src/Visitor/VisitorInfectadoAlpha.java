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

public class VisitorInfectadoAlpha extends Visitor {
	private InfectadoAlpha a;

	public VisitorInfectadoAlpha(InfectadoAlpha a) {
		this.a=a;
	}

	@Override
	public void visitarJugador(Jugador j) {
		a.atacar(j); // es solo lanzar virus
		
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
	public void visitarInfectadoAlpha(InfectadoAlpha al) {
		// TODO Auto-generated method stub
		//a.mover(a.getDireccion());

	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta b) {
		// TODO Auto-generated method stub
		//a.mover(a.getDireccion());

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
