package Mapa;
import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Infectado.Infectado;
import Entidad.Proyectil.Proyectil;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class MapaArmaSanitaria {
	protected List<Entidad> conj_balas;
	
	public  MapaArmaSanitaria() {
		conj_balas = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getListaBalas(){
		return conj_balas;
	}
	
	public void ponerBalasEnLista(Entidad obj) {
		conj_balas.add(obj);
	}
	
	public Entidad intersecta_virus_jugador(Entidad obj,Entidad jugador) {
		
		Rectangle tamanioObj = obj.getEntidadGrafica().getDibujo().getBounds();
		
		tamanioObj.translate(- 0,0);
		tamanioObj.width += 0;

			// jugador interecta a infectado 
			if(jugador.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
				return jugador;
				//return jugador;
		//}
		return null;
		
	}
}
