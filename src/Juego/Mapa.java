package Juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.*;
import Entidad.Jugador.*;
import Entidad.Infectado.*;



public class Mapa {

	protected static List<Entidad> listaEnJuego;
	protected static List<Entidad> listaInicial;
	protected static List<Entidad> l_elementosBorrados;
	protected static List<Entidad> listaJugador;
	Random random;
	
	
	
	public Mapa(Juego j) {
		listaEnJuego = new LinkedList<Entidad>();
		listaInicial = new LinkedList<Entidad>();
		l_elementosBorrados = new LinkedList<Entidad>();
		listaJugador = new LinkedList<Entidad>();
		random = new Random();
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
	


	
	public Entidad intersectaRangoDeEnemigo(Entidad obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		tamanioObj.translate(-obj.getRango(),0);
		tamanioObj.width += obj.getRango();
		for(Entidad elem : listaEnJuego) {
			if(elem!=obj && elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
	
	public void crearNivelUno(){	
		
		
		
		
		
		Player player01 = new Player1();
		player01.setX(0);
		player01.setY(450);
		addIncial(player01);
		addJugador(player01);
		
		
		
		Infectado infectado01 = new InfectadoBeta();
		infectado01.setX(390);
		infectado01.setY(140);
		addIncial(infectado01);
		
		Infectado infectado02 = new InfectadoAlpha();
		infectado02.setX(350);
		infectado02.setY(160);
		addIncial(infectado02);
		
		Infectado infectado03 = new InfectadoBeta();
		infectado03.setX(360);
		infectado03.setY(140);
		addIncial(infectado03);
		
		Infectado infectado04 = new InfectadoAlpha();
		infectado04.setX(333);
		infectado04.setY(60);
		addIncial(infectado04);
		
		
		
	}
	

	


}
