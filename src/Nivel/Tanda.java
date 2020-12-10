package Nivel;

import Entidad.Entidad;

import java.util.LinkedList;
import java.util.List;

public class Tanda {

	
	public Tanda() {}

	public List<List<Entidad>> crearTanda(NodoNivel nivel,int participantes) {
		int size=nivel.getInfoNivel().getLista().size();			
		int m=size/participantes;
		
		if (size%participantes!=0)
			m++;
		if (m>2)
			m--;
		
		List<List<Entidad>> lista_partition= new LinkedList<List<Entidad>>();
		int fromIndex=0;
		int toIndex=0;
		for(int i=0;i<m;i++)
			
		{	fromIndex =i*participantes;
			toIndex = (i*participantes+participantes<size)?(i*participantes+participantes):size;
			List<Entidad> sub_lista= new LinkedList<Entidad>();

			for (int j=fromIndex;j<toIndex;j++)
				sub_lista.add(nivel.getInfoNivel().getLista().get(j));
			lista_partition.add(sub_lista);
		
		}
		
		


		return lista_partition;
	
	}
	
	

		
	
	

	
}
