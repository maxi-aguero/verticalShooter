package Entidad.Infectado;


import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Proyectil.Proyectil;
import Entidad.Proyectil.ProyectilVirusAlpha;
import Entidad.Proyectil.ProyectilVirusBeta;
import EstrategiaMovimiento.MovimientoVerticalDeInfectado;
import Visitor.Visitor;
import Visitor.VisitorInfectadoAlpha;
import Visitor.VisitorInfectadoBeta;

public class InfectadoBeta extends Infectado {
		
	public InfectadoBeta() {
		super(100, 0, 5); 
		visitor = new VisitorInfectadoBeta(this);	
		velocidad=5;
		direccion = new MovimientoVerticalDeInfectado(this,velocidad);		
		entidadgrafica.setImagen("img/infectados/stanley.gif");
		velocidad=5;
		resistencia=1.9;
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
		Proyectil disparo = new ProyectilVirusBeta(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		disparo.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX());
		disparo.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		
		Proyectil disparo1 = new ProyectilVirusBeta(this.getEntidadGrafica().getDibujo().getX()-15,this.getEntidadGrafica().getDibujo().getY());
		disparo1.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX()-15);
		disparo1.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		Proyectil disparo2 = new ProyectilVirusBeta(this.getEntidadGrafica().getDibujo().getX()+15,this.getEntidadGrafica().getDibujo().getY());
		disparo2.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX()+15);
		disparo2.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		//mapabalasgui.ponerBalasEnLista(disparo);
		//mapabalasgui.ponerBalasEnLista(disparo1);
		//mapabalasgui.ponerBalasEnLista(disparo2);
		mapaProyectil.ponerBalasEnLista(disparo);
		mapaProyectil.ponerBalasEnLista(disparo1);
		mapaProyectil.ponerBalasEnLista(disparo2);
		
		
		//punto== entidgrad grafica, hacer setx, sety
		//Punto p = new Punto(punto.getX()-disparo.getAncho()+10, punto.getY());
		//disparo.setPunto()
		//mapa lista_a_agregar significa la lista que se genera de manera dinamica
		//mapa.add(disparo); meto disparo en mapa
		
		/**ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		Disparo disparo = new DisparoEnemigo(danio, null, rango);
		Punto p = new Punto(punto.getX()-disparo.getAncho()+10, punto.getY());
		disparo.setPunto(p);
		mapa.add(disparo);*/	
	}
	




	

}
