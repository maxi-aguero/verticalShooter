package mapa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import mapa.ZombieBody.Direction;


public class Enemigo {

    private ZombieBody body;

    public Enemigo(int x, int y) {

    	body=new ZombieBody(x - GameConfig.UNIT_SIZE , y);        
        
    }
    
    public Enemigo() {
      
    	body=new ZombieBody();    	
    	body.setX(15 * GameConfig.UNIT_SIZE - GameConfig.UNIT_SIZE );
    	body.setY(41 * GameConfig.UNIT_SIZE );
 

     
        
    }
    
   
        
   

    public void drawAlpha(Graphics g) {
    	body.drawAlpha(g);
        
    }
    
    public void drawBeta(Graphics g) {
    	
    	body.drawBeta(g);        
        //zombiebody.drawBeta(g);      
       
    }
      
    
    
    
    public void drawJugador(Graphics g) {
    	
    	body.drawJugador(g);      

    }
    
    
 

    public void move() {
    	body.move();
        
    }
    
    public void moveDerecha() {
    	body.moveDerecha();
        
    }
    
    public void moveIzquierda() {
    	body.moveIzquierda();
        
    }
    
   
    

    public ZombieBody getHead() {
        return body;
    }

    public void setDirection(Direction d) {
        this.getHead().setDirection(d);
    }
    
    
   
    
    
}