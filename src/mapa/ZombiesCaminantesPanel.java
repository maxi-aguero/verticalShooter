package mapa;


import javax.swing.JPanel;
import javax.swing.Timer;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

public class ZombiesCaminantesPanel extends JPanel implements ActionListener {


    private Enemigo enemigo01,enemigo02,enemigo03,enemigo04,enemigo05,enemigo06,enemigo07;
   
    private Timer timer;
   
    
    public ZombiesCaminantesPanel() {       
        
    	
        this.setPreferredSize(new Dimension(480, 655));
        this.setBackground(Color.GREEN);
        this.setFocusable(true);
        this.start();       
        
        
        
    }

    private void start() {   	

        
        enemigo01 = new Enemigo(2 * GameConfig.UNIT_SIZE,   12 * GameConfig.UNIT_SIZE);      
        enemigo02 = new Enemigo(10 * GameConfig.UNIT_SIZE,  2 * GameConfig.UNIT_SIZE);
        enemigo03 = new Enemigo(12 * GameConfig.UNIT_SIZE,  5 * GameConfig.UNIT_SIZE);
        enemigo04 = new Enemigo(20 * GameConfig.UNIT_SIZE,  2 * GameConfig.UNIT_SIZE);
        enemigo05 = new Enemigo(25 * GameConfig.UNIT_SIZE,  4 * GameConfig.UNIT_SIZE);
        enemigo06 = new Enemigo(30 * GameConfig.UNIT_SIZE,  8 * GameConfig.UNIT_SIZE);
        enemigo07 = new Enemigo(30 * GameConfig.UNIT_SIZE,  8 * GameConfig.UNIT_SIZE);
        timer = new Timer(GameConfig.DELAY, this);
        timer.start();      
         
    }
    
   
    
   

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        enemigo01.drawBeta(g); 
        
        enemigo02.drawAlpha(g);
        enemigo03.drawAlpha(g);
        
        enemigo04.drawBeta(g);
        
        enemigo05.drawAlpha(g);        
        enemigo06.drawAlpha(g);
        
        enemigo07.drawBeta(g);        

      


    }

   
    public void actionPerformed(ActionEvent e) {    	   
    	   
    	   //beta
    	   enemigo01.move();
    	   enemigo01.getHead().setSpeed(GameConfig.VELOCIDADBETA);
    	   //alpha
    	   enemigo02.move();
    	   enemigo03.move();
    	   //beta
    	   enemigo04.move();   
           enemigo04.getHead().setSpeed(GameConfig.VELOCIDADBETA);
    	   //alpha
    	   enemigo05.move();
    	   enemigo06.move();    	   
    	   //beta    	   
           enemigo07.move();   
           enemigo07.getHead().setSpeed(GameConfig.VELOCIDADBETA);
              
          
      
        
        repaint();

    }

    

    
    
}