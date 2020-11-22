package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorInfectadoBeta extends Visitor {
	private InfectadoBeta b;

	public VisitorInfectadoBeta(InfectadoBeta b) {
		this.b=b;
	}

	@Override
	public void visitarJugador(Jugador j) {//cuando veo un jugador ataco, o recibo danio
		b.atacar(j);
		
	}

	

	@Override
	public void visitarArmaSanitaria(DisparoJugador d) {
		b.recibirAtaque(d);

	}

	@Override
	public void visitarVirus(ProyectilVirus v) {
		

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
	
}
