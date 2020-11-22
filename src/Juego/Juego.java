package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;


import Entidad.Entidad;
import Entidad.Infectado.Infectado;
import Entidad.Proyectil.DisparoJugador;
import Entidad.Proyectil.Proyectil;
import EstrategiaMovimiento.MovimientoHorizontal;
import EstrategiaMovimiento.MovimientoVerticalDeInfectado;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Mapa.Mapa;
import Mapa.MapaArmaSanitaria;
import Mapa.MapaVirus;
import Premio.Premio;
import Premio.PremioVida;
public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	protected GUI gui;
	protected List<Entidad> obj_eliminar;//infectados que elimino

	protected Mapa mapa;
	protected MapaVirus mapabalasGUI;
	protected MapaVirus mapabalas;
	
	protected Movimiento movimiento;

	protected MapaArmaSanitaria mapaMunicionGUI;
	protected MapaArmaSanitaria mapaMunicion;
	
	protected int tanda_actual=0;
	protected int nivel_actual=0;
	
	//protected int coordx=0;
	protected int xx=0;

	protected List<List<Entidad>>[] tandas_nivel1;
	protected List<List<Entidad>>[] tandas_nivel1_mover;
	
	protected List<Entidad> lista_premio;
	
	@SuppressWarnings("unchecked")
	public Juego(){
	
		
		obj_eliminar=new LinkedList<Entidad>();
		lista_premio=new LinkedList<Entidad>();
		mapa = new Mapa();	
		tandas_nivel1=new List[2] ;
		tandas_nivel1_mover=new List[2] ;
		tandas_nivel1[0] =mapa.crearTandaN1();
		tandas_nivel1_mover[0]  = mapa.crearTandaN1();
		
		tandas_nivel1[1] =mapa.crearTandaN2();//otra tanda nivel 2
		tandas_nivel1_mover[1]  = mapa.crearTandaN2();

		
		mapabalasGUI = new MapaVirus();//virus
		mapabalas = new MapaVirus();//virus
		mapaMunicionGUI= new MapaArmaSanitaria();
		mapaMunicion= new MapaArmaSanitaria() ;
		
		mapa.getJugador().setMapaBalasGUI(mapaMunicionGUI);
		mapa.getJugador().setMapaBalas(mapaMunicion);
		vinculargui();
		movimiento = new Movimiento(this);
		
		
		
		//dibujar proyectil en gui

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


		
		
	 if (nivel_actual==2)
	 {
		 //eliminar las balas de la gui y los virus
		
		 mapaMunicion.getListaBalas().clear();

		 mapabalas.getListaBalas().clear();
		 
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
				if(tandas_nivel1_mover[nivel_actual].get(tanda_actual).size()==0)
						tanda_actual=tanda_actual+1;
				 
			
				if(tanda_actual<2)
				{
					Premio recupera_vida_x=null;
				
					 boolean enc=false;
					for(int j=0;enc==false&&j< tandas_nivel1_mover[nivel_actual].get(tanda_actual).size();j++) {		
							  Infectado inf = (Infectado)tandas_nivel1_mover[nivel_actual].get(tanda_actual).get(j);
							
						if (inf.getVitalactual()<=0)
								{obj_eliminar.add(inf);
								//creo premio vida
								recupera_vida_x= new PremioVida(tandas_nivel1_mover[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getX(),tandas_nivel1_mover[nivel_actual].get(tanda_actual).get(j).getEntidadGrafica().getDibujo().getY());

								tandas_nivel1_mover[nivel_actual].get(tanda_actual).remove(j);
								enc=true;
								//lanzo premio vida
								//es una entidad
								gui.agregarDibujo(recupera_vida_x);
								
								lista_premio.add(recupera_vida_x);
								//despues que se mueva,es decir que baje
								
								}
					 }	
					gui.eliminacion(obj_eliminar);
					for(Entidad objpremio:lista_premio) {
						objpremio.getDireccion().setDireccion(MovimientoVerticalVirus.ABAJOPREMIO) ;			
						objpremio.mover(objpremio.getDireccion());
						
					}
					
										
					for(int ii=0;ii< mapaMunicionGUI.getListaBalas().size();ii++) 		
						
					{
						
							gui.agregarDibujo(mapaMunicionGUI.getListaBalas().get(ii));
						
			
					}
					mapaMunicionGUI.getListaBalas().clear();
					
					for(int i=0;i< mapaMunicion.getListaBalas().size()-1;i++) 		
					{
						
						
																										//arma sanitaria - algun infecado, pero puede ser del otro nivel?
		
								Entidad elementoIntersectado = mapaMunicion.intersecta_virus_jugador(mapaMunicion.getListaBalas().get(i), tandas_nivel1_mover[nivel_actual].get(tanda_actual));
								if(elementoIntersectado!=null) //intersecto con jugador
								{
									elementoIntersectado.accept(mapaMunicion.getListaBalas().get(i).getVisitor());
									mapaMunicion.getListaBalas().get(i).accept(elementoIntersectado.getVisitor());					
								}
								
						
						
						
						mapaMunicion.getListaBalas().get(i).getDireccion().setDireccion(MovimientoVerticalVirus.ARRIBA) ;			
						mapaMunicion.getListaBalas().get(i).mover(mapaMunicion.getListaBalas().get(i).getDireccion());
						
					
					}
					
					
					
					
					for(int i=0;i< mapaMunicion.getListaBalas().size()-1;i++) { 		
						if (mapaMunicion.getListaBalas().get(i).getEntidadGrafica().getDibujo().getY()==0)
								obj_eliminar.add(mapaMunicion.getListaBalas().get(i));
					 }
						
						
		
				
					//hacer que las virus se muevan
				
					gui.estadoVida(mapa.getJugador().getVitalactual());
			
					
					for(Entidad bala : mapabalas.getListaBalas()) 			
					{
							
						Entidad elementoIntersectado = mapabalas.intersecta_virus_jugador(bala, mapa.getJugador());
						if(elementoIntersectado!=null) //intersecto con jugador
							{
								elementoIntersectado.accept(bala.getVisitor());
								bala.accept(elementoIntersectado.getVisitor());					
							}
				
						bala.getDireccion().setDireccion(MovimientoVerticalVirus.ABAJO) ;
						bala.mover(bala.getDireccion());
					}
						
					
					
					//muestro la tanda en gui 
					
					for(Entidad infect : tandas_nivel1[nivel_actual].get(tanda_actual))		
					{
						gui.agregarDibujo(infect);
						
						Infectado inf= (Infectado) infect;
						inf.setMapaBalasGUI(mapabalasGUI);
						inf.setMapaBalas(mapabalas);	
					}
					tandas_nivel1[nivel_actual].get(tanda_actual).clear();
						
			
			
			
			
			
					
					for(Entidad obj :  tandas_nivel1_mover[nivel_actual].get(tanda_actual)) {		
						
						
						Entidad elementoIntersectado = mapa.intersecta_algo(obj);
						if(elementoIntersectado!=null) 
							{
			
								obj.accept(elementoIntersectado.getVisitor());
								elementoIntersectado.accept(obj.getVisitor());
								
								if (mapabalasGUI.getListaBalas().size()!=0)
								{	for(Entidad bala : mapabalasGUI.getListaBalas()) 			
										{
											gui.agregarDibujo(bala);
										}
									
								}
								mapabalasGUI.getListaBalas().clear();	
								
								
								
							}
						else
						{
							obj.getDireccion().setDireccion(MovimientoVerticalDeInfectado.ABAJO) ;
							obj.mover(obj.getDireccion());				
							
						}	
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
				mapa.getJugador().getDireccion().setDireccion(MovimientoHorizontal.IZQUIERDA );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());
				
				
	        	break;
			}
			case KeyEvent.VK_RIGHT: {
				mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliederecha.gif");
				gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
				mapa.getJugador().getDireccion().setDireccion(MovimientoHorizontal.DERECHA );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());

				
	        	break;
			}
			case KeyEvent.VK_UP: {
					mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliefrente.gif");
					gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
					
					//agrego en gui, agrego en balas
					
					Proyectil disparo = new DisparoJugador(mapa.getJugador().getEntidadGrafica().getDibujo().getX(),mapa.getJugador().getEntidadGrafica().getDibujo().getY());
					disparo.getEntidadGrafica().setX(mapa.getJugador().getEntidadGrafica().getDibujo().getX());
					disparo.getEntidadGrafica().setY(mapa.getJugador().getEntidadGrafica().getDibujo().getY());
					
					//coordx=mapa.getJugador().getEntidadGrafica().getX();
					mapaMunicionGUI.ponerBalasEnLista(disparo);
					mapaMunicion.ponerBalasEnLista(disparo);
				
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

