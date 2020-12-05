package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.Entidad;
import Entidad.Proyectil.Arma;
import Entidad.Proyectil.DisparoJugador;
import Main.WindowStage;
import Mapa.Mapa;
import Mapa.MapaProyectil;
import Premio.Premio;
import Premio.PremioDetener;
import Premio.PremioSuperArma;
import Premio.PremioVelocidad;
import Premio.PremioVida;
public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	private GUI gui;
	private List<Entidad> obj_eliminar;//Entidades que elimino

	private Mapa mapa;
	private MapaProyectil mapaVirus;	
	private MapaProyectil mapaMunicion;

	private Movimiento movimiento;
	
	private int tanda_actual=0;
	private int nivel_actual=0;	

	private List<List<Entidad>>[] tanda;
	
	private MapaProyectil lista_premio;
	private Random rd;
	
	public Juego(int tipoJugador){
	
		rd=new Random();
		obj_eliminar=new LinkedList<Entidad>();

		mapa = new Mapa();	
		mapa.getJugador().setTipoJugador(tipoJugador);	
		
		tanda=new List[2] ;
		tanda[0]  = mapa.crearTandaN1();		
		tanda[1]  = mapa.crearTandaN2();
		
		mapaVirus = new MapaProyectil();//virus
		mapaMunicion= new MapaProyectil() ;
		lista_premio=new MapaProyectil() ;

		mapa.getJugador().setMapaBalas(mapaMunicion);
		vinculargui();
		movimiento = new Movimiento(this);		
        start(); 
        movimiento.run();
	}
	
	

	private void start() {   	
        this.addKeyListener(this);
        if (mapa.getJugador().getTipoJugador()==1)		
    		mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/zakefrente.png");
    	else    	
    		mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliefrente.gif");
    	gui.agregarDibujoJugador(mapa.getJugador());




    }
	
	private void vinculargui() {
		gui = new GUI();
		gui.setVisible(true);
		this.add(gui);		
		this.setTitle("Zombielandia");		
        //this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);		
	}
	
	
	
	public void interactuar() {	
		
		this.requestFocus();

		
		
	if (nivel_actual==2)
	 {
		 //eliminar las balas de la gui y los virus
		
		 for(Entidad municion: mapaMunicion.getLista())
		 {
			 obj_eliminar.add(municion);
		 }
		 gui.eliminacion(obj_eliminar);
		 
		 for(Entidad virus: mapaVirus.getLista())
		 {
			 obj_eliminar.add(virus);
		 }
		 gui.eliminacion(obj_eliminar);
		 //falta eliminar premios 

		 mapaMunicion.getLista().clear();
		 mapaVirus.getLista().clear();
		 
		 for(Entidad objpremio:lista_premio.getLista()) {
			 obj_eliminar.add(objpremio);
			//lista de premios
		}
		 
		 obj_eliminar.add(mapa.getJugador());
		 gui.eliminacion(obj_eliminar);

		 
		 //gane todos los niveles	
		 ganoJuego();

		

			
	 }
	 
	 else 
	 {
		 if (tanda_actual==2)
			 { 	tanda_actual=0;
			 	nivel_actual=nivel_actual+1;
			 	//aca mostrar tanda 2
			 	
			 }
		 
		 
		 else 
		 {
				if(tanda[nivel_actual].get(tanda_actual).size()==0)
						{
							if (( (tanda_actual==1)&&(nivel_actual==0))||( (tanda_actual==0)&&(nivel_actual==1)) ||( (tanda_actual==0)&&(nivel_actual==0)))
							{
							this.setVisible(false);

							WindowStage ventana_stage = new WindowStage(nivel_actual,tanda_actual);
					 		ventana_stage.setVisible(true);
					 		
					 		try {
					 			Thread.sleep(4500);
					 		} catch (InterruptedException e) {
					 			e.printStackTrace();
					 		}
					 	
					 		ventana_stage.setVisible(false);
							this.setVisible(true);

					 		}
							tanda_actual=tanda_actual+1;
						}
				 
			
				if(tanda_actual<2)
				{
					
					if(mapa.getJugador().estaVivo()==false)
					{
						
						for(Entidad municion: mapaMunicion.getLista())
						 {
							 obj_eliminar.add(municion);
						 }
						 gui.eliminacion(obj_eliminar);
						 
						 for(Entidad objpremio:lista_premio.getLista()) {
							 obj_eliminar.add(objpremio);
							//lista de premios
						}
						 gui.eliminacion(obj_eliminar);

						 for(Entidad virus: mapaVirus.getLista())
						 {
							 obj_eliminar.add(virus);
							 
						 }
						 gui.eliminacion(obj_eliminar);
						 
						 for(Entidad infectados :  tanda[nivel_actual].get(tanda_actual)) 
						 {		
							 obj_eliminar.add(infectados);
						 }
						 gui.eliminacion(obj_eliminar);

						 obj_eliminar.add(mapa.getJugador());
						 gui.eliminacion(obj_eliminar);
						
						
						
						perdiJuego();
					}
					
					List<Entidad> lista_m = mapa.getJugador().detectarColisiones(lista_premio.getLista());
					if (lista_m.size()!=0)
					{
					
						//si hay una colision, acciono, luego elimino este premio
						//acciono
						mapa.getJugador().accionar(lista_premio.getLista());
						
						for(Entidad premio_m:lista_m)
						{
							obj_eliminar.add(premio_m);
							lista_premio.getLista().remove(premio_m);
						}
						gui.eliminacion(obj_eliminar);

						
					}
					
					
					
					
					 boolean enc=false;
					for(int j=0;enc==false&&j< tanda[nivel_actual].get(tanda_actual).size();j++) {		
						
						if (tanda[nivel_actual].get(tanda_actual).get(j).estaVivo()==false)
								{
								//"crear premios al azar"
								enc=true;
								int num_premio=rd.nextInt(4);
								Premio premio=null;
								if (num_premio==0)
								{
									premio= new PremioVida(tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());

								}
								if (num_premio==1)
								
								{	
									premio= new PremioSuperArma(tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());

								}
								
								if (num_premio==2)
									
								{	

									premio= new PremioVelocidad(tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());

								}
																
								if (num_premio==3)
									
								{	
									
									
									premio= new PremioDetener(tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());
									 
									 mapa.getJugador().setelemQuietos(tanda[nivel_actual].get(tanda_actual));
									 
									
									 
								}
								
								 obj_eliminar.add(tanda[nivel_actual].get(tanda_actual).get(j));
									
								

								tanda[nivel_actual].get(tanda_actual).remove(j);
   
								gui.agregarDibujo(premio);
								lista_premio.ponerBalasEnLista(premio);
								
								
//							
							
								
								
								
								

								
								
								}
					 }	
					gui.eliminacion(obj_eliminar);

					for(Entidad objpremio:lista_premio.getLista()) {
							//pero tambien me acepto a mi

						objpremio.getDireccion().setDireccion(objpremio.getVelocidad()) ;			
						objpremio.mover(objpremio.getDireccion());
						
						//lista de premios

						
					}
					
										
				
					
					for(int i=0;i< mapaMunicion.getLista().size()-1;i++) 		
					{
						//de municiones de jugador
						mapaMunicion.getLista().get(i).mover(mapaMunicion.getLista().get(i).getDireccion());
						
					}
					
					
					
					
					
					//elimino las municiones
					for(int i=0;i< mapaMunicion.getLista().size();i++) { 		
						if (mapaMunicion.getLista().get(i).getEntidadGrafica().getDibujo().getY()==0)
								obj_eliminar.add(mapaMunicion.getLista().get(i));
					 }
						
						
		
				
					//hacer que las virus se muevan
				
					gui.estadoVida(mapa.getJugador().getVitalactual());
			
					
					for(Entidad virus : mapaVirus.getLista()) 			
					{
						if (virus.getEntidadGrafica().getDibujo()==null)
							gui.agregarDibujo(virus);
						virus.mover(virus.getDireccion());
					}
						
					
					
					
					for(Entidad infect : tanda[nivel_actual].get(tanda_actual))		
					{
						
						infect.setMapaBalas(mapaVirus);	
					}
					//tandas_nivel1[nivel_actual].get(tanda_actual).clear();
						
			


					mapa.getJugador().accionar(tanda[nivel_actual].get(tanda_actual));
					mapa.getJugador().accionar(mapaVirus.getLista());

					
				
						
				
					
					for(Entidad obj :  tanda[nivel_actual].get(tanda_actual)) {		
						
					 //cada infectado con lista municion
						if (obj.getEntidadGrafica().getDibujo()==null)
								{gui.agregarDibujo(obj);
								 
								}
						obj.accionar(mapaMunicion.getLista());	
						obj.mover(obj.getDireccion());//muevo a infectado
					}
					
					
				}
				 
					
				
				
				
			
					
				
			
				
				
					
					
				
				
		
		 }
					
	
	
			
	 }
		
	
	}	
	
	

	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {

			case KeyEvent.VK_LEFT: {
				
				if (mapa.getJugador().getTipoJugador()==1)				
					mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/zakeizquierda.gif");
		    	else		    	
					mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/julieizquierda.gif");

		        gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());
				//mapa.getJugador().setVelocidad(MovimientoHorizontal.IZQUIERDA );
				int nuevavelocidad=mapa.getJugador().getVelocidad();
		        if (nuevavelocidad<0)
		        	nuevavelocidad=nuevavelocidad*(-1);
		        mapa.getJugador().setVelocidad(nuevavelocidad);

				mapa.getJugador().getDireccion().setDireccion(mapa.getJugador().getVelocidad() );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());
			
				
	        	break;
			}
			case KeyEvent.VK_RIGHT: {
				
				if (mapa.getJugador().getTipoJugador()==1)				
					mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/zakederecha.gif");
		    	else
		    		mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliederecha.gif");
				
				gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
				//mapa.getJugador().setVelocidad(MovimientoHorizontal.DERECHA);
				
				int nuevavelocidad=mapa.getJugador().getVelocidad();
		        if (nuevavelocidad> 0)
		        	nuevavelocidad=nuevavelocidad*(-1);
		        mapa.getJugador().setVelocidad(nuevavelocidad);

				
				mapa.getJugador().getDireccion().setDireccion(mapa.getJugador().getVelocidad() );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());

				
	        	break;
			}
			case KeyEvent.VK_SPACE: {
				if( (nivel_actual<2)&&(mapa.getJugador().estaVivo()==true))
				 {	
					if (mapa.getJugador().getTipoJugador()==1)					
						mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/zakefrente.png");
			    	else			    	
						mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliefrente.gif");
	
			    	
						gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
						Arma arma=new Arma();
						DisparoJugador disparo = arma.crearArmaBasica(mapa.getJugador().getEntidadGrafica().getDibujo().getX(),mapa.getJugador().getEntidadGrafica().getDibujo().getY());
						disparo.getEntidadGrafica().setX(mapa.getJugador().getEntidadGrafica().getDibujo().getX());
						disparo.getEntidadGrafica().setY(mapa.getJugador().getEntidadGrafica().getDibujo().getY());
						
						if(mapa.getJugador().getTipoArma()!=0)						
						{				
							disparo.getEntidadGrafica().setImagen("img/jugador/ball.png");
							gui.agregarDibujo(disparo);				
							mapaMunicion.ponerBalasEnLista(disparo);
							disparo.setVelocidad(-50);
							disparo.getDireccion().setDireccion(disparo.getVelocidad()) ;
	
						}
						else
						{
							gui.agregarDibujo(disparo);				
							mapaMunicion.ponerBalasEnLista(disparo);
						}
				 }
									
				break;
			}
		
		
		
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//this.interactuar();

		
	}
	
	
	private void ganoJuego() {
		movimiento.setDeboMover(false);
		gui.gameWin(this);		
	}
	
	private void perdiJuego() {
		movimiento.setDeboMover(false);
		gui.gameYouLose(this,mapa.getJugador().getTipoJugador());

	
	}
}

