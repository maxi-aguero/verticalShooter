package Premio;

import java.util.List;

import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Visitor.Visitor;
import Visitor.VisitorPremioSuperArma;
import Visitor.VisitorPremioVida;
//premio super arma
public class PremioSuperArma extends Premio {

	public PremioSuperArma(int x,int y) {
		super();
		visitor = new VisitorPremioSuperArma(this);	
		
		direccion = new MovimientoVerticalVirus(this,1);	
		entidadgrafica.setImagen("img/juego/posionroja.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		velocidad=5;
	}
	public void setX(int x) {
		entidadgrafica.setX(x);
	}
	
	public void setY(int y) {
		entidadgrafica.setX(y);
	}
	
	public void setDireccion(int d) { 
		direccion.setDireccion(d) ;
		
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		//v.visitarPremioVida(this);

	}

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();

	}

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
		//cambio config de Jugador
		
	}
	
	public void cambiarConfig(Jugador j) {
		j.settipoArma(1);//cambia velocidad del disparo
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void accionar(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		
	}

}
