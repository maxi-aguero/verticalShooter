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
	public void visitarVirusAlpha(ProyectilVirusAlpha v) {

	}

	@Override
	public void visitarPremioVida(PremioVida pv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha a) {
		// TODO Auto-generated method stub
		//atacar al alpha
		d.atacar(a);
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta i) {
		// TODO Auto-generated method stub
		d.atacar(i);

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
