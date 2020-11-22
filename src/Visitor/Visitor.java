package Visitor;

import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public abstract class Visitor {
	

	public abstract void visitarJugador(Jugador j);
	
	public abstract void visitarInfectadoAlpha(InfectadoAlpha a);
	
	public abstract void visitarInfectadoBeta(InfectadoBeta b);
	
	public abstract void visitarArmaSanitaria(DisparoJugador d);
	
	public abstract void visitarVirus(ProyectilVirus v);
	
	public abstract void visitarPremioVida(PremioVida pv);

	
	
}
