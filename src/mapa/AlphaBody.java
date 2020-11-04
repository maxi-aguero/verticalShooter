package mapa;
import java.awt.*;

import javax.swing.ImageIcon;



public class AlphaBody {

    public enum Direction {DOWN};

    private int x;
    private int y;
    private int speed;
    private Direction direction;
   

    public AlphaBody(int x, int y) {
    	
        this.x = x;
        this.y = y;
        this.speed =GameConfig.VELOCIDADALPHA;        
        this.direction = Direction.DOWN;
    }
       

    public void drawAlpha(Graphics g) {      
    	    	 
	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/alpha.png"));      
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
    
    
 

}
