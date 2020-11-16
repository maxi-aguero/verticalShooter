package Juego;

import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

//modern1
public class Nivel2 extends Lista_Nivel2{
	protected Nivel2() {
		cantidad=new int[3];
		cantidad[0]=0;
		cantidad[1]=10;
		cantidad[2]=30;
		
		listaInfectados=new LinkedList<Entidad>();
		
		Infectado infectado01 = new InfectadoBeta();
		infectado01.getEntidadGrafica().setX(90);
		infectado01.getEntidadGrafica().setY(140);
		
		Infectado infectado03 = new InfectadoBeta();
		infectado03.getEntidadGrafica().setX(180);
		infectado03.getEntidadGrafica().setY(140);
		

		
		
		
		listaInfectados.add(infectado01);	
		listaInfectados.add(infectado03);	

		
	}
	@Override
	public List<Entidad> getLista() {
		// TODO Auto-generated method stub
		return listaInfectados;
	}
	@Override
	public int[] getCantidad() {
		// TODO Auto-generated method stub
		return cantidad;
	}
	@Override
	protected void borrarLista() {
		// TODO Auto-generated method stub
		listaInfectados.clear();
		
	}
}
