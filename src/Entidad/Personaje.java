package Entidad;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import EstrategiaMovimiento.EstrategiaMovimiento;

public abstract class Personaje extends Entidad {
	
	protected Personaje(int cargaViralActual) {
		super();
		this.cargaViralActual = cargaViralActual; 
				
	}	
		
	//agrega visitor a personaje y a las entidades que colisiona
	@Override
	public void accionar(List<Entidad>entidad) {
		// TODO Auto-generated method stub
		List<Entidad> listaEntidad = detectarColisiones(entidad);		
		for (Entidad obj:listaEntidad)
			{	obj.accept(visitor);
				this.accept(obj.getVisitor());	
		
			}		
	}
	
	@Override
	//personaje detecta con quienes colisiona de la lista de entidad
	public List<Entidad> detectarColisiones(List<Entidad>entidad) {
		// TODO Auto-generated method stub		
		List<Entidad> conj_infectados  = new LinkedList<Entidad>();
		Rectangle tamanioObj = getEntidadGrafica().getDibujo().getBounds();
		for(Entidad ent:entidad)
		{
			if(ent.getEntidadGrafica().getDibujo()!=null)
				if(ent.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
					conj_infectados.add(ent);
		}
		
		return conj_infectados;
	}
	
}
