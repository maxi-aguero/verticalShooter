
package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class WindowDialogos extends JFrame  {
	
	private String[] config_jugador;
	private CargarJuego cargarJuego;

	public WindowDialogos() {	
		config_jugador=new String[3];
        init();
	}
	
	
	public CargarJuego getCargarJuego() {
		return cargarJuego;
	}
	
	

	public String[] getConfigJugador() {
		return config_jugador;
	}
	
	
	private void init() {
	    JPanel panel = new JPanel();
    	
    	panel.setPreferredSize(new Dimension(600, 350));
    	panel.setBackground(new Color(90,60,90));  
    	panel.setFocusable(true);   
    	panel.setLayout(null);
    	panel.setVisible(true);
		this.add(panel);			
		this.setTitle("Zombielandia");		
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
        
      
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/motivacion_3.png"));
		JLabel fondo = new JLabel(imagen,SwingConstants.CENTER);
		fondo = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(600, 350, Image.SCALE_SMOOTH)); 

		fondo.setIcon(imgdos);	
		fondo.repaint();	
		fondo.setBounds(0,0, 600, 350);
		this.setLayout(null);
		fondo.setLayout(null);
		
		ImageIcon img_select_player_b = new ImageIcon(getClass().getClassLoader().getResource("img/juego/rightplayer.png"));
		JLabel lb_player_b = new JLabel(img_select_player_b);
		lb_player_b.setBounds(500, 277, 100, 100);
		lb_player_b.repaint();
		
		ImageIcon img_select_player_a = new ImageIcon(getClass().getClassLoader().getResource("img/juego/leftplayer.png"));
		JLabel lb_player_a = new JLabel(img_select_player_a);
		lb_player_a.setBounds(0, 277, 100, 100);
		lb_player_a.repaint();
		

		lb_player_b.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
			        setVisible(false);

			        cargarJuego=new CargarJuego();;
					
					config_jugador[0]="img/jugador/juliefrente.gif";
					config_jugador[1]="img/jugador/juliefrente.gif";
					config_jugador[2]="img/jugador/juliefrente.gif";
				}
			 });
		
		lb_player_a.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		        setVisible(false);

		        cargarJuego= new CargarJuego();
				
				config_jugador[0]="img/jugador/juliefrente.gif";
				config_jugador[1]="img/jugador/juliefrente.gif";
				config_jugador[2]="img/jugador/juliefrente.gif";
			}
		 });
				
	     
		panel.add(fondo);
		fondo.add(lb_player_b);
		fondo.add(lb_player_a);
		panel.repaint();
    	
    
    }

 
	}