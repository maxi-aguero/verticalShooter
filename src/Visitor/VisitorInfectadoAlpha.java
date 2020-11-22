package Visitor;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirus;
import Premio.PremioVida;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorInfectadoAlpha extends Visitor {
	private InfectadoAlpha a;

	public VisitorInfectadoAlpha(InfectadoAlpha a) {
		this.a=a;
	}

	@Override
	public void visitarJugador(Jugador j) {//cuando veo un jugador ataco, o recibo danio
		a.atacar(j);
		
	}
	

	

	@Override
	public void visitarArmaSanitaria(DisparoJugador d) {
		a.recibirAtaque(d);//recibe otro ataque que el ataque de infectado beta

	}

	@Override
	public void visitarVirus(ProyectilVirus v) {
		

	}

	@Override
	public void visitarPremioVida(PremioVida pv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha al) {
		// TODO Auto-generated method stub
		a.mover(a.getDireccion());
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta b) {
		// TODO Auto-generated method stub
		a.mover(a.getDireccion());
	}
	
}
