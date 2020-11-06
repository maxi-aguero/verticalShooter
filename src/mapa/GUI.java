package mapa;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class GUI extends JPanel {
	
	private static final long serialVersionUID = 1L;


    private Premio tienda;
    private Mapa mapa; 
    JPanel panelFondo;
    
    
	public GUI(Premio t) {
		tienda = t;
		
	   	//setSize(480,655);

	
	   	this.setPreferredSize(new Dimension(480, 655));
        this.setBackground(Color.GREEN); 
        
        this.setFocusable(true);   
        setLayout(null);
        //ponerJugador();
        
		

		

	}
	
	
	public void ponerEntidad(Entidad obj) {
		panelFondo = new JPanel();
		ImageIcon imagenEntidad=new ImageIcon(getClass().getClassLoader().getResource(obj.getImagen()));      
	    JLabel label=new JLabel(" ");
		label.setBounds(obj.getX(), obj.getY(), 40, 100);
		label.setIcon(imagenEntidad);
		label.repaint();
	   	add(label);
		//panelFondo.setLayout(null);
		
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