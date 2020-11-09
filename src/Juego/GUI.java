package Juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entidad.Entidad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class GUI extends JPanel implements ActionListener {
	
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
		//panelCampo.setBounds(0, 0, 500, 700);
		panelCampo.setBounds(0, 0, 1000, 900);
		//panelCampo.setBackground(Color.RED);
		panelCampo.setBackground(new Color(1,0,0));
		
		//panelCampo.setOpaque(false);
		
		repaint();
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
	   // dibujarFondo(g);      
	}
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	
}