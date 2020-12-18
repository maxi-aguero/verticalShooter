package Entidad.Infectado;


import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Proyectil.Proyectil;
import Entidad.Proyectil.ProyectilVirusAlpha;
import EstrategiaMovimiento.MovimientoVerticalDeInfectado;
import Visitor.Visitor;
import Visitor.VisitorInfectadoAlpha;

public class InfectadoAlpha extends Infectado {
		
	public InfectadoAlpha() {
		super(100);
		visitor = new VisitorInfectadoAlpha(this);
		velocidad=5;
		direccion = new MovimientoVerticalDeInfectado(this,velocidad);		
		entidadGrafica.setImagen("img/infectados/zombie.gif");
		resistencia=24;
	}

	//el visitor v visita al infectado alpha
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoAlpha(this);
	}

	//crea y guarda los virus que lanza el infectado
	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		Proyectil virusAlpha01 = new ProyectilVirusAlpha(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		virusAlpha01.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX());
		virusAlpha01.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		
		Proyectil virusAlpha02 = new ProyectilVirusAlpha(this.getEntidadGrafica().getDibujo().getX()-15,this.getEntidadGrafica().getDibujo().getY());
		virusAlpha02.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX()-15);
		virusAlpha02.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		Proyectil virusAlpha03 = new ProyectilVirusAlpha(this.getEntidadGrafica().getDibujo().getX()+15,this.getEntidadGrafica().getDibujo().getY());
		virusAlpha03.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX()+15);
		virusAlpha03.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		
		ListaDeProyectil.ponerEnLista(virusAlpha01);
		ListaDeProyectil.ponerEnLista(virusAlpha02);
		ListaDeProyectil.ponerEnLista(virusAlpha03);		
		
	}

	//aumenta la velocidad del infecado alpha cuando su vida es menor del 20%
	@Override
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		if (cargaViralActual<20)			
			direccion.setDireccion(8);	
	}

	
}
