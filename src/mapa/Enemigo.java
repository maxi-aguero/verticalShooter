package mapa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


public class Enemigo {

    private ZombieBody body;

    public Enemigo(int x, int y) {

    	body=new ZombieBody(x - GameConfig.UNIT_SIZE , y);        
        
    }
    

    public void drawAlpha(Graphics g) {
    	body.drawAlpha(g);
        
    }
    
    public void drawBeta(Graphics g) {
    	
    	ImageIcon imgCredits=new ImageIcon("img/beta.png");	       
        g.drawImage(imgCredits.getImage(), body.getX() , body.getY() , null);
        
        //zombiebody.drawBeta(g);        
        
    	
    
    }
    

    public void move() {
    	body.move();
        
    }
    

    public ZombieBody getHead() {
        return body;
    }

   
    
    
   
    
    
}