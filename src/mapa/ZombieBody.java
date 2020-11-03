package mapa;
import java.awt.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class ZombieBody {

    public enum Direction {DOWN,LEFT,RIGHT};

    private int x;
    private int y;
    private int speed;
    private Direction direction;
  
    
   

    public ZombieBody(int x, int y) {
    	

        this.x = x;
        this.y = y;
        this.speed =GameConfig.VELOCIDADALPHA;        
        this.direction = Direction.DOWN;
    }
    
    
  public ZombieBody() {
    	       
        this.speed =GameConfig.VELOCIDADJUGADOR;        
    }

   

    public void drawAlpha(Graphics g) {      
    	    	 
	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/alpha.png"));      
        g.drawImage(imgCredits.getImage(), x , y , null);
        g.setColor(Color.RED);
        g.fillOval(x+11, y+11, GameConfig.UNIT_SIZE-6, GameConfig.UNIT_SIZE-6);
        g.fillOval(x+18, y+6, GameConfig.UNIT_SIZE-9, GameConfig.UNIT_SIZE-9);
        g.fillOval(x, y, GameConfig.UNIT_SIZE-5, GameConfig.UNIT_SIZE-5);
        
	   	 
	   	 
        
    }
    
    public void drawBeta(Graphics g) {
    	
	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/beta.png"));      
        g.drawImage(imgCredits.getImage(), x , y , null);
        g.setColor(Color.RED);
        g.fillOval(x+11, y+11, GameConfig.UNIT_SIZE-6, GameConfig.UNIT_SIZE-6);
        g.fillOval(x+18, y+6, GameConfig.UNIT_SIZE-9, GameConfig.UNIT_SIZE-9);
        g.fillOval(x+2, y, GameConfig.UNIT_SIZE-5, GameConfig.UNIT_SIZE-5);
    }
    
    
    public void drawJugador(Graphics g) {
	    
	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/jugador.png"));      
        g.drawImage(imgCredits.getImage(), x , y , null);
        
    }
    
  

    
    
    public void move() {
        switch (direction) {          

            case DOWN:
                y += speed;
                break;
            

            default:
                break;
        }
    }
    
    
    public void moveDerecha() {
    	//x=x+GameConfig.VELOCIDADJUGADOR ;
   	   x += speed;

    }
    
    public void moveIzquierda() {
    	//x=x-GameConfig.VELOCIDADJUGADOR ;    	
    	 x -= speed;
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
//
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
