package mapa;
import java.awt.Graphics;


public class Enemigoalpha extends Entidad {

    private AlphaBody body;

    public Enemigoalpha(int x, int y) {

    	body=new AlphaBody(x, y);        
        
    }
    

    public void drawAlpha(Graphics g) {
    	body.drawAlpha(g);
        
    }
    

    public void move() {
    	body.move();
        
    }
    
   
    
   
    
    
}