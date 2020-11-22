package Entidad.Jugador;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Personaje;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoHorizontal;
import Mapa.MapaArmaSanitaria;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected MapaArmaSanitaria mapavirusgui;//balas
	protected MapaArmaSanitaria mapavirus;
	//protected MapaArmaSanitaria mapavirus;
	
	public Jugador() {
		
		super(0, 100, 5); 
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		entidadgrafica.setImagen("img/jugador/juliefrente.gif");
		entidadgrafica.setX(50);
		entidadgrafica.setY(420);
		//miEstado = new EstadoNormal(this);

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

	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		//no ataca, en lugar de ello al apretar flecha ariba, lanza el ataque
		//y el infectado alpha o beta reciben ataque
		
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
		 
		//flushDibujo(ruta_dibujo_ataque);		
		//Punto p = new Punto(punto.getX()+ancho-30, punto.getY());
		//miEstado.disparar(danio, p, rango);
	}

	//public boolean interactuar() {

	
	
	
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
	}

	public void recibirataque() {
		// TODO Auto-generated method stub
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
	public void recibirAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		cargaViralActual=cargaViralActual + 0.055;

		
	}


	public void setMapaBalasGUI(MapaArmaSanitaria mvg) {
		mapavirusgui=mvg;
	}
	
		
	
	public void setMapaBalas(MapaArmaSanitaria mv) {
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
		tamanioObj.translate(- 0,0);
		tamanioObj.width += 0;
		for(Entidad ent:infectados)
		{
			if(ent.getEntidadGrafica().getDibujo()!=null)
				if(ent.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
					conj_infectados.add(ent);
		}
	
			
		
		return conj_infectados;
	}


	

}
