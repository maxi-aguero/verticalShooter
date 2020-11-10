package Juego;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Entidad.Entidad;
import Entidad.Jugador.Player;




public class Juego  extends  JFrame implements ActionListener,KeyListener  {
	
	//protected GUI gui;
	protected Mapa mapa;
	protected Timer tiempo;
	private JPanel panelBatalla;//panel donde tengo los elementos   
	
	
	public Juego(){
		this.setPreferredSize(new Dimension(500, 600));
		getContentPane().setBackground(new Color(90,60,90));
        setLayout(null);                
        
		mapa = new Mapa(this);		
        this.setTitle("Zombielandia");
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);

        start();    

	}	


	
	private void start() {   	
        this.addKeyListener(this);
        crearPanelBatalla();
        mapa.crearNivelUno();          
        tiempo = new Timer(40, this);
        tiempo.start();
    }
		
	
	private void crearPanelBatalla() {
		panelBatalla = new JPanel();
		panelBatalla.setLayout(null);
		panelBatalla.setBounds(0, 0, 475, 555);
		panelBatalla.setBackground(new Color(1,0,0));		
		//panelBatalla.setOpaque(false);
	   	
		add(panelBatalla);
	}
	

	private void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getX(), e.getY(), 100, 80);
		e.setDibujo(lbdos);
		lbdos.repaint();
		
		panelBatalla.add(lbdos);
		panelBatalla.repaint();
		
		
	}	
	
	

	
	private void interactuar() {	
		
		for(Entidad obj : mapa.getListaEnJuego()) {
			if(obj.estaVivo()) 	{
				Entidad elementoIntersectado = mapa.intersectaRangoDeEnemigo(obj);
				if(elementoIntersectado!=null) 
					elementoIntersectado.accept(obj.getVisitor());
				else
					obj.mover();				
			}				
		}		
		
		
		for(Entidad obj : mapa.getListaAgregar()) {			
				mapa.getListaEnJuego().add(obj);
				agregarDibujo(obj);				
		}				
		mapa.resetLista(mapa.getListaAgregar());
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		this.interactuar();
		
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
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
}

