package Juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.*;
import Entidad.Jugador.*;
import Entidad.Infectado.*;



public class Mapa {

	protected GUI gui;
	protected Juego juego;
	protected static List<Entidad> lista_principal;
	protected static List<Entidad> lista_a_agregar;
	protected static List<Entidad> lista_a_eliminar;
	protected static List<Entidad> lista_de_piratas;
	Random random;
	private static String oleadas = "ppjbpv jpjjpbm bjppd"; //v m y d son los bosses finales de cada oleada (OBLIGATORIO ESE ORDEN)
    //entonces cada vez q muera alguno cambia la oleada o (si es d) ganas.
	
	
	
	public Mapa(GUI g, Juego j) {
		lista_principal = new LinkedList<Entidad>();
		lista_a_agregar = new LinkedList<Entidad>();
		lista_a_eliminar = new LinkedList<Entidad>();
		lista_de_piratas = new LinkedList<Entidad>();
		gui = g;
		juego = j;
		random = new Random();
	}

	public GUI getGui() {
		return gui;
	}
	
	public void add(Entidad obj) {
		lista_a_agregar.add(obj);
	}
	
	public void addpiratas(Entidad obj) {
		lista_de_piratas.add(obj);
	}
	
	public void resetLista(List<Entidad> l) {
		l.clear();
	}	
	
	public List<Entidad> getListaPrincipal() {
		return lista_principal;
	}
	public List<Entidad> getListaAgregar() {
		return lista_a_agregar;
	}
	public List<Entidad> getListaEliminar() {
		return lista_a_eliminar;
	}
	
	public List<Entidad> getListaPirata() {
		return lista_de_piratas;
	}
	
	public boolean puedoAgregarObjeto(Entidad obj) {
		boolean puedoInsertar = true;
		
		if( obj == null )
			return false;
		
		int x = obj.getDibujo().getX();
		int y = obj.getDibujo().getY();
		Rectangle rec = new Rectangle(x, y, obj.getDibujo().getWidth(), obj.getDibujo().getHeight());	
		
		for(Entidad elem : lista_principal)
			if(elem.getDibujo().getBounds().intersects(rec)) {
				puedoInsertar = false;	
				return false;
			}
		
		return puedoInsertar;
	}
		
	public List<Entidad> todosLosQueIntersecta(Entidad obj){
		List<Entidad> lista = new LinkedList<Entidad>();		
		for(Entidad elem : lista_principal)
			if(obj!=elem && elem.getDibujo().getBounds().intersects(obj.getDibujo().getBounds()))
				lista.add(elem);			
		return lista;
	}
	
	public Entidad intersectaObjeto(Entidad obj) {		
		for(Entidad elem : lista_principal)
			if(obj!=elem && elem.getDibujo().getBounds().intersects(obj.getDibujo().getBounds()))
					return elem;
		return null;
	}
	
	public Entidad intersectaRango(Entidad obj) {		
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		tamanioObj.width += obj.getRango();
		for(Entidad elem : lista_principal) {
			if(elem!=obj && elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
	
	public Entidad intersectaRangoDeEnemigo(Entidad obj) {
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		tamanioObj.translate(-obj.getRango(),0);
		tamanioObj.width += obj.getRango();
		for(Entidad elem : lista_principal) {
			if(elem!=obj && elem.getDibujo().getBounds().intersects(tamanioObj))
				return elem;
		}
		return null;
	}
	
	public void crearNivelUno(){	
		
		
		
		
		
		Player amigobeta = new Player1();
		amigobeta.setX(0);
		amigobeta.setY(450);
		add(amigobeta);
		amigobeta.setMapa(this);	
		
		Infectado enemigo = new InfectadoBeta();
		enemigo.setX(390);
		enemigo.setY(140);
		add(enemigo);
		enemigo.setMapa(this);
		
		Infectado enemigoX = new InfectadoAlpha();
		enemigoX.setX(190);
		enemigoX.setY(160);
		add(enemigoX);
		enemigoX.setMapa(this);
		
		
		
	}
	

	
	public Juego getJuego() {
		return juego;
	}

}
