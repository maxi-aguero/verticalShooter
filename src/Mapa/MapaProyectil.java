package Mapa;
import Entidad.Entidad;

import java.util.LinkedList;
import java.util.List;

public class MapaProyectil {
	protected List<Entidad> conj_balas;
	
	public  MapaProyectil() {
		conj_balas = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getListaBalas(){
		return conj_balas;
	}
	
	public void ponerBalasEnLista(Entidad obj) {
		conj_balas.add(obj);
	}
}