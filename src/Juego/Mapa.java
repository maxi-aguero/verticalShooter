package Juego;


import java.awt.Rectangle;

import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Jugador.Jugador;

public class Mapa {

	protected Jugador jugador;

	
	protected FabricaNivel nivel;	
	protected FabricaNivel[] factories= new FabricaNivel[2];

	protected Lista_Nivel1 lista_nivel_1;
	protected Lista_Nivel2 lista_nivel_2;
	protected Tanda tanda_actual;

	
	public Mapa() {
		jugador=new Jugador();	

		factories[0]=new FabricaNivel1();
		factories[1]=new FabricaNivel2();

		nivel=factories[0];
		lista_nivel_1 = nivel.getlistaN1();
		nivel=factories[1];
		lista_nivel_2 = nivel.getlistaN2();
		
		tanda_actual=new Tanda(lista_nivel_1,lista_nivel_2);

	}
	
	public Lista_Nivel1 getListaN1() {
		return lista_nivel_1;
	}
	
	public Lista_Nivel2 getListaN2() {
		return lista_nivel_2;
	}
	
	public Tanda getTanda() {
		return tanda_actual;
	}
	
	public int getCant1() {
		return tanda_actual.getcant1();//getCantTanda1
	}
	public int getCant2() {
		return tanda_actual.getcant2();
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public Entidad intersecta_algo(Entidad obj) {
		
		Rectangle tamanioObj = obj.getDibujo().getBounds();
		
		Personaje pp=(Personaje) obj;
		tamanioObj.translate(- pp.getRango(),0);
		tamanioObj.width += pp.getRango();
			// jugador interecta a infectado 
			if(jugador.getDibujo().getBounds().intersects(tamanioObj))
				return jugador;
		//}
		return null;
		
	}




	

	


}
