package Nivel;

import java.util.List;

import Entidad.Entidad;

public abstract class Lista {
	protected int [] cantidad;
	protected List<Entidad> listaInfectados;
	
	public abstract List<Entidad> getLista();


}
