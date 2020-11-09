package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import Entidad.Entidad;
import Entidad.Jugador.Player;




public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	
	protected GUI gui;
	protected Mapa mapa;
	protected Timer tiempo;
	
	public Juego(){
		
		gui = new GUI();
		gui.setVisible(true);
		mapa = new Mapa(gui, this);		
		this.add(gui);
        this.setTitle("Zombielandia");
        //this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        this.start();    

	}	


	
	private void start() {   	
        this.addKeyListener(this);
        mapa.crearNivelUno();          
        tiempo = new Timer(40, this);
        tiempo.start();
    }
		


	
	public void interactuar() {	
		
		for(Entidad obj : mapa.getListaPrincipal()) {
			if(obj.estaVivo()) 	{}		
				obj.interactuar();						
			
		}		
		
		for(Entidad obj : mapa.getListaAgregar()) {			
				mapa.getListaPrincipal().add(obj);
				gui.agregarDibujo(obj);				
		}	
		
		
		mapa.resetLista(mapa.getListaAgregar());
		
		

		
		
	}



	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
		
		
			case KeyEvent.VK_LEFT: {
				Player p01= (Player) mapa.dameJugador();
            	p01.moverizquierda();
				break;
			}
			case KeyEvent.VK_RIGHT: {
			 	Player p01= (Player) mapa.dameJugador();
            	p01.moverderecha();

				break;
			}
			case KeyEvent.VK_ENTER: {
				//System.out.println("dispara");
			break;
		}
		
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
		
			case KeyEvent.VK_LEFT: {
				Player p01= (Player) mapa.dameJugador();
	        	p01.moverizquierda();
				break;
			}
			case KeyEvent.VK_RIGHT: {
			 	Player p01= (Player) mapa.dameJugador();
				p01.moverderecha();
	
				break;
			}
			case KeyEvent.VK_ENTER: {
					//System.out.println("dispara");
				break;
			}
	
		}				
	}

	public void keyTyped(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
				Player p01= (Player) mapa.dameJugador();
	        	p01.moverizquierda();
				break;
			}
			case KeyEvent.VK_RIGHT: {
			 	Player p01= (Player) mapa.dameJugador();
	        	p01.moverderecha();
	
				break;
			}
			case KeyEvent.VK_ENTER: {
				//System.out.println("dispara");
			break;
		}
	
	}
	
		
	}
	
	
	
	

	
	
	
	
	
	



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.interactuar();
		
	}


	
	
}

