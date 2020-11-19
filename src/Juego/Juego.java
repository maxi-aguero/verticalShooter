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
import EstrategiaMovimiento.MovimientoVertical;
import EstrategiaMovimiento.MovimientoVerticalBalas;
import EstrategiaMovimiento.MovimientoVerticalVirus;
import Mapa.Mapa;
import Mapa.MapaArmaSanitaria;
import Mapa.MapaVirus;
public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	protected GUI gui;
	protected List<Entidad> obj_eliminar;//infectados que elimino

	protected Mapa mapa;
	protected MapaVirus mapabalasGUI;
	protected MapaVirus mapabalas;
	
	protected Movimiento movimiento;

	protected MapaArmaSanitaria mapaMunicionGUI;
	protected MapaArmaSanitaria mapaMunicion;
	protected int coordx=0;

	
	public Juego(){
	
		
		obj_eliminar=new LinkedList<Entidad>();
		mapa = new Mapa();	
		mapabalasGUI = new MapaVirus();
		mapabalas = new MapaVirus();
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
	
	
	
	

	
	
	
	
	public void interactuar() {			
	
		this.requestFocus();
		
		
		for(Entidad municion : mapaMunicionGUI.getListaBalas()) 			
		{
			gui.agregarDibujo(municion);
		}
		mapaMunicionGUI.getListaBalas().clear();
		
	
		for(Entidad muni : mapaMunicion.getListaBalas()) 			
		{
			muni.getDireccion().setDireccion(MovimientoVerticalBalas.ARRIBA) ;
			muni.mover(muni.getDireccion());
		}
		
		
		gui.estadoVida(mapa.getJugador().getVitalactual());
		
		if (mapabalas.getListaBalas().size()!=0)
		{	for(Entidad bala : mapabalas.getListaBalas()) 			
				{
						
			Entidad elementoIntersectado = mapabalas.intersecta_virus_jugador(bala, mapa.getJugador());
					//intersecto con jugador
			if(elementoIntersectado!=null) 
				{
					elementoIntersectado.accept(bala.getVisitor());
					bala.accept(elementoIntersectado.getVisitor());
					//hago danio
					
				}
			
			
			bala.getDireccion().setDireccion(MovimientoVerticalVirus.ABAJO) ;
			bala.mover(bala.getDireccion());
						
				
				}
		
			  	
		}
		
		if (mapa.getTanda().getLista()==null)
			{	//gane todas las tandas
				gui.b.setVisible(false);
				
				
			}
		else
			{if (mapa.getTanda().esTandaVacia())
				{	
					//llenar
					mapa.getTanda().crearTanda();

					if (mapa.getTanda().getLista()!=null)
					{
					    for(Entidad obj2 : mapabalas.getListaBalas()){
				            	obj2.getEntidadGrafica().getDibujo().setVisible(false);
				            }
						mapabalas.getListaBalas().clear();
 
						for(Entidad obj : mapa.getTanda().getLista()) {			
							gui.agregarDibujo(obj);							
							Infectado inf= (Infectado) obj;
							inf.setMapaBalasGUI(mapabalasGUI);
							inf.setMapaBalas(mapabalas);							
							obj_eliminar.add(obj);
						}
						gui.eliminarTodos(obj_eliminar,mapa.getListaN1(),mapa.getListaN2(),mapa.getTanda());//elimina tanda 1

					}
				
				}
			else {
					
				//los infectados se mueven
					for(Entidad obj :  mapa.getTanda().getLista()) {			
						
						Entidad elementoIntersectado = mapa.intersecta_algo(obj);
						if(elementoIntersectado!=null) 
							{
								elementoIntersectado.accept(obj.getVisitor());
								obj.accept(elementoIntersectado.getVisitor());

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
							obj.getDireccion().setDireccion(MovimientoVertical.ABAJO) ;
							obj.mover(obj.getDireccion());
							
							
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
				int NewCoord=mapa.getJugador().getEntidadGrafica().getX();
				if (coordx!=NewCoord) {
					mapa.getJugador().getEntidadGrafica().setImagen("img/jugador/juliefrente.gif");
					gui.setDibujoJugador(mapa.getJugador().getEntidadGrafica().getImagen());	
					
					//agrego en gui, agrego en balas
					
					Proyectil disparo = new DisparoJugador(mapa.getJugador().getEntidadGrafica().getDibujo().getX(),mapa.getJugador().getEntidadGrafica().getDibujo().getY());
					disparo.getEntidadGrafica().setX(mapa.getJugador().getEntidadGrafica().getDibujo().getX());
					disparo.getEntidadGrafica().setY(mapa.getJugador().getEntidadGrafica().getDibujo().getY());
					
					coordx=mapa.getJugador().getEntidadGrafica().getX();
					mapaMunicionGUI.ponerBalasEnLista(disparo);
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

