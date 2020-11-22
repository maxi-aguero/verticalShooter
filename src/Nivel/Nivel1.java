package Nivel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;

//modern1
public class Nivel1 extends Lista{
	public Nivel1() {
		cantidad=new int[3];
		cantidad[0]=0;
		cantidad[1]=11;
		cantidad[2]=33;
		listaInfectados=new LinkedList<Entidad>();
		
		
		int []numero_armado=new int[14];
		//[100-140-180-220-260-300-340-380-420-460-500-540-580-620]

		int inicio=100;
		for (int i=0;i<14;i++)
		{	
			numero_armado[i]=inicio;
			inicio=inicio+40;

		}

		
		int []arr=new int[14];
		arr=crearNumRandomUnico();
		
		//numero_armado[arr[x]] es un elemento de [100-140-180-220-260-300-340-380-420-460-500-540-580-620] al azar
		
		
		Infectado infectado01 = new InfectadoAlpha();
		infectado01.getEntidadGrafica().setX(numero_armado[arr[0]]);
		infectado01.getEntidadGrafica().setY(150);
		
		Infectado infectado02 = new InfectadoAlpha();		
		infectado02.getEntidadGrafica().setX(numero_armado[arr[1]]);
		infectado02.getEntidadGrafica().setY(150);
		
		Infectado infectado03 = new InfectadoAlpha();
		infectado03.getEntidadGrafica().setX(numero_armado[arr[2]]);
		infectado03.getEntidadGrafica().setY(150);
		
		Infectado infectado04 = new InfectadoAlpha();
		infectado04.getEntidadGrafica().setX(numero_armado[arr[3]]);
		infectado04.getEntidadGrafica().setY(150);
		
		Infectado infectado05 = new InfectadoAlpha();
		infectado05.getEntidadGrafica().setX(numero_armado[arr[4]]);
		infectado05.getEntidadGrafica().setY(150);
		
		Infectado infectado06 = new InfectadoAlpha();
		infectado06.getEntidadGrafica().setX(numero_armado[arr[5]]);
		infectado06.getEntidadGrafica().setY(150);
		
		Infectado infectado07 = new InfectadoAlpha();
		infectado07.getEntidadGrafica().setX(numero_armado[arr[6]]);
		infectado07.getEntidadGrafica().setY(150);
		
		Infectado infectado08 = new InfectadoAlpha();
		infectado08.getEntidadGrafica().setX(numero_armado[arr[7]]);
		infectado08.getEntidadGrafica().setY(150);
	
		
		listaInfectados.add(infectado01);
		listaInfectados.add(infectado02);
		listaInfectados.add(infectado03);
		listaInfectados.add(infectado04);
		listaInfectados.add(infectado05);
		listaInfectados.add(infectado06);		
		listaInfectados.add(infectado07);
		listaInfectados.add(infectado08);
		

	
		
	}
	
	//crea[0-1-2-3-4-5-6-7-8-9-10-11-12-13-14] en cualquier orden
	public int[] crearNumRandomUnico(){
		int from=0;
		int to=13;
		int n= to -from+1;
		int[]toReturn=new int[n]; 
		for(int i=from;i<n;i++) {
			toReturn[i]=i;
		}
		int []result=new int[n];
		
		int x=n;
		Random rd=new Random(); //0-10		
		
		for(int i=from;i<n;i++)
		{
			int k=rd.nextInt(x);
			result[i]=toReturn[k];
			toReturn[k]=toReturn[x-1];
			x--;
		}
		
		return result;
}
	
	
	
	@Override
	public List<Entidad> getLista() {
		// TODO Auto-generated method stub
		return listaInfectados;
	}
	

}
