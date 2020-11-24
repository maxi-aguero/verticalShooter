package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Proyectil.Arma;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.Proyectil;
import EstrategiaMovimiento.MovimientoHorizontal;
import Mapa.Mapa;
import Mapa.MapaProyectil;
import Premio.Premio;
import Premio.PremioSuperArma;
import Premio.PremioVida;
public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	protected GUI gui;
	protected List<Entidad> obj_eliminar;//infectados que elimino

	protected Mapa mapa;
	protected MapaProyectil mapaVirus;	
	protected MapaProyectil mapaMunicion;

	protected Movimiento movimiento;
	
	protected int tanda_actual=0;
	protected int nivel_actual=0;	

	protected List<List<Entidad>>[] tanda;
	
	protected MapaProyectil lista_premio;
	protected Random rd;
	
	public Juego(){
	
		rd=new Random();
		obj_eliminar=new LinkedList<Entidad>();
		
		mapa = new Mapa();	
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
	
	
	
	//Nivel 1
	public void interactuar() {			
		this.requestFocus();

        //gui.ponerProgressBar(tanda[nivel_actual].get(tanda_actual).size());

		
		
	 if (nivel_actual==2)
	 {
		 //eliminar las balas de la gui y los virus
		
		 for(Entidad municion: mapaMunicion.getListaBalas())
		 {
			 obj_eliminar.add(municion);
		 }
		 gui.eliminacion(obj_eliminar);
		 
		 for(Entidad virus: mapaVirus.getListaBalas())
		 {
			 obj_eliminar.add(virus);
		 }
		 gui.eliminacion(obj_eliminar);
		 //falta eliminar premios 

		 mapaMunicion.getListaBalas().clear();
		 mapaVirus.getListaBalas().clear();
		 
		 System.out.println("gane todos los niveles");	 
		
			
	 }
	 
	 else 
	 {
		 if (tanda_actual==2)
			 { 	tanda_actual=0;
			 	nivel_actual=nivel_actual+1;			 
			 }
		 
		 
		 else 
		 {
				if(tanda[nivel_actual].get(tanda_actual).size()==0)
						tanda_actual=tanda_actual+1;
				 
			
				if(tanda_actual<2)
				{
					
					
					List<Entidad> lista_m = mapa.getJugador().detectarColisiones(lista_premio.getListaBalas());
					if (lista_m.size()!=0)
					{
					
						//si hay una colision, acciono, luego elimino este premio
						//acciono
						mapa.getJugador().accionar(lista_premio.getListaBalas());
						
						for(Entidad premio_m:lista_m)
						{
							obj_eliminar.add(premio_m);
							lista_premio.getListaBalas().remove(premio_m);
						}
						gui.eliminacion(obj_eliminar);

						
					}
					
					
					
					
					 boolean enc=false;
					for(int j=0;enc==false&&j< tanda[nivel_actual].get(tanda_actual).size();j++) {		
						
						if (tanda[nivel_actual].get(tanda_actual).get(j).estaVivo()==false)
								{
								//"crear premios al azar"
								
								obj_eliminar.add(tanda[nivel_actual].get(tanda_actual).get(j));
								//creo premio vida
								enc=true;
								int num_premio=rd.nextInt(2);
								System.out.println(num_premio);
								Premio recupera_vida_x=null;
								if (num_premio==0)
								{
									 recupera_vida_x= new PremioVida(tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());

								}
								if (num_premio==1)
								
								{
									 recupera_vida_x= new PremioSuperArma(tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tanda[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());

								}
								
								if (num_premio==2)
									
								{	// premio temporal velocidad del jugador

								}
								
								if (num_premio==3)
									
								{	// premio movimiento de infectados temporal

								}
								
								
								tanda[nivel_actual].get(tanda_actual).remove(j);

								gui.agregarDibujo(recupera_vida_x);
								lista_premio.ponerBalasEnLista(recupera_vida_x);
								
								
								
								
								

								
								
								}
					 }	
					gui.eliminacion(obj_eliminar);

					for(Entidad objpremio:lista_premio.getListaBalas()) {
							//pero tambien me acepto a mi

						objpremio.getDireccion().setDireccion(objpremio.getVelocidad()) ;			
						objpremio.mover(objpremio.getDireccion());
						
						//lista de premios

						
					}
					
										
				
					
					for(int i=0;i< mapaMunicion.getListaBalas().size()-1;i++) 		
					{
						//de municiones de jugador
						mapaMunicion.getListaBalas().get(i).mover(mapaMunicion.getListaBalas().get(i).getDireccion());
						
					}
					
					
					
					
					
					//elimino las municiones
					for(int i=0;i< mapaMunicion.getListaBalas().size();i++) { 		
						if (mapaMunicion.getListaBalas().get(i).getEntidadGrafica().getDibujo().getY()==0)
								obj_eliminar.add(mapaMunicion.getListaBalas().get(i));
					 }
						
						
		
				
					//hacer que las virus se muevan
				
					gui.estadoVida(mapa.getJugador().getVitalactual());
			
					
					for(Entidad virus : mapaVirus.getListaBalas()) 			
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
					mapa.getJugador().accionar(mapaVirus.getListaBalas());

					
				
						
				
					
					for(Entidad obj :  tanda[nivel_actual].get(tanda_actual)) {		
						
					 //cada infectado con lista municion
						if (obj.getEntidadGrafica().getDibujo()==null)
								{gui.agregarDibujo(obj);
								 
								}
						obj.accionar(mapaMunicion.getListaBalas());	
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
				
				mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/julieizquierda.gif");
		        gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());
				mapa.getJugador().setVelocidad(MovimientoHorizontal.IZQUIERDA );
				mapa.getJugador().getDireccion().setDireccion(mapa.getJugador().getVelocidad() );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());
			
				
	        	break;
			}
			case KeyEvent.VK_RIGHT: {
				mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliederecha.gif");
				gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
				mapa.getJugador().setVelocidad(MovimientoHorizontal.DERECHA);
				mapa.getJugador().getDireccion().setDireccion(mapa.getJugador().getVelocidad() );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());

				
	        	break;
			}
			case KeyEvent.VK_SPACE: {
					mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliefrente.gif");
					gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
					Arma arma=new Arma();
					DisparoJugador disparo = arma.crearArmaBasica(mapa.getJugador().getEntidadGrafica().getDibujo().getX(),mapa.getJugador().getEntidadGrafica().getDibujo().getY());
					disparo.getEntidadGrafica().setX(mapa.getJugador().getEntidadGrafica().getDibujo().getX());
					disparo.getEntidadGrafica().setY(mapa.getJugador().getEntidadGrafica().getDibujo().getY());
					
					
					if(mapa.getJugador().getTipoArma()!=0)						
					{
						
						DisparoJugador disparoExtra = arma.crearArmaBasica(mapa.getJugador().getEntidadGrafica().getDibujo().getX()+15,mapa.getJugador().getEntidadGrafica().getDibujo().getY());
						disparoExtra.getEntidadGrafica().setX(mapa.getJugador().getEntidadGrafica().getDibujo().getX()+15);
						disparoExtra.getEntidadGrafica().setY(mapa.getJugador().getEntidadGrafica().getDibujo().getY());
						disparoExtra.getEntidadGrafica().setImagen("img/jugador/ball.png");
						gui.agregarDibujo(disparoExtra);				
						mapaMunicion.ponerBalasEnLista(disparoExtra);					
						disparoExtra.setVelocidad(-50);
						disparoExtra.getDireccion().setDireccion(disparoExtra.getVelocidad()) ;		
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
}

