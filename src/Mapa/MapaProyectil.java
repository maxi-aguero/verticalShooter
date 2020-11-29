package Mapa;
import Entidad.Entidad;
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
