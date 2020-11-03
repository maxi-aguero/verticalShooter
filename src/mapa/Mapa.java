package mapa;


import mapa.ZombieBody.Direction;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

public class Mapa extends JPanel implements ActionListener {
     

	private Enemigo enemigo01,enemigo02,enemigo03,enemigo04,enemigo05,enemigo06,enemigo07;
    private Enemigo personaje_b;
   
    private Timer tiempo;
   
    
    public Mapa() {       
        
    	
        this.setPreferredSize(new Dimension(480, 655));
        this.setBackground(Color.GREEN);   	
        
        
        this.addKeyListener(new JugadorKeyListener());

        
        this.setFocusable(true);
        this.start();      
        
        
    }

    private void start() {   	

        
        enemigo01 = new Enemigo(2 * GameConfig.UNIT_SIZE,   12 * GameConfig.UNIT_SIZE);      
        enemigo02 = new Enemigo(10 * GameConfig.UNIT_SIZE,  2 * GameConfig.UNIT_SIZE);
        enemigo03 = new Enemigo(12 * GameConfig.UNIT_SIZE,  5 * GameConfig.UNIT_SIZE);
        enemigo04 = new Enemigo(20 * GameConfig.UNIT_SIZE,  2 * GameConfig.UNIT_SIZE);
        enemigo05 = new Enemigo(25 * GameConfig.UNIT_SIZE,  4 * GameConfig.UNIT_SIZE);
        enemigo06 = new Enemigo(30 * GameConfig.UNIT_SIZE,  8 * GameConfig.UNIT_SIZE);
        enemigo07 = new Enemigo(30 * GameConfig.UNIT_SIZE,  8 * GameConfig.UNIT_SIZE);
       
        
        personaje_b = new Enemigo();        
        

        
        
        tiempo = new Timer(GameConfig.DELAY, this);
        tiempo.start();      
         
    }
    
   
    
   

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
                
        dibujarFondo(g);  
        
        enemigo01.drawBeta(g); 
        
        enemigo02.drawAlpha(g);
        enemigo03.drawAlpha(g);
        
        enemigo04.drawBeta(g);
        
        enemigo05.drawAlpha(g);        
        enemigo06.drawAlpha(g);
        
        enemigo07.drawBeta(g);  
        
        personaje_b.drawJugador(g);//jugador
        


    }

   
    public void actionPerformed(ActionEvent e) {    	   
    	
    	   //beta
    	   enemigo01.move();
    	   enemigo01.getHead().setSpeed(GameConfig.VELOCIDADBETA);
    	   //alpha
    	   enemigo02.move();
    	   enemigo03.move();
    	   //beta
    	   enemigo04.move();   
           enemigo04.getHead().setSpeed(GameConfig.VELOCIDADBETA);
    	   //alpha
    	   enemigo05.move();
    	   enemigo06.move();    	   
    	   //beta    	   
           enemigo07.move();   
           enemigo07.getHead().setSpeed(GameConfig.VELOCIDADBETA);
        
      
        
        repaint();

    }

    
    
    private class JugadorKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            	
            	personaje_b.moveDerecha();
            	personaje_b.setDirection(Direction.RIGHT);
            	
            	
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            	
            	personaje_b.moveIzquierda();
            	personaje_b.setDirection(Direction.LEFT);
            	

            } 
        }
    }

    
    
    private void dibujarFondo(Graphics g) {

	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/b8.jpg"));
    	ImageIcon imgdos= new  ImageIcon(imgCredits.getImage().getScaledInstance(472, 642, Image.SCALE_SMOOTH)); 

        g.drawImage(imgdos.getImage(), 0 , 0 , null);
        
        g.setColor(new Color(200,0,25));
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("Plague Inc  " , 128, 32);
                        
               
        
    }
    
    
}