package Mapa;
import Entidad.Entidad;
import java.util.LinkedList;
import java.util.List;

public class MapaPremio {
	protected List<Entidad> conj_premio;
	
	public  MapaPremio() {
		conj_premio = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getListaPremio(){
		return conj_premio;
	}
	
	public void ponerPremioEnLista(Entidad obj) {
		conj_premio.add(obj);
	}
	
	
}
