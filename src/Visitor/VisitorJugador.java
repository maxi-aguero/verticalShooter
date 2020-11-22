package Visitor;

import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.Infectado;
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
	public void visitarVirus(ProyectilVirus v) {
		j.recibirAtaque(v);
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

	
}
