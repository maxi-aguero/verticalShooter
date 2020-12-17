package Entidad.Jugador;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Proyectil.Arma;
import Entidad.Proyectil.DisparoJugador;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoHorizontal;
import Premio.PremioDetener;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected int tipoArma;
	protected Arma arma;
	protected DisparoJugador disparoActual=null;
	
	protected int tipoJugador;
	protected List<Entidad> elemQuietos;
	
	public Jugador() {		
		super(0); 
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		entidadgrafica.setX(50);
		entidadgrafica.setY(420);
		rango_x=35;
		velocidad=5;
		tipoArma=0;
	}
	
	public int getTipoArma() {
		return tipoArma;
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
	
	//nuevo al jugador a cierta direccion
	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub

		d.mover();
	}

//cuando ha agarrado un premio SuperArma setea el arma en tipo 1( que es una SuperArma)
	public void cogerPremioSuperArma(PremioSuperArma obj) {
		// TODO Auto-generated method stub
		tipoArma=1;		
	}
	
	public void settipoArma(int t) {
		tipoArma=t;
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


	@Override
	//Jugador detecta con quienes colisiona de la lista de entidad
	public List<Entidad> detectarColisiones(List<Entidad>entidad) {
		// TODO Auto-generated method stub		
		List<Entidad> conj_infectados  = new LinkedList<Entidad>();
		Rectangle tamanioObj = getEntidadGrafica().getDibujo().getBounds();
		for(Entidad ent:entidad)
		{
			if(ent.getEntidadGrafica().getDibujo()!=null)
				if(ent.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
					conj_infectados.add(ent);
		}
	
			
		
		return conj_infectados;
	}
	
	//recibo entidades y me fijo si colisionan
	@Override
	public void accionar(List<Entidad>entidad) {
		// TODO Auto-generated method stub
		List<Entidad> ListaEntidad = detectarColisiones(entidad);
		for (Entidad obj:ListaEntidad)
			{	obj.accept(visitor);				
				this.accept(obj.getVisitor());	
			}
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
	
	public DisparoJugador clone(DisparoJugador d) {
		DisparoJugador salida= new DisparoJugador(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		salida.setVelocidad(d.getVelocidad());
		salida.getEntidadGrafica().setImagen(d.getEntidadGrafica().getImagen());
	
		return salida;
	}

}
