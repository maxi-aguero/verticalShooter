package Entidad.Jugador;

import java.util.List;

import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Proyectil.Arma;
import Entidad.Proyectil.DisparoJugador;
import EstrategiaMovimiento.MovimientoHorizontal;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected Arma arma;
	protected DisparoJugador disparoActual=null;	
	protected int tipoJugador;
	protected List<Entidad> elemQuietos;
	
	public Jugador() {		
		super(0); 
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		entidadGrafica.setX(50);
		entidadGrafica.setY(420);
		rango_x=35;
		velocidad=5;
	}
	

	
	public int getTipoJugador() {
		return tipoJugador;
	}
	
	public void setTipoJugador(int t) {
		tipoJugador=t;
	}

	//el visitor v visita a Jugador
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarJugador(this);

	}
	
	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub 
		
	}

	//condicion de vida de Jugador
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
	}


		
	
	
	//setea la velocidad de una lista de Entidad si ha agarrado un PremioDetener
	public void setelemQuietos(List<Entidad> listaEntidad) {
		elemQuietos=listaEntidad;
	}
	
	public List<Entidad> getelemQuietos(){
		return elemQuietos;
	}	
	
	
	@Override
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		
	}
	
	public void setDisparoJugador(DisparoJugador d) {
		disparoActual=d;
	}
	
	public DisparoJugador getDisparoJugador() {
		return clone(disparoActual);
		
	}

	public void setArma(Arma a) {
		arma = a;
		if(disparoActual==null) {
		  disparoActual=a.crearArmaBasica(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		}
	}
	
	public Arma getArma () {
		return arma;
	}
	
	private DisparoJugador clone(DisparoJugador d) {
		DisparoJugador salida= new DisparoJugador(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		salida.setVelocidad(d.getVelocidad());
		salida.getEntidadGrafica().setImagen(d.getEntidadGrafica().getImagen());
	
		return salida;
	}

}
