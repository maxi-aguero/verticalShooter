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

	private Mapa mapa;//guarda infectados y al jugador	
	private MapaProyectil mapaVirus; 	//lugar donde guardo los virus
	private MapaProyectil mapaMunicion;//lugar donde guardo las municiones del jugador
	private MapaProyectil lista_premio;//lugar donde guardo los premios

	private Movimiento movimiento;
	
	private int tanda_actual=0;
	private int nivel_actual=0;	

	private List<List<Entidad>>[] nivel;
	
	private Random rd;
	
	public Juego(int tipoJugador){	
		rd=new Random();
		obj_eliminar=new LinkedList<Entidad>();
		iniciarMapa();		
		vinculargui();
		movimiento = new Movimiento();		
		this.addKeyListener(this);
		iniciarJugador(tipoJugador); 
        movimiento.run(this);//se lanza el moviento en juego
	}
		
	private void iniciarMapa() {
		mapa = new Mapa();		
		nivel=new List[2] ;//creo dos niveles 
		nivel[0]  = mapa.crearTandasN1();//a cada nivel le agrego dos tandas
		nivel[1]  = mapa.crearTandasN2();
		mapaVirus = new MapaProyectil();
		lista_premio=new MapaProyectil();
	}

	private void iniciarJugador(int tipoJugador) {   	
		mapa.getJugador().setTipoJugador(tipoJugador);	
		mapaMunicion= new MapaProyectil();
		mapa.getJugador().setMapaBalas(mapaMunicion);//al jugador le vinculo el lugar donde guarda las municiones 
        if (mapa.getJugador().getTipoJugador()==1)		
    		mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/zakefrente.png");
    	else    	
    		mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliefrente.gif");
    	gui.agregarJugador(mapa.getJugador());
    }
	
	private void vinculargui() {
		gui = new GUI();
		gui.setVisible(true);
		this.add(gui);		
		this.setTitle("Zombielandia");		
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);		
	}
	
	
	
	public void interactuar() {	
		
		this.requestFocus();		
		
		if (nivel_actual==2)
		 		 ganoJuego();
	
		 else 
		 {
			 if (tanda_actual==2)
				 { 	tanda_actual=0;
				 	nivel_actual=nivel_actual+1;				 	
				 }			 
			 
			 else 
			 {
				
				 
					if(nivel[nivel_actual].get(tanda_actual).size()==0)//ESTO SIGNIFICA QUE GANE UNA TANDA
					  {						
							if (( (tanda_actual==1)&&(nivel_actual==0))||( (tanda_actual==0)&&(nivel_actual==1)) ||( (tanda_actual==0)&&(nivel_actual==0)))
								{
									//Muestro un frame que pase de tanda	
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
						
						if(mapa.getJugador().estaVivo()==false)//SI EL JUGADOR ESTA MUERTO
							 perdiJuego();
						
						
						
						List<Entidad> lista_m = mapa.getJugador().detectarColisiones(lista_premio.getLista());
						if (lista_m.size()!=0)//conjunto de premios que tengo en juego
						{
												
							mapa.getJugador().accionar(lista_premio.getLista()); //jugador acciona a premios porque lo acabo de agarrrar
														
							//si ya agarre el premio, al premio lo elimino de la gui
							for(Entidad premio_m:lista_m)
							{
								obj_eliminar.add(premio_m);
								lista_premio.getLista().remove(premio_m);
							}
							gui.eliminarEntidades(obj_eliminar);
	
							
						}
						
						//si es infectado alpha y si tiene menos de 20% de vida, le aumento la velociodad
						for(int j=0;j< nivel[nivel_actual].get(tanda_actual).size();j++) {		
							nivel[nivel_actual].get(tanda_actual).get(j).AumentarVelocidad();						
						}
						
						
						//SI ENCUENTRO A UN INFECTADO QUE SE MURIO
						boolean enc=false;
						for(int j=0;enc==false&&j< nivel[nivel_actual].get(tanda_actual).size();j++) {						
							
							if (nivel[nivel_actual].get(tanda_actual).get(j).estaVivo()==false)//SI UN INFECTADO ESTA MUERTO
							  {
									enc=true;
									int num_premio=rd.nextInt(2);//Otorgo un premio al azar
									Premio premio=null;
									if (num_premio==0)
									{
										premio= new PremioVida(nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());
	
									}
									if (num_premio==1)
									
									{	
										premio= new PremioSuperArma(nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());
	
									}
									
									if (num_premio==2)
										
									{	
	
										premio= new PremioVelocidad(nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());
	
									}
																	
									if (num_premio==3)
										
									{					
										premio= new PremioDetener(nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),nivel[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());
										//a jugador le aviso que jugadores cuales infectados son los actuales y los setea quietos por un tiempo 
										mapa.getJugador().setelemQuietos(nivel[nivel_actual].get(tanda_actual));
										 
									}
									//elimino de la gui al infectado muerto
									obj_eliminar.add(nivel[nivel_actual].get(tanda_actual).get(j));				
									//elimino al infectado muerto de la tanda
									nivel[nivel_actual].get(tanda_actual).remove(j);
	   
									
									gui.agregarEntidad(premio);
									lista_premio.ponerEnLista(premio);
	
									
									
								}
						 }//end del for
						
						gui.eliminarEntidades(obj_eliminar);
	
						
						
						//a cada premio le asigno movimiento
						for(Entidad objpremio:lista_premio.getLista()) {	
							objpremio.getDireccion().setDireccion(objpremio.getVelocidad()) ;			
							objpremio.mover(objpremio.getDireccion());
						}
						
											
					
						//a cada municion del jugador le asigno movimiento
						for(int i=0;i< mapaMunicion.getLista().size()-1;i++) 		
						{
							mapaMunicion.getLista().get(i).mover(mapaMunicion.getLista().get(i).getDireccion());
							
						}
						
						
						//a cada municion del jugador que llegue a la posicion superior la elimino
						for(int i=0;i< mapaMunicion.getLista().size();i++) { 		
							if (mapaMunicion.getLista().get(i).getEntidadGrafica().getDibujo().getY()==0)
									obj_eliminar.add(mapaMunicion.getLista().get(i));
						}				
			
					
						//muestra el estado actual de la vida del jugador
						gui.estadoVida(mapa.getJugador().getVitalactual());
				
						//a cada virus le asigno movimiento
						for(Entidad virus : mapaVirus.getLista()) 			
						{
							if (virus.getEntidadGrafica().getDibujo()==null)
								gui.agregarEntidad(virus);//agrego el virus por a la gui 
							virus.mover(virus.getDireccion());
						}
							
						
						//le asigno  a los infectados un lugar para que guarde los virus que lanza
						for(Entidad infect : nivel[nivel_actual].get(tanda_actual))		
						{
							infect.setMapaBalas(mapaVirus);	
						}
							
				
	
						//el jugador acciona con los infectados y los virus
						mapa.getJugador().accionar(nivel[nivel_actual].get(tanda_actual));
						mapa.getJugador().accionar(mapaVirus.getLista());
	
						
					
							
					
						//para cada infectado si lo agrego a gui, y lo acciono con el jugador y le doy un movimiento
						for(Entidad infectado :  nivel[nivel_actual].get(tanda_actual)) {		
							
							if (infectado.getEntidadGrafica().getDibujo()==null)
									{gui.agregarEntidad(infectado);
									 
									}
							infectado.accionar(mapaMunicion.getLista());	
							infectado.mover(infectado.getDireccion());
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
						mapa.getJugador().setArma(arma);
						DisparoJugador disparo = mapa.getJugador().getDisparoJugador();
						
						disparo.getEntidadGrafica().setX(mapa.getJugador().getEntidadGrafica().getDibujo().getX());
						disparo.getEntidadGrafica().setY(mapa.getJugador().getEntidadGrafica().getDibujo().getY());
						
						gui.agregarEntidad(disparo);				
						mapaMunicion.ponerEnLista(disparo);
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
		//Elimino todas las entidades que quedaron en juego
		
		for(Entidad municion: mapaMunicion.getLista())
		 {
			 obj_eliminar.add(municion);
		 }
		gui.eliminarEntidades(obj_eliminar);
		 
		 for(Entidad virus: mapaVirus.getLista())
		 {
			 obj_eliminar.add(virus);
		 }
		gui.eliminarEntidades(obj_eliminar);

		mapaMunicion.getLista().clear();
		mapaVirus.getLista().clear();
		 
		for(Entidad objpremio:lista_premio.getLista()) {
			 obj_eliminar.add(objpremio);
		}
		 
		obj_eliminar.add(mapa.getJugador());
		gui.eliminarEntidades(obj_eliminar);

		
		movimiento.setDeboMover(false);
		gui.gameWin(this);	//gui muestra que gane el juego 	
	}
	
	private void perdiJuego() {
		
		for(Entidad municion: mapaMunicion.getLista())
		 {
			 obj_eliminar.add(municion);
		 }
		gui.eliminarEntidades(obj_eliminar);
		 
		for(Entidad objpremio:lista_premio.getLista()) {
			 obj_eliminar.add(objpremio);
		}
		gui.eliminarEntidades(obj_eliminar);

		for(Entidad virus: mapaVirus.getLista())
		 {
			 obj_eliminar.add(virus);
			 
		 }
		gui.eliminarEntidades(obj_eliminar);
		 
		for(Entidad infectados :  nivel[nivel_actual].get(tanda_actual)) 
		 {		
			 obj_eliminar.add(infectados);
		 }
		gui.eliminarEntidades(obj_eliminar);

		obj_eliminar.add(mapa.getJugador());
		gui.eliminarEntidades(obj_eliminar);
		
		movimiento.setDeboMover(false);
		gui.gameYouLose(this,mapa.getJugador().getTipoJugador());

	
	}
}

