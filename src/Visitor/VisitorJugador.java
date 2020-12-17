package Visitor;

import Entidad.Jugador.Jugador;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.ProyectilVirusAlpha;
import Entidad.Proyectil.ProyectilVirusBeta;
import Premio.PremioDetener;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Premio.PremioVida;
import Entidad.Entidad;
import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class VisitorJugador extends Visitor {
	private Jugador j;

	public VisitorJugador(Jugador j) {
		this.j = j;	
	}

	@Override
	public void visitarJugador(Jugador j) {
		
	}

	

	@Override
	public void visitarArmaSanitaria(DisparoJugador d) {

	}

	@Override
	public void visitarVirusAlpha(ProyectilVirusAlpha v) {

	}

	@Override
	public void visitarPremioVida(PremioVida pv) {
		// TODO Auto-generated method stub
		//coger el premio
		j.setVitalactual(0);

	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha a) {
		// TODO Auto-generated method stub
		//no ataco a alpha porque el que ataca es la arma sanitaria
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta b) {
		// TODO Auto-generated method stub
		//no ataco a beta porque el que ataca es la arma sanitaria

	}

	@Override
	public void visitarVirusBeta(ProyectilVirusBeta v) {
		// TODO Auto-generated method stub
		
	}

	
	public void visitarPremioSuperArma(PremioSuperArma psa) {
		// TODO Auto-generated method stub
		System.out.println("tengo un premio de suerp arma");
		j.getDisparoJugador().getEntidadGrafica().getDibujo().repaint();
		j.getDisparoJugador().getEntidadGrafica().setImagen("img/jugador/ball.png");	
		j.setVelocidad(-50);
		j.getDisparoJugador().getDireccion().setDireccion(j.getDisparoJugador().getVelocidad());
		
	}

	
	public void visitarPremioVelocidad(PremioVelocidad pv) {
		
        Thread thread = new Thread() {
            @SuppressWarnings("deprecation")
         public void run() {
               j.setVelocidad(j.getVelocidad()+20);
               try {
                  this.sleep(5000);
                  j.setVelocidad(5);

             } catch (InterruptedException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }

            }

        };
        thread.start();
	}

	@Override
	public void visitarPremioDetener(PremioDetener p) {
		Thread thread = new Thread() {
            @SuppressWarnings("deprecation")
         public void run() {

        		for(Entidad ent:j.getelemQuietos())	
        		 {
        			 //a todos los infectados de la tanda actual seteo la velocidad en 0.
        			 ent.getDireccion().setDireccion(0);										 
        			 ent.mover(ent.getDireccion());
        			 ent.getEntidadGrafica().getDibujo().setLocation(ent.getEntidadGrafica().getX(),ent.getEntidadGrafica().getY());

        		 }

               try {
                  this.sleep(5000);

          		for(Entidad ent:j.getelemQuietos())	
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

	
}
