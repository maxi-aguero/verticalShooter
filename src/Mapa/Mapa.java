package Mapa;


import java.util.LinkedList;
import java.util.List;
import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import Nivel.NodoNivel;
import Nivel.Tanda;

public class Mapa {

	protected Jugador jugador;	
	protected NodoNivel nivel;//aca tengo la lista de jugadores
	protected Tanda tanda;
	protected int tamanio_lv1;
	protected int tamanio_lv2;
	
	public Mapa() {
		jugador=new Jugador();	
		nivel=new NodoNivel();
		nivel.agregarNivel1();
		nivel.agregarNivel2();

		this.tanda=new Tanda();	
		tamanio_lv1=nivel.getPrimerNivel().getInfoNivel().getLista().size();
		tamanio_lv2=nivel.getSegundoNivel().getInfoNivel().getLista().size();
		//despues creo otra tanda!
		//tanda.crearTanda(nivel, nivel.getSegundoNivel().getInfoNivel().getLista().size());

		

	}
	
	public List<List<Entidad>> crearTandaN1() {
		List<List<Entidad>> tandas_nivel1=new LinkedList<List<Entidad>>();//tandas_nivel1=null;
		if (tamanio_lv1==nivel.getPrimerNivel().getInfoNivel().getLista().size())
			tandas_nivel1 = tanda.crearTanda(nivel, nivel.getPrimerNivel().getInfoNivel().getLista().size()/2,2);
		 
		return tandas_nivel1;
		
	}
	
	
	public List<List<Entidad>> crearTandaN2() {
		List<List<Entidad>> tandas_nivel2=new LinkedList<List<Entidad>>();//tandas_nivel1=null;
		
		if (tamanio_lv2==nivel.getSegundoNivel().getInfoNivel().getLista().size())
			{tandas_nivel2 = tanda.crearTandaNivel2(nivel, nivel.getSegundoNivel().getInfoNivel().getLista().size()/2,2);

			}
		return tandas_nivel2;
		
	}
	
	
	
	public NodoNivel getNivel() {
		
		return nivel;
		
	}
	
	
	
	public Jugador getJugador() {
		return jugador;
	}
	
	
	





	

	


}
