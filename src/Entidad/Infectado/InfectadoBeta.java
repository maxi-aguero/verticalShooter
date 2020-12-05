package Entidad.Infectado;


import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Proyectil.Proyectil;
import Entidad.Proyectil.ProyectilVirusBeta;
import EstrategiaMovimiento.MovimientoVerticalDeInfectado;
import Visitor.Visitor;
import Visitor.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {
		
	public InfectadoBeta() {
		super(100); 
		visitor = new VisitorInfectadoBeta(this);	
		velocidad=5;
		direccion = new MovimientoVerticalDeInfectado(this,velocidad);		
		entidadgrafica.setImagen("img/infectados/stanley.gif");
		velocidad=5;
		resistencia=60;
	}



	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;
	}




	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoBeta(this);
	}



	
	@Override
	public List<Entidad> detectarColisiones(List<Entidad>municiones) {
		// TODO Auto-generated method stub
		//yo como entidad(infectado alpha a quien me choco?)
		//me choco a un jugador, entonces hago un detectar colisionJugador privado
		List<Entidad> conj_municiones  = new LinkedList<Entidad>();
		Rectangle tamanioObj = getEntidadGrafica().getDibujo().getBounds();
		tamanioObj.translate(- 0,0);
		tamanioObj.width += 0;
		for(Entidad ent:municiones)
		{
			if(ent.getEntidadGrafica().getDibujo()!=null)
				if(ent.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
					conj_municiones.add(ent);
		}
	
			
		
		return conj_municiones;
		
	}



	@Override
	public void accionar(List<Entidad>municiones) {
		// TODO Auto-generated method stub
		List<Entidad> c = detectarColisiones(municiones);
		
		//solo los veo
		for (Entidad minimunicion:c)
			{	minimunicion.accept(visitor);
				this.accept(minimunicion.getVisitor());	//pero tambien me acepto a mi


				//yo como jugador no quiero disparar, disparo solo cuando presiono space
			}
		
	}



	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		//System.out.println("pium virus");
		iniciarAtaque(obj);
		
		/**ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco
			if(frecuencia_ataques%velocidad_ataque == 0)
				iniciarAtaque(obj);
			frecuencia_ataques++;
		} else
			morir();*/
	}


	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		Proyectil virusBeta01 = new ProyectilVirusBeta(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		virusBeta01.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX());
		virusBeta01.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		
		Proyectil virusAlpha01 = new ProyectilVirusBeta(this.getEntidadGrafica().getDibujo().getX()-15,this.getEntidadGrafica().getDibujo().getY());
		virusAlpha01.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX()-15);
		virusAlpha01.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		Proyectil virusAlpha02 = new ProyectilVirusBeta(this.getEntidadGrafica().getDibujo().getX()+15,this.getEntidadGrafica().getDibujo().getY());
		virusAlpha02.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX()+15);
		virusAlpha02.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		ListaDeProyectil.ponerBalasEnLista(virusBeta01);
		ListaDeProyectil.ponerBalasEnLista(virusAlpha01);
		ListaDeProyectil.ponerBalasEnLista(virusAlpha02);
		
		
			
	}







	

}
