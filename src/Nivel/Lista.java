package Nivel;

import java.util.List;

import Entidad.Entidad;

public abstract class Lista {
	protected List<Entidad> listaInfectados;
	protected Factory[] miFabrica;
	
	public abstract List<Entidad> getLista();


}
