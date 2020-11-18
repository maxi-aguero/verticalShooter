package Nivel;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Nivel.Lista_Nivel1;
import Nivel.Lista_Nivel2;
public class Tanda {
	protected List<Entidad> lista_tanda;
	protected int nro_tanda;//ver
	protected int cant1;
	protected int cant2;
	protected Lista_Nivel1 lista_nivel_1;
	protected Lista_Nivel2 lista_nivel_2;
	
	public Tanda(Lista_Nivel1 lista_nivel_1,Lista_Nivel2 lista_nivel_2) {
		//tanda vacia
		lista_tanda = new LinkedList<Entidad>();
		cant1=lista_nivel_1.getLista().size()/2;
		cant2=lista_nivel_2.getLista().size()/2;
		this.lista_nivel_1=lista_nivel_1;
		this.lista_nivel_2=lista_nivel_2;
			
	}
	public void crearTanda() {
		
		if(lista_nivel_1.getLista().size()==0)
			if(lista_nivel_2.getLista().size()==0)
				{lista_tanda=null;}
			else
				{for(int i=0;i<cant2;i++)//tanda nivel 2
					lista_tanda.add(lista_nivel_2.getLista().get(i));
				}
		else
			{
			for(int i=0;i<cant1;i++)//tanda nivel 1
				lista_tanda.add(lista_nivel_1.getLista().get(i));
			}
		
	}
	public boolean esTandaVacia() {
		return this.lista_tanda.size()==0;
	}
	
	public List<Entidad> getLista() {
		return lista_tanda;		
	}

	public int getcant1(){
		return cant1;
	}
	
	public int getcant2(){
		return cant2;
	}
	
	
}
