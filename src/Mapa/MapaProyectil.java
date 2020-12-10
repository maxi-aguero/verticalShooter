package Mapa;
import Entidad.Entidad;
import java.util.LinkedList;
import java.util.List;

public class MapaProyectil {
	protected List<Entidad> conj_proyectil;//guarda tanto virus, proyectiles de arma sanitaria y premio
	
	
	public  MapaProyectil() {
		conj_proyectil = new LinkedList<Entidad>();
	}
	
	
	public List<Entidad> getLista(){
		return conj_proyectil;
	}
	
	public void ponerEnLista(Entidad obj) {
		conj_proyectil.add(obj);
	}
	
	
	
}
