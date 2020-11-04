package mapa;
import java.awt.Graphics;


public class Jugador extends Entidad{

    private JugadorBody body;

    
    public Jugador() {
      
    	body=new JugadorBody();    	
    	body.setX(392);
    	body.setY(575);
        
    }
        
    
    public void drawJugador(Graphics g) {
    	
    	body.drawJugador(g);      

    }
    
  
    
    public void moveDerecha() {
    	body.moveDerecha();   	
   
    }
    
    public void moveIzquierda() {
    	body.moveIzquierda();
        
    }
        

    public int getX() {    	
    	return body.getX();
    }
    
   
    
   
    
    
}