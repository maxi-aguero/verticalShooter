package Entidad.Proyectil;

import java.util.List;

import Entidad.Entidad;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoVertical;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Proyectil {

	public DisparoJugador(int x,int y) {
		super();
		visitor = new VisitorDisparoJugador(this);	
		velocidad=-5;
		direccion = new MovimientoVertical(this,velocidad);	
		entidadgrafica.setImagen("img/jugador/munic.png");
		entidadgrafica.setX(x);
		entidadgrafica.setY(y);
		
		
	}
	
	
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarArmaSanitaria(this);

	}

	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
	}



	
	
	
	
	//no estan en disparo-enemigo

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		iniciarAtaque(obj);
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		 double cargaViral = obj.getVitalactual();
		 cargaViral=cargaViral-obj.getResistencia();//que ataque le hago es mas resistente el objeto beta
		 obj.setVitalactual(cargaViral);
		//System.out.println("carga viral:"+obj.getVitalactual());

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
