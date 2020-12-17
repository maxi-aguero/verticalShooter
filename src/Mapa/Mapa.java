package Mapa;


import java.util.LinkedList;
import java.util.List;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Nivel.Lista;
import Nivel.Nivel1;
import Nivel.Nivel2;
import Nivel.NodoNivel;
import Nivel.Tanda;

public class Mapa {

	protected Jugador jugador;	
	protected NodoNivel nivel;
	protected Tanda tanda;
	
	public Mapa() {
		jugador=new Jugador();	
		
		Lista listaNuevaNivel1 = new Nivel1();
		Lista listaNuevaNivel2 = new Nivel2();
		
		nivel=new NodoNivel();
		nivel.agregarNivel1();
		nivel.agregarNivel2();
		this.tanda=new Tanda();	
	}
	
	public List<List<Entidad>> crearTandasN1() {
		List<List<Entidad>> tandas_nivel1=new LinkedList<List<Entidad>>();
		tandas_nivel1 = tanda.crearTanda(nivel.getPrimerNivel(), nivel.getPrimerNivel().getInfoNivel().getLista().size()/2);		 
		return tandas_nivel1;		
	}
	
	
	public List<List<Entidad>> crearTandasN2() {
		List<List<Entidad>> tandas_nivel2=new LinkedList<List<Entidad>>();	
		tandas_nivel2 = tanda.crearTanda(nivel.getSegundoNivel(), nivel.getSegundoNivel().getInfoNivel().getLista().size()/2);
		return tandas_nivel2;		
	}
	
	
	public Jugador getJugador() {
 		return jugador;
	}
	
	
	





	

	


}
