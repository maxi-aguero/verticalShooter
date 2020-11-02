package mapa;
import java.awt.*;

import javax.swing.ImageIcon;



public class ZombieBody {

    public enum Direction {DOWN};

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

   

    public void drawAlpha(Graphics g) {
       
        
        ImageIcon imgCredits=new ImageIcon("img/alpha.png");	       
        g.drawImage(imgCredits.getImage(), x , y , null);
        
	   	 
	   	 
        
    }
    
    public void drawBeta(Graphics g) {
        //g.setColor(new Color(0,138,0));
       // g.fillRect(x, y, GameConfig.UNIT_SIZE, GameConfig.UNIT_SIZE);
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
