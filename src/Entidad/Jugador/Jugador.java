package Entidad.Jugador;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidad.Entidad;
import Entidad.Personaje;
import EstrategiaMovimiento.EstrategiaMovimiento;
import EstrategiaMovimiento.MovimientoHorizontal;
import Premio.PremioDetener;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Personaje {
	protected int tipoArma;
	protected int tipoJugador;
	protected List<Entidad> elemQuietos;
	
	public Jugador() {		
		super(0); 
		visitor = new VisitorJugador(this);				
		direccion = new MovimientoHorizontal(this,1);				
		entidadgrafica.setX(50);
		entidadgrafica.setY(420);
		rango_x=35;
		velocidad=5;
		tipoArma=0;

	}
	
	public int getTipoArma() {
		return tipoArma;
	}
	
	public int getTipoJugador() {
		return tipoJugador;
	}
	
	public void setTipoJugador(int t) {
		tipoJugador=t;
	}

	//el visitor v visita a Jugador
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarJugador(this);

	}
	
	//nuevo al jugador a cierta direccion
	@Override
	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub

		d.mover();
	}

//setea la carga viral actual en 0, cuando ha agarrado un premio vida	
	public void cogerPremioVida(Entidad obj) {
		// TODO Auto-generated method stub
		cargaViralActual=0;		
	}
//cuando ha agarrado un premio SuperArma setea el arma en tipo 1( que es una SuperArma)
	public void cogerPremioSuperArma(PremioSuperArma obj) {
		// TODO Auto-generated method stub
		tipoArma=1;		
	}
	
	public void settipoArma(int t) {
		tipoArma=t;
	}
	
	
	@Override
	public void atacar(Entidad obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub 
		
	}

	//condicion de vida de Jugador
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
	}


	@Override
	//Jugador detecta con quienes colisiona de la lista de entidad
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
	
	//recibo entidades y me fijo si colisionan
	@Override
	public void accionar(List<Entidad>entidad) {
		// TODO Auto-generated method stub
		List<Entidad> ListaEntidad = detectarColisiones(entidad);
		for (Entidad obj:ListaEntidad)
			{	obj.accept(visitor);				
				this.accept(obj.getVisitor());	
			}
	}
	
	//setea la velocidad de Jugador si ha agarrado un PremioVelocidad
	public void cogerPremioVelocidad(PremioVelocidad p) {		 

         Thread thread = new Thread() {
             @SuppressWarnings("deprecation")
          public void run() {
                velocidad=velocidad+20;
                try {
                   this.sleep(5000);
                   velocidad=5;

              } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }

             }

         };
         thread.start();

    }
	
	
	//setea la velocidad de una lista de Entidad si ha agarrado un PremioDetener
	public void setelemQuietos(List<Entidad> listaEntidad) {
		elemQuietos=listaEntidad;
	}
	
	public void cogerPremioQuieto(PremioDetener p) {
		 
		Thread thread = new Thread() {
            @SuppressWarnings("deprecation")
         public void run() {

        		for(Entidad ent:elemQuietos)	
        		 {
        			 //a todos los infectados de la tanda actual seteo la velocidad en 0.
        			 ent.getDireccion().setDireccion(0);										 
        			 ent.mover(ent.getDireccion());
        			 ent.getEntidadGrafica().getDibujo().setLocation(ent.getEntidadGrafica().getX(),ent.getEntidadGrafica().getY());

        		 }

               try {
                  this.sleep(5000);

          		for(Entidad ent:elemQuietos)	
          		 {
          			 ent.getDireccion().setDireccion(5);										 
          			 ent.mover(ent.getDireccion());
          		 }

             } catch (InterruptedException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }

            }

        };
        thread.start();
		
		
		
		
		
	}
	@Override
	public void AumentarVelocidad() {
		// TODO Auto-generated method stub
		
	}



	

}
