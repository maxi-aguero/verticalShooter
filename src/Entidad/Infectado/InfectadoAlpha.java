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
		entidadgrafica.setImagen("img/infectados/zombie.gif");
		resistencia=24;
	}


	//condicion de vida del infectado
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;
	}


	//el visitor v visita al infectado alpha
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarInfectadoAlpha(this);
	}



	//El infectado alpha detecta con quienes colisiona de la lista de entidad
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


//agrega visitor a infectado alpha y a las entidades que colisiona
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
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		iniciarAtaque(obj);
		
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
