package mapa;
import java.awt.Graphics;


public class Enemigobeta extends Entidad {

    private BetaBody body;

    public Enemigobeta(int x, int y) {

    	body=new BetaBody(x - 14 , y);  //      
        
    }
   

   
    
    public void drawBeta(Graphics g) {
    	
    	body.drawBeta(g);        
        //zombiebody.drawBeta(g);      
       
    }
      
    
 

    public void move() {
    	
    		body.move();

    	
    	
        
    }
    
    public int getY() {    	
    	return body.getY();
    }
    
    public void setY(int y) {    	
    	body.setY(y);
    }
 
    public int getX() {    	
    	return body.getX();
    }
    
    
   
    
    
}