package Nivel;

import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;

//modern1
public class Nivel1 extends Lista_Nivel1{
	public Nivel1() {
		cantidad=new int[3];
		cantidad[0]=0;
		cantidad[1]=11;
		cantidad[2]=33;
		listaInfectados=new LinkedList<Entidad>();
		Infectado infectado06 = new InfectadoAlpha();
		infectado06.getEntidadGrafica().setX(310);
		infectado06.getEntidadGrafica().setY(80);
		Infectado infectado07 = new InfectadoAlpha();
		infectado07.getEntidadGrafica().setX(600);
		infectado07.getEntidadGrafica().setY(80);
		Infectado infectado08 = new InfectadoAlpha();
		infectado08.getEntidadGrafica().setX(310);
		infectado08.getEntidadGrafica().setY(67);
		Infectado infectado09 = new InfectadoAlpha();
		infectado09.getEntidadGrafica().setX(310);
		infectado09.getEntidadGrafica().setY(67);
		listaInfectados.add(infectado06);
		listaInfectados.add(infectado07);
		listaInfectados.add(infectado08);
		listaInfectados.add(infectado09);
		
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
	public void borrarLista() {
		// TODO Auto-generated method stub
		listaInfectados.clear();

	}
}