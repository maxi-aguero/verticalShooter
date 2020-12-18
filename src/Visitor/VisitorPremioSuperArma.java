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

public class VisitorPremioSuperArma extends Visitor {
	private PremioSuperArma p;

	public VisitorPremioSuperArma(PremioSuperArma ps) {
		this.p=ps;
	}

	@Override
	public void visitarJugador(Jugador j) {
		DisparoJugador salida= new DisparoJugador(j.getEntidadGrafica().getDibujo().getX(),j.getEntidadGrafica().getDibujo().getY());
		salida.setVelocidad(155);
		salida.getEntidadGrafica().setImagen("img/jugador/ball.png");
		j.getDisparoJugador().getDireccion().setDireccion(j.getDisparoJugador().getVelocidad());
		j.setDisparoJugador(salida);

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
