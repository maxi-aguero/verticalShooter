package mapa;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;




public class Mapa {

	protected GUI gui;
	protected Juego juego;
	protected static List<Entidad> lista_principal;
	protected static List<Entidad> lista_a_agregar;//agrega infectados
	protected static List<Entidad> lista_a_eliminar;
	protected static List<Entidad> lista_jugador;
	Random random;
	private static String oleadas = "ppjbpv jpjjpbm bjppd"; //v m y d son los bosses finales de cada oleada (OBLIGATORIO ESE ORDEN)
    //entonces cada vez q muera alguno cambia la oleada o (si es d) ganas.
	
	
	
	public Mapa(GUI g, Juego miJuego) {
		lista_principal = new LinkedList<Entidad>();
		lista_a_agregar = new LinkedList<Entidad>();
		lista_a_eliminar = new LinkedList<Entidad>();
		lista_jugador = new LinkedList<Entidad>();
		gui = g;
		juego = miJuego;
		random = new Random();
	}

	public GUI getGui() {
		return gui;
	}
	
	public void addInfectado(Entidad obj) {
		lista_a_agregar.add(obj);
	}
	
	public void addJugador(Entidad player01) {
		lista_jugador.add(player01);
	}
	
	public List<Entidad> getListaJugador() {
		return lista_jugador;
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
	
	
	
	
	
	
	public void crearNivelUno(){ 		
		//agregar los infectados y al jugador
		Entidad player01=new Jugador(45, 450, 10,"mapa/img/jugador.png"); 
		addJugador(player01);
		
		Entidad alpha01=new InfectadoAlpha(85, 140, 10,"mapa/img/alpha.png");
		addInfectado(alpha01);
		
		Entidad alpha02=new InfectadoAlpha(205, 140, 10,"mapa/img/alpha.png"); 
		addInfectado(alpha02);
		
		Entidad alpha03=new InfectadoAlpha(315, 140, 10,"mapa/img/alpha.png"); 
		addInfectado(alpha03);
		
		Entidad alpha04=new InfectadoAlpha(425, 140, 10,"mapa/img/alpha.png"); 
		addInfectado(alpha04);
		
		
		
		
		
		Entidad beta01=new InfectadoBeta(85, 200, 10,"mapa/img/beta.png");
		addInfectado(beta01);
		
		Entidad beta02=new InfectadoBeta(205, 200, 10,"mapa/img/beta.png"); 
		addInfectado(beta02);
		
		Entidad beta03=new InfectadoBeta(315, 200, 10,"mapa/img/beta.png"); 
		addInfectado(beta03);
		
		Entidad beta04=new InfectadoBeta(425, 200, 10,"mapa/img/beta.png"); 
		addInfectado(beta04);
		
		
	}
	
	
	public Juego getJuego() {
		return juego;
	}

}
