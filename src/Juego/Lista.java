package Juego;

import java.util.List;

import Entidad.Entidad;

public abstract class Lista {
	public int [] cantidad;
	public List<Entidad> listaInfectados;
	
	protected abstract List<Entidad> getLista();
	protected abstract int[] getCantidad();
	protected abstract void borrarLista();


}
