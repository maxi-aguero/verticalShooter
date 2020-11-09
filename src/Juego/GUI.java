package Juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidad.Entidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;





public class GUI extends JPanel{
	
	private JPanel panelCampo;//panel donde tengo los elementos   
    
    
	public GUI() {
		
		this.setPreferredSize(new Dimension(500, 700));
        this.setBackground(Color.GREEN);        
        this.setFocusable(true);   
        setLayout(null);       
        
		crearPanelCesped();

		add(panelCampo);
		

	}
	
	
	public Rectangle getRectanglePanelCesped() {
		return panelCampo.getBounds();
	}
	
	public void crearPanelCesped() {
		panelCampo = new JPanel();
		panelCampo.setLayout(null);
		panelCampo.setBounds(0, 0, 1000, 900);
		panelCampo.setBackground(new Color(1,0,0));		
		//panelCampo.setOpaque(false);
		add(panelCampo);
	}
	

public void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getX(), e.getY(), 100, 80);
		e.setDibujo(lbdos);
		lbdos.repaint();
		
		panelCampo.add(lbdos);
		panelCampo.repaint();
		
		
	}	
	
	
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
            
    //dibujarFondo(g);  
}


/**private void dibujarFondo(Graphics g) {

    ImageIcon imgCredits=new ImageIcon(getClass().getClassLoader().getResource("img/gui/background8.jpg"));
	ImageIcon imgdos= new  ImageIcon(imgCredits.getImage().getScaledInstance(472, 400, Image.SCALE_SMOOTH)); 

    g.drawImage(imgdos.getImage(), 0 , 0 , null);
    
    g.setColor(new Color(200,0,25));
    g.setFont(new Font("Ink Free", Font.BOLD, 40));
    g.drawString("Plague Inc  " , 128, 32);
                    
           
    
}*/






	
	
	
	
	
	

	
	
}