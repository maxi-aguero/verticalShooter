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

public abstract class Visitor {
	

	public abstract void visitarJugador(Jugador j);
	
	public abstract void visitarInfectadoAlpha(InfectadoAlpha a);
	
	public abstract void visitarInfectadoBeta(InfectadoBeta b);
	
	public abstract void visitarArmaSanitaria(DisparoJugador d);
	
	public abstract void visitarVirusAlpha(ProyectilVirusAlpha v);
	
	public abstract void visitarVirusBeta(ProyectilVirusBeta v);
	
	public abstract void visitarPremioVida(PremioVida pv);
	
	public abstract void visitarPremioSuperArma(PremioSuperArma psa);

	public abstract void visitarPremioVelocidad(PremioVelocidad p);
	
	public abstract void visitarPremioDetener(PremioDetener p);	
	
}