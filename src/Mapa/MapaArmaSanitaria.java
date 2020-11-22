package Mapa;
import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Infectado.Infectado;
import Entidad.Proyectil.DisparoJugador;
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
	
	public Entidad intersecta_virus_jugador(Entidad obj,List<Entidad>infectados) {
		//quien es obj= municion sanitoria		
		if (obj.getEntidadGrafica().getDibujo()!=null) {
		Rectangle tamanioObj = obj.getEntidadGrafica().getDibujo().getBounds();
		//esta mal creo
			tamanioObj.translate(- 0,0);
			tamanioObj.width += 0;
			for(Entidad ent:infectados)
			{	// interactua arma sanitaria e infectado 
				
				if(ent.getEntidadGrafica().getDibujo()!=null)
					if(ent.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
						return ent;					
			
			}
		}
		return null;
		
	}
}
