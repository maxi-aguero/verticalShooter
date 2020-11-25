package Mapa;
import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Infectado.Infectado;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.Proyectil;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class MapaProyectil {
	protected List<Entidad> conj_proyectil;//guarda tanto virus y proyectiles de arma sanitaria
	
	
	public  MapaProyectil() {
		conj_proyectil = new LinkedList<Entidad>();
	}
	
	
	public List<Entidad> getLista(){
		return conj_proyectil;
	}
	
	public void ponerBalasEnLista(Entidad obj) {
		conj_proyectil.add(obj);
	}
	
	
	
}
