package Entidad.Jugador;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Proyectil.DisparoJugador;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoHorizontal;
import Mapa.MapaProyectil;
import Premio.PremioSuperArma;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected MapaProyectil mapavirus;
	protected int tipoArma;
	//protected MapaArmaSanitaria mapavirus;
	
	public Jugador() {
		
		super(0, 100, 5); 
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		entidadgrafica.setImagen("img/jugador/juliefrente.gif");
		entidadgrafica.setX(50);
		entidadgrafica.setY(420);
		rango_x=35;
		velocidad=5;
		tipoArma=0;
		//miEstado = new EstadoNormal(this);

	}
	public int getTipoArma() {
		return tipoArma;
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarJugador(this);

	}
	
	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub

		d.mover();
	}

	public void cogerPremioVida(Entidad obj) {
		// TODO Auto-generated method stub
		//agarra el premio
		cargaViralActual=0;
		
	}
	
	public void cogerPremioSuperArma(PremioSuperArma obj) {
		// TODO Auto-generated method stub
		//agarra el premio
		//this es jugador
		//obj es proyectil
		tipoArma=1;
		
	}
	
	public void settipoArma(int t) {
		tipoArma=t;
	}
	
	
	
	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		//no ataca, en lugar de ello al apretar flecha ariba, lanza el ataque
		
		/**
		 *  frecuencia_ataques++;
			if(vida>0) {  // si estoy vivo, ataco		
				if(frecuencia_ataques%velocidad_ataque== 0)
					iniciarAtaque(obj);
		} 
		    else
				morir();
		 * 
		 * */
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		 
		
	}


	
	
	
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
	}

	
		
	
	public void setMapaBalas(MapaProyectil mv) {
		mapavirus=mv;
	}

	@Override
	//hacer intersecta this jugador con una lista de infecados

	public List<Entidad> detectarColisiones(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		//�Como es el detectar colisiones?
		// Me fijo con quién estoy chocando, y lo devuelvo en una colección.
		//this==jugador
		//con quien me choco? nose
		
		List<Entidad> conj_infectados  = new LinkedList<Entidad>();
		Rectangle tamanioObj = getEntidadGrafica().getDibujo().getBounds();
		for(Entidad ent:infectados)
		{
			if(ent.getEntidadGrafica().getDibujo()!=null)
				if(ent.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
					conj_infectados.add(ent);
		}
	
			
		
		return conj_infectados;
	}
	//recibo los infectados de la tanda y me fijo si colisionan
	
	@Override
	public void accionar(List<Entidad>infectados) {
		// TODO Auto-generated method stub
		List<Entidad> c = detectarColisiones(infectados);
		
		//solo los veo
		for (Entidad infectadito:c)
			{	infectadito.accept(visitor);
				
				this.accept(infectadito.getVisitor());	//pero tambien me acepto a mi


				//yo como jugador no quiero disparar, disparo solo cuando presiono space
			}
	}
	
	
	
	
	
	
	



	

}
