package Nivel;

import Entidad.Entidad;

import java.util.LinkedList;
import java.util.List;

public class Tanda {


	
	
	public Tanda() {
	
			
	}
	//crea una lista, de lista: es decir una lista cuyos componentes son tandas

	//si lista es impar, el ultimo lo descarta
	public List<List<Entidad>> crearTanda(NodoNivel nivel,int n,int p) {
													//int p=particiones
		int size=nivel.getPrimerNivel().getInfoNivel().getLista().size();
		
		//numero de particiones= 2, de n=5
		
			
		
		//cada tanda tiene n cantidad de jugadores
		
		//si es mayor a 2, no es correcto, m=1 o m=2
	
		int m=size/n;
		
		if (size%n!=0)
			m++;
		if (m>2)
			m--;
		
		//System.out.println(m); //2 paticiones
		
		
		List<List<Entidad>> lista_partition= new LinkedList<List<Entidad>>();

		for(int i=0;i<m;i++)
			
		{	int fromIndez =i*n;
			int toIndez = (i*n+n<size)?(i*n+n):size;
			List<Entidad> sub_lista= new LinkedList<Entidad>();

			for (int j=fromIndez;j<toIndez;j++)
				sub_lista.add(nivel.getPrimerNivel().getInfoNivel().getLista().get(j));
			//System.out.println("s: "+sub_lista.size());
			lista_partition.add(sub_lista);
		
		}
		
		if (size%2!=0)
			{	//en la sublista meto el ultimo
			
				
			}


		return lista_partition;
	
	}
	
	public List<List<Entidad>> crearTandaNivel2(NodoNivel nivel,int n,int p) {
		//int p=particiones
		int size=nivel.getSegundoNivel().getInfoNivel().getLista().size();

		//numero de particiones= 2, de n=5
		
		
		
		//cada tanda tiene n cantidad de jugadores
		
		//si es mayor a 2, no es correcto, m=1 o m=2
		
		int m=size/n;
		
		if (size%n!=0)
		m++;
		if (m>2)
		m--;
		
		//System.out.println(m); //2 paticiones
		
		
		List<List<Entidad>> lista_partition= new LinkedList<List<Entidad>>();

		//m es dos tandas
		for(int i=0;i<m;i++)
		
		{	
		
		int fromIndez =i*n;
		int toIndez = (i*n+n<size)?(i*n+n):size;
		List<Entidad> sub_lista= new LinkedList<Entidad>();
		
		for (int j=fromIndez;j<toIndez;j++)
		sub_lista.add(nivel.getSegundoNivel().getInfoNivel().getLista().get(j));
		//System.out.println("s: "+sub_lista.size());
		lista_partition.add(sub_lista);
		
		}
		
		if (size%2!=0)
		{	//en la sublista meto el ultimo
		
		
		}
		
		
		return lista_partition;
		
		}
	

		
	
	

	
}
