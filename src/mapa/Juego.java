package mapa;



import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

public class Juego extends JPanel implements ActionListener {
     

	private Enemigoalpha enemigo01,enemigo02,enemigo03,enemigo04,enemigo05,enemigo06;
	private Enemigobeta enemigo07;	
	private Jugador personaje_b;
   
    private Timer tiempo;
    
    private Entidad[] arr;
   
    
    public Juego() {       
    	arr= new Entidad[430];
    	
        this.setPreferredSize(new Dimension(480, 655));
        this.setBackground(Color.GREEN); 
        
        this.addKeyListener(new JugadorKeyListener());
        
        this.setFocusable(true);
        this.start();    
        
    }

    private void start() {   	

    									
         enemigo01 = new Enemigoalpha(14,168);      
         enemigo02 = new Enemigoalpha(126,25);
         enemigo03 = new Enemigoalpha(154,70);
         enemigo04 = new Enemigoalpha(266,28);
         enemigo05 = new Enemigoalpha(336,56);
         enemigo06 = new Enemigoalpha(406,112);
         enemigo07 = new Enemigobeta(406,95);        
         personaje_b = new Jugador();  
         
         tiempo = new Timer(GameConfig.DELAY, this);
         tiempo.start();
    }
    
   

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
                
        dibujarFondo(g);  
        
        enemigo01.drawAlpha(g);        
        enemigo02.drawAlpha(g);
        enemigo03.drawAlpha(g);        
        enemigo04.drawAlpha(g);        
        enemigo05.drawAlpha(g);        
        enemigo06.drawAlpha(g);        
        
        enemigo07.drawBeta(g);  
        
        personaje_b.drawJugador(g);//jugador        


    }

    public void acciona() {
    	//dejo de mover    		
	        	 if (enemigo07.getY()==575) {
	        		   System.out.println(enemigo07.getX());     		   
	        		   System.out.println(personaje_b.getX());     		   
	        		   arr[enemigo07.getX()]=enemigo07;//agrego a un enemigo 
	        		   System.out.println("agrego a un array");	       		   

	   				   enemigo07.setY(600);	//vuelve a la posicion inicial??
	   			  }
		
		
			
    }
   
    
    public void accionaJugador() {
    	//dejo de mover    		
		   arr[personaje_b.getX()]=personaje_b;//agrego al jugador

		
		
			
    }
    
    
    public void actionPerformed(ActionEvent e) {  	   
    	   //alpha
    	   enemigo01.move();    	   
    	   enemigo02.move();
    	   enemigo03.move();    	   
    	   enemigo04.move();   
    	   enemigo05.move();
    	   enemigo06.move();    	   
    	   //beta
    	   if (enemigo07.getY()<575)
     		   enemigo07.move();
    	   else acciona();
    	  
    	   
        
        repaint();

    }

    
    
    private class JugadorKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            	
            	personaje_b.moveDerecha();
            	accionaJugador(); // agregar jugador al arreglo
            	
            	
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            	
            	personaje_b.moveIzquierda();
            	accionaJugador();// agregar jugador al arreglo
            	

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