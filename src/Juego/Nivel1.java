package Juego;

import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;

//modern1
public class Nivel1 extends Lista_Nivel1{
	protected Nivel1() {
		cantidad=new int[3];
		cantidad[0]=0;
		cantidad[1]=11;
		cantidad[2]=33;
		listaInfectados=new LinkedList<Entidad>();
		Infectado infectado06 = new InfectadoAlpha();
		infectado06.setX(610);
		infectado06.setY(80);
		Infectado infectado07 = new InfectadoAlpha();
		infectado07.setX(410);
		infectado07.setY(67);
		Infectado infectado08 = new InfectadoAlpha();
		infectado08.setX(310);
		infectado08.setY(67);
		Infectado infectado09 = new InfectadoAlpha();
		infectado09.setX(310);
		infectado09.setY(67);
		listaInfectados.add(infectado06);
		listaInfectados.add(infectado07);
		listaInfectados.add(infectado08);
		listaInfectados.add(infectado09);
		
	}
	@Override
	protected List<Entidad> getLista() {
		// TODO Auto-generated method stub
		return listaInfectados;
	}
	@Override
	protected int[] getCantidad() {
		// TODO Auto-generated method stub
		return cantidad;
	}
	@Override
	protected void borrarLista() {
		// TODO Auto-generated method stub
		listaInfectados.clear();

	}
}
