package mapa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;




public class GUI extends JPanel implements ActionListener {
	private Mapa mapa;
	
	public GUI() {
		
        this.setPreferredSize(new Dimension(480, 655));
        this.setBackground(Color.GREEN); 
        this.setFocusable(true);


		
	}
	
	public void setMapa(Mapa m) {
		mapa = m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	 protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	                
	        dibujarFondo(g);  
	        
	          


	    }

	
	
	
   private void dibujarFondo(Graphics g) {

	    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("mapa/img/b8.jpg"));
    	ImageIcon imgdos= new  ImageIcon(imgCredits.getImage().getScaledInstance(472, 642, Image.SCALE_SMOOTH)); 

        g.drawImage(imgdos.getImage(), 0 , 0 , null);
        
        g.setColor(new Color(200,0,25));
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("Plague Inc  " , 128, 32);
                        
               
        
    }
}

