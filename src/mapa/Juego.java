package mapa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Juego extends JFrame implements ActionListener{
	
	protected GUI gui;
	protected Mapa mapa;
	protected Premio premio;//premios
	protected Timer tiempo ;

	
	public Juego(){
		
		premio = new Premio(this);	
		gui = new GUI(premio);
		
        this.add(gui);
        this.setTitle("Zombielandia");
        //this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        tiempo = new Timer(GameConfig.DELAY, this);
        tiempo.start();        
        this.addKeyListener(new JugadorKeyListener());

		mapa = new Mapa(gui, this);
		mapa.crearNivelUno();
		
		// interactuar 
        
        

		
	}	
	 
	
	
	
	
// interactuar
	public void actionPerformed(ActionEvent arg0) {
		//aca muevo al infectados
		
		System.out.println("lista principal: "+mapa.getListaPrincipal().size());
		System.out.println("lista eliminar: "+mapa.getListaEliminar().size());
		System.out.println("lista agregar: "+mapa.getListaAgregar().size());
		System.out.println("lista jugadores: "+mapa.getListaJugador().size());
		
		

		for(Entidad obj : mapa.getListaJugador()) {
			gui.ponerEntidad(obj); //poner los jugador en mapa
			repaint();
		}
		repaint();
		for(Entidad obj : mapa.getListaAgregar()) {
			gui.ponerEntidad(obj); //poner los infectados en mapa
			repaint();

		}
		mapa.resetLista(mapa.getListaAgregar());

		repaint();
		
	}
	
	
	
	
	private class JugadorKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            	
            	
            	for(Entidad obj : mapa.getListaJugador()) {
            		//obj.moveDerecha();
            		gui.ponerEntidad(obj); //poner los jugador en mapa
        			
        			repaint();
        		}
            	
            	
            	
            	
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            	for(Entidad obj : mapa.getListaJugador()) {
            		//obj.moveIzquierda();
            		gui.ponerEntidad(obj); //poner los jugador en mapa
        			
        			repaint();
        		}
            	

            } 
        }
	}

	public GUI getGUI() {
		return gui;
	}
	
	
}



