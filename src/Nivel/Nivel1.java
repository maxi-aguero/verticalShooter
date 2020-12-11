package Nivel;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;

public class Nivel1 extends Lista{
	public Nivel1() {
		
		listaInfectados=new LinkedList<Entidad>();
		
		miFabrica=new Factory[2];
		miFabrica[0]=new FactoryAlpha();
		miFabrica[1]=new FactoryBeta();
		
		
		int []numero_armado=new int[14];
		int inicio=100;
		for (int i=0;i<14;i++)
		{	
			numero_armado[i]=inicio;
			inicio=inicio+40;
		}
		int []arr=new int[14];
		arr=crearNumRandomUnico();
		
		Infectado infectado01 = miFabrica[1].getBeta();
		infectado01.getEntidadGrafica().setX(numero_armado[arr[0]]);
		infectado01.getEntidadGrafica().setY(150);
		
		Infectado infectado02 = miFabrica[0].getAlpha();		
		infectado02.getEntidadGrafica().setX(numero_armado[arr[1]]);
		infectado02.getEntidadGrafica().setY(150);
		
		Infectado infectado03 = miFabrica[0].getAlpha();
		infectado03.getEntidadGrafica().setX(numero_armado[arr[2]]);
		infectado03.getEntidadGrafica().setY(150);
		
		Infectado infectado04 = miFabrica[0].getAlpha();
		infectado04.getEntidadGrafica().setX(numero_armado[arr[3]]);
		infectado04.getEntidadGrafica().setY(150);
		
		Infectado infectado05 = miFabrica[1].getBeta();
		infectado05.getEntidadGrafica().setX(numero_armado[arr[4]]);
		infectado05.getEntidadGrafica().setY(150);
		
		Infectado infectado06 = miFabrica[1].getBeta();
		infectado06.getEntidadGrafica().setX(numero_armado[arr[5]]);
		infectado06.getEntidadGrafica().setY(150);
		
		Infectado infectado07 = miFabrica[1].getBeta();
		infectado07.getEntidadGrafica().setX(numero_armado[arr[6]]);
		infectado07.getEntidadGrafica().setY(150);
		
		Infectado infectado08 = miFabrica[0].getAlpha();
		infectado08.getEntidadGrafica().setX(numero_armado[arr[7]]);
		infectado08.getEntidadGrafica().setY(150);
	
		
		infectado01.setResistencia(0.83);
		infectado02.setResistencia(2.23);
		infectado03.setResistencia(2.23);
		infectado04.setResistencia(2.23);
		
		infectado05.setResistencia(1.83);
		infectado06.setResistencia(1.83);
		infectado07.setResistencia(1.83);
		infectado08.setResistencia(1.93);
		
		
		
		listaInfectados.add(infectado01);
		listaInfectados.add(infectado02);
		listaInfectados.add(infectado03);
		listaInfectados.add(infectado04);
		listaInfectados.add(infectado05);
		listaInfectados.add(infectado06);		
		

	
		
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
		Random rd=new Random(); 	
		
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
