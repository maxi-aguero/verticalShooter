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
		resistencia=0.54;
	}

	//condicion de vida del infectado
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;
	}



	//el visitor v visita al infectado beta
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoBeta(this);
	}


	//El infectado beta detecta con quienes colisiona de la lista de entidad
	@Override
	public List<Entidad> detectarColisiones(List<Entidad>entidad) {
		// TODO Auto-generated method stub
		List<Entidad> conj_municiones  = new LinkedList<Entidad>();
		Rectangle tamanioObj = getEntidadGrafica().getDibujo().getBounds();
		tamanioObj.translate(- 0,0);
		tamanioObj.width += 0;
		for(Entidad obj:entidad)
		{
			if(obj.getEntidadGrafica().getDibujo()!=null)
				if(obj.getEntidadGrafica().getDibujo().getBounds().intersects(tamanioObj))
					conj_municiones.add(obj);
		}
		
		return conj_municiones;
		
	}

//agrega visitor a el infectado beta y a las entidades que colisiona
	@Override
	public void accionar(List<Entidad>entidad) {
		// TODO Auto-generated method stub
		List<Entidad> listaEntidad = detectarColisiones(entidad);
		
		//solo los veo
		for (Entidad obj:listaEntidad)
			{	obj.accept(visitor);
				this.accept(obj.getVisitor());	
			}
		
	}



	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		iniciarAtaque(obj);
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
