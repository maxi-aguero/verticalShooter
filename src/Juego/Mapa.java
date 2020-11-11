package Juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;
import Entidad.Jugador.Player;
import Entidad.Jugador.Player1;



public class Mapa {

	protected static List<Entidad> listaEnJuego;
	protected static List<Entidad> listaInicial;
	protected static List<Entidad> l_elementosBorrados;
	protected static List<Entidad> listaJugador;
	
	
	
	public Mapa() {
		listaEnJuego = new LinkedList<Entidad>();
		listaInicial = new LinkedList<Entidad>();
		l_elementosBorrados = new LinkedList<Entidad>();
		listaJugador = new LinkedList<Entidad>();
	}


	
	public void addIncial(Entidad obj) {
		listaInicial.add(obj);
	}
	
	public void addJugador(Entidad obj) {
		listaJugador.add(obj);
	}
	
	public Entidad dameJugador() {
		return listaJugador.get(0);
	}
	
	public void resetLista(List<Entidad> l) {
		l.clear();
	}	
	
	public List<Entidad> getListaEnJuego() {
		return listaEnJuego;
	}
	public List<Entidad> getListaAgregar() {
		return listaInicial;
	}
	public List<Entidad> getListaEliminar() {
		return l_elementosBorrados;
	}
	
	public List<Entidad> getListaJugador() {
		return listaJugador; 
	}
	


	//intesecta personajes: Jugador vs Enemigo
	public Entidad intersectaRangoDeEnemigo(Entidad obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		
		Personaje pp=(Personaje) obj;
		tamanioObj.translate(- pp.getRango(),0);
		tamanioObj.width += pp.getRango();
		for(Entidad elem : listaEnJuego) {
			if(elem!=obj && elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
	
	public void crearNivelUno(){	
		
		
		
		
		
		Player player01 = new Player1();
		player01.setX(50);
		player01.setY(420);
		addIncial(player01);
		addJugador(player01);
		
		
	
		Infectado infectado01 = new InfectadoBeta();
		infectado01.setX(90);
		infectado01.setY(140);
		addIncial(infectado01);
		
		Infectado infectado03 = new InfectadoBeta();
		infectado03.setX(180);
		infectado03.setY(140);
		addIncial(infectado03);
		
		Infectado infectado02 = new InfectadoAlpha();
		infectado02.setX(110);
		infectado02.setY(80);
		addIncial(infectado02);
		
		Infectado infectado04 = new InfectadoAlpha();
		infectado04.setX(12);
		infectado04.setY(60);
		addIncial(infectado04);
		
		
		Infectado infectado05 = new InfectadoBeta();
		infectado05.setX(390);
		infectado05.setY(140);
		addIncial(infectado05);
		
		Infectado infectado06 = new InfectadoAlpha();
		infectado06.setX(610);
		infectado06.setY(80);
		addIncial(infectado06);
		

		
	
		
		
	}
	

	


}
