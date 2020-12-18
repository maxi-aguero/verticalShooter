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
		entidadGrafica.setImagen("img/infectados/stanley.gif");
		velocidad=5;
		resistencia=0.54;
	}	

	//el visitor v visita al infectado beta
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoBeta(this);
	}

	//crea y guarda los virus que lanza el infectado
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
		
		ListaDeProyectil.ponerEnLista(virusBeta01);
		ListaDeProyectil.ponerEnLista(virusAlpha01);
		ListaDeProyectil.ponerEnLista(virusAlpha02);	
			
	}	

	@Override
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		
	}
	

}
