package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import Entidad.Entidad;
import Entidad.Jugador.Jugador;
import EstrategiaMovimiento.MovimientoHorizontal;
import EstrategiaMovimiento.MovimientoVertical;
public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	protected GUI gui;
	protected Mapa mapa;
	protected Timer tiempo;
	public Juego(){

		mapa = new Mapa();		
		vinculargui();	
        start(); 
		
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
	
	
	
	private void start() {   	
        this.addKeyListener(this);
        mapa.crearNivelUno();          
        tiempo = new Timer(40, this);
        tiempo.start();
    }
	
	
	
	
	public void interactuar() {	

		for(Entidad obj : mapa.getListaEnJuego()) {
			if(obj.estaVivo()) 	{
				Entidad elementoIntersectado = mapa.intersectaRangoDeEnemigo(obj);
				if(elementoIntersectado!=null) 
					elementoIntersectado.accept(obj.getVisitor());
				else
				{
					//si no es jugador, muevo
					if (obj!= mapa.getJugador()) {
					
						obj.getDireccion().setDireccion(MovimientoVertical.ABAJO );
						obj.mover(obj.getDireccion());
					}
					
					
				}			
			}				
		}		
		
		
		for(Entidad obj : mapa.getListaAgregar()) {			
				mapa.getListaEnJuego().add(obj);
				gui.agregarDibujo(obj);				
		}	
		mapa.resetLista(mapa.getListaAgregar());
	}	
	
	

	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {

			case KeyEvent.VK_LEFT: {
				Entidad p01= (Jugador) mapa.getJugador();

				p01.getDireccion().setDireccion(MovimientoHorizontal.IZQUIERDA );
	        	p01.mover(p01.getDireccion());
	        	break;
			}
			case KeyEvent.VK_RIGHT: {
				Entidad p01= (Jugador) mapa.getJugador();

				p01.getDireccion().setDireccion(MovimientoHorizontal.DERECHA );
	        	p01.mover(p01.getDireccion());
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
		this.interactuar();

		
	}
}

