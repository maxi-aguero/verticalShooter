package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Entidad.Entidad;

public class GUI extends JPanel  {
	
	private JLabel fondo;
	public GUI() {
		
		this.setPreferredSize(new Dimension(800, 900));
        this.setBackground(new Color(90,60,90));  
        this.setFocusable(true);   
        this.setLayout(null);      
        crearFondo();
		

	}
	
	private void crearFondo() {		
		
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/background8.jpg"));
		fondo = new JLabel(imagen,SwingConstants.CENTER);
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(800, 900, Image.SCALE_SMOOTH)); 
	 	fondo.setIcon(imgdos);	
		fondo.repaint();	
		fondo.setBounds(0,0, 800, 900);
		this.setLayout(null);
		fondo.setLayout(null);
		JLabel palabra=new JLabel("Plague Inc");
		palabra.setForeground(new Color(223, 45, 223)); 

		palabra.setFont(new Font("Ink Free", Font.BOLD, 40));
		palabra.setBounds(280,5, 300, 150);
		
		JLabel vida=new JLabel("vida");
		vida.setBounds(1000,5, 300, 150);
		
        add(palabra);        
		add(fondo);
		add(vida);	

	
	}
	
	public void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getX(), e.getY(), 50, 80);
		e.setDibujo(lbdos);
		lbdos.repaint();

		fondo.add(lbdos);
		fondo.repaint();
		
	}

	
	

	
	
	


}
