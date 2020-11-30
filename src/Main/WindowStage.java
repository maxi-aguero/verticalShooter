
package Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Juego.AudioPlayer;

public class WindowStage extends JFrame  {
	
	private Thread audio;

	public WindowStage(int nivel,int tanda) {	
        init(nivel,tanda);
	}
	
	
	

	
	private void init(int n,int t) {
	    JPanel panel = new JPanel();
    	
    	panel.setPreferredSize(new Dimension(500, 350));
    	panel.setBackground(new Color(0,0,0));   
    	panel.setFocusable(true);   
    	panel.setLayout(null);
    	panel.setVisible(true);
		this.add(panel);			
		this.setTitle("Zombielandia");		
        this.setResizable(false);
        this.pack();
        this.dispose();
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setLocationRelativeTo(null);        
        this.setFocusable(true);
        
        JPanel content = (JPanel)getContentPane();         
        content.setBackground(new Color(0,0,0));        
        
		ImageIcon imagen = null;
		if ( (t==0)&&(n==0))
			 imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/L1stage02.gif"));
		else
			if ( (t==1)&&(n==0))
				{ imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/L2stage01.gif"));}
					//falta mostrar level 2
			else
				{ imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/L2stage02.gif"));}
					//nivel 1, tanda 2, no tengo stage 2 en imagen
				
			

		JLabel fondo = new JLabel(imagen,SwingConstants.CENTER);
		fondo = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(600, 350, Image.SCALE_SMOOTH)); 

		fondo.setIcon(imgdos);	
		fondo.repaint();	
		fondo.setBounds(-45,0, 500, 350);
		this.setLayout(null);
		fondo.setLayout(null);
		
			
	     
		panel.add(fondo);
		panel.repaint();
		AudioPlayer ap = new AudioPlayer("src/img/juego/changedstage.mp3");
		audio = new Thread(ap);
		audio.start();
    	
    
    }

 
	}