package mapa;

import java.util.LinkedList;
import java.util.List;




public class Mapa {
	protected GUI gui;
	protected Juego juego;
	protected static List<Entidad> lista_principal;//lista donde tengo 4 enemigos, que son los de una partida o tanda
	protected static List<Entidad> lista_a_agregar;
	protected static List<Entidad> lista_a_eliminar;
	
	
	

	public Mapa(GUI g, Juego j) {
		gui=g;
		juego=j;
		lista_principal = new LinkedList<Entidad>();
		lista_a_agregar = new LinkedList<Entidad>();
		lista_a_eliminar = new LinkedList<Entidad>();

		
	}
	
	
}
