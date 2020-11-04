package mapa;
import java.awt.*;

import javax.swing.ImageIcon;



public class BetaBody {

    public enum Direction {DOWN};

    private int x;
    private int y;
    private int speed;
    private Direction direction;
   

    public BetaBody(int x, int y) {
    	
        this.x = x;
        this.y = y;
        this.speed =GameConfig.VELOCIDADBETA;        
        this.direction = Direction.DOWN;
    }
       

    public void drawBeta(Graphics g) {      
    	    	 
	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/beta.png"));      
        g.drawImage(imgCredits.getImage(), x , y , null);
        g.setColor(Color.RED);
        g.fillOval(x+11, y+11, 8, 8);//
        g.fillOval(x+18, y+6,5, 5);//
        g.fillOval(x, y,9, 9);//
        
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
    
    public int getY() {
    	return y;
    }
    
    public void setY(int y) {
    	this.y= y;
    }
    
    public int getX() {
    	return x;
    }

}
