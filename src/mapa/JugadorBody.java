package mapa;
import java.awt.*;

import javax.swing.ImageIcon;




public class JugadorBody {

    public enum DirectionJugador {LEFT,RIGHT};

    private int x;
    private int y;
    private int speed;
    
    
    public JugadorBody() {    	       
        this.speed =GameConfig.VELOCIDADJUGADOR;           
    }

    
    public void drawJugador(Graphics g) {
	    
	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/jugador.png"));      
        g.drawImage(imgCredits.getImage(), x , y , null);
        
    }

    
    
    public void moveDerecha() {
    	//x=x+GameConfig.VELOCIDADJUGADOR ;
   	   x += speed;
   	if (x>415)
 		x=415;

    }
    
    public void moveIzquierda() {
    	//x=x-GameConfig.VELOCIDADJUGADOR ;    	
    	 x -= speed;
    	 if (x<0)
     		x=0;
    }
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {   	
        this.x = x;          
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
       
    
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    

}
