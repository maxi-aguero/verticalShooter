 package Nivel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class Nivel2 extends Lista{
	public Nivel2() {
		
		listaInfectados=new LinkedList<Entidad>();
		
		
		int []numero_armado=new int[14];

		int inicio=100;
		for (int i=0;i<14;i++)
		{	
			numero_armado[i]=inicio;
			inicio=inicio+40;

		}
		
		int []arr=new int[14];
		arr=crearNumRandomUnico();
				
		
		Infectado infectado01 = new InfectadoAlpha();
		infectado01.getEntidadGrafica().setX(numero_armado[arr[0]]);
		infectado01.getEntidadGrafica().setY(150);
		
		Infectado infectado02 = new InfectadoBeta();		
		infectado02.getEntidadGrafica().setX(numero_armado[arr[1]]);
		infectado02.getEntidadGrafica().setY(150);
		
		Infectado infectado03 = new InfectadoBeta();
		infectado03.getEntidadGrafica().setX(numero_armado[arr[2]]);
		infectado03.getEntidadGrafica().setY(150);
		
		Infectado infectado04 = new InfectadoBeta();
		infectado04.getEntidadGrafica().setX(numero_armado[arr[3]]);
		infectado04.getEntidadGrafica().setY(150);
		
		Infectado infectado05 = new InfectadoBeta();
		infectado05.getEntidadGrafica().setX(numero_armado[arr[4]]);
		infectado05.getEntidadGrafica().setY(150);
		
		Infectado infectado06 = new InfectadoAlpha();
		infectado06.getEntidadGrafica().setX(numero_armado[arr[5]]);
		infectado06.getEntidadGrafica().setY(150);
		
		Infectado infectado07 = new InfectadoBeta();
		infectado07.getEntidadGrafica().setX(numero_armado[arr[6]]);
		infectado07.getEntidadGrafica().setY(150);
		
		Infectado infectado08 = new InfectadoBeta();
		infectado08.getEntidadGrafica().setX(numero_armado[arr[7]]);
		infectado08.getEntidadGrafica().setY(150);
		
		Infectado infectado09 = new InfectadoBeta();
		infectado09.getEntidadGrafica().setX(numero_armado[arr[8]]);
		infectado09.getEntidadGrafica().setY(150);
		
		Infectado infectado10 = new InfectadoBeta();
		infectado10.getEntidadGrafica().setX(numero_armado[arr[9]]);
		infectado10.getEntidadGrafica().setY(150);
		
		Infectado infectado11= new InfectadoBeta();
		infectado11.getEntidadGrafica().setX(numero_armado[arr[9]]);
		infectado11.getEntidadGrafica().setY(150);
	
		infectado01.setResistencia(1.03);
		infectado02.setResistencia(0.88);
		infectado03.setResistencia(0.88);
		infectado04.setResistencia(0.88);		
		infectado05.setResistencia(0.88);
		
		infectado06.setResistencia(0.983);
		infectado07.setResistencia(0.73);
		infectado08.setResistencia(0.73);
		infectado09.setResistencia(0.73);
		infectado10.setResistencia(0.73);
		infectado11.setResistencia(0.73);

		
		listaInfectados.add(infectado01);
		listaInfectados.add(infectado02);
		listaInfectados.add(infectado03);
		listaInfectados.add(infectado04);
		listaInfectados.add(infectado05);
		
		listaInfectados.add(infectado06);		
		listaInfectados.add(infectado07);
		listaInfectados.add(infectado09);
		listaInfectados.add(infectado10);
		listaInfectados.add(infectado11);
		

	
		
	}
	
	private int[] crearNumRandomUnico(){
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
