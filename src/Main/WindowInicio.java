
package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Juego.AudioPlayer;



public class WindowInicio extends JFrame  {
	private WindowDialogos ventana2;
	private Thread audio;
	private AudioPlayer ap;

	
	public WindowInicio() {	  
		 	
	        init();
	      
	}
	
	public AudioPlayer getAudio() {
		return ap;
	}
	
	
	public Thread getHiloAudio() {
		return audio;
	}
	
	public void crarAudio() {
		 	 ap = new AudioPlayer("src/img/juego/introsam.mp3");
			audio = new Thread(ap);
			audio.start();
	}
	
	public void setDuracion(int duracion) {
		
		
		try {
			Thread.sleep(duracion);
			//Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 


	public WindowDialogos getDialogos(){
		return ventana2;
	}
	    
	private void init() {
	    JPanel panel = new JPanel();
    	
    	panel.setPreferredSize(new Dimension(850, 650));
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
      
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/inicio.png"));
		JLabel fondo = new JLabel(imagen,SwingConstants.CENTER);
		fondo = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(850, 650, Image.SCALE_SMOOTH)); 

		fondo.setIcon(imgdos);	
		fondo.repaint();	
		fondo.setBounds(0,0, 850, 650);
		this.setLayout(null);
		fondo.setLayout(null);
		
		
		
		ImageIcon img_start = new ImageIcon(getClass().getClassLoader().getResource("img/juego/start.png"));
		JLabel lbstart = new JLabel(img_start);
		lbstart.setBounds(177, 177, 500, 500);
		lbstart.repaint();
		
		

		lbstart.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
			         setVisible(false);
			         

					ventana2=new WindowDialogos();

				}
			 });
				
	     
		panel.add(fondo);
		fondo.add(lbstart);
		panel.repaint();
    	
    
    }

 
	}