package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Entidad.Entidad;
import Main.Main;


public class GUI extends JPanel  {
	
	
	private JLabel lbfondo;
	public JProgressBar barra_vida;
	public JLabel palabra;
	public JLabel lbJugador;
	public JLabel lbanimacion;	
	public JToggleButton bt_audio;
	private Thread audio;

	
	public GUI() {
		
		this.setPreferredSize(new Dimension(850, 650));
        this.setBackground(new Color(90,60,90));  
        this.setFocusable(true);   
        this.setLayout(null);      
        crearFondo();
        //crear barra vida
        barra_vida= new JProgressBar(0,100);
    	barra_vida.setBounds(160,10, 300, 30);
		barra_vida.setStringPainted(true);
		barra_vida.setFont(new Font("Ink Free", Font.BOLD, 25));
		barra_vida.setForeground(new Color(250, 40, 0));
		barra_vida.setBackground(new Color(1, 250, 250));		
		add(barra_vida);
		
	

	

	}
	

	
	
	
	

	
	
	
	private void crearFondo() {		
		
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/Level12.png"));
		lbfondo = new JLabel(imagen,SwingConstants.CENTER);
		lbfondo = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH)); 

		lbfondo.setIcon(imgdos);	
		lbfondo.repaint();	
		lbfondo.setBounds(0,45, 700, 600);
		this.setLayout(null);
		lbfondo.setLayout(null);
		palabra=new JLabel("Player");
		palabra.setForeground(new Color(223, 45, 223)); 

		palabra.setFont(new Font("Ink Free", Font.BOLD, 28));
		palabra.setBounds(70,2, 300, 50);
		//LineBorder linea = new LineBorder(Color.orange,1,true);
		//palabra.setBorder( new TitledBorder(linea,""));
		
		
		

	
		

        
    	ImageIcon img_soda = new ImageIcon(getClass().getClassLoader().getResource("img/juego/soda.gif"));
		lbanimacion = new JLabel(img_soda);
		lbanimacion.setBounds(-7, 207, 100, 100);
		lbanimacion.repaint();

		lbfondo.add(lbanimacion);
		lbfondo.repaint();
        
        add(palabra);        
		add(lbfondo);


	
	}
	
	public void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), e.getRangoX(), e.getRangoY());
		//LineBorder linea = new LineBorder(Color.orange,1,true);
		//lbdos.setBorder( new TitledBorder(linea,""));
		
		e.getEntidadGrafica().setDibujo(lbdos);//aca seteo el dibujo
		
		

		
		
		lbdos.repaint();


		lbfondo.add(lbdos);

		lbfondo.repaint();
		
	}
	
	
public void agregarDibujoJugador(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		lbJugador = new JLabel(img_entidad);

		lbJugador.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), e.getRangoX(), e.getRangoY());
		LineBorder linea = new LineBorder(Color.CYAN,1,true);
		lbJugador.setBorder( new TitledBorder(linea,""));
		
		e.getEntidadGrafica().setDibujo(lbJugador);
		lbJugador.repaint();

		lbfondo.add(lbJugador);
		lbfondo.repaint();
		
	}
	

public void setDibujoJugador(String s) {		
	
	ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(s));
	lbJugador.setIcon(img_entidad);
	lbJugador.repaint();

	lbfondo.add(lbJugador);
	lbfondo.repaint();
	
}

	public void estadoVida(double valor) {
		barra_vida.setValue((int) valor);		
		barra_vida.setString((int)valor+"/100v");
	
	}
	
	
	
	public void eliminacion(List<Entidad> lista_entidad) {
		
		//me marca como null obj2
		for(Entidad obj2 : lista_entidad){ 			
			if (obj2.getEntidadGrafica().getDibujo()!=null)
			obj2.getEntidadGrafica().getDibujo().setVisible(false);	     				 
 				
 		}
	}

	
public void gameWin(Juego juego){	


	
	ImageIcon img_vacas = new ImageIcon(getClass().getClassLoader().getResource("img/juego/vacas.gif"));
	
	JLabel lbvacas = new JLabel(img_vacas,SwingConstants.CENTER);
	lbvacas.setBounds(-83,0, 555,256);
	lbvacas.repaint();

	add(lbvacas);
	repaint();
	
	
	lbanimacion.setIcon(null);
	juego.setBounds(257,216,409,335);
	barra_vida.setVisible(false);
	lbfondo.setIcon(null);
	palabra.setText("");
	
	JLabel palabraYouLose = new JLabel("You win",SwingConstants.CENTER);     	
	palabraYouLose.setFont(new Font("Ink Free", Font.BOLD, 28));
	palabraYouLose.setForeground(new Color(250, 250, 250)); 
	juego.add(palabraYouLose, BorderLayout.SOUTH);

	JPanel content = (JPanel)juego.getContentPane();         
    content.setBorder(new LineBorder( Color.orange,2));        
    content.setBackground(new Color(0, 45, 0));
    
	AudioPlayer ap = new AudioPlayer("src/img/juego/vacasaudio.mp3");
	audio = new Thread(ap);
	audio.start();
	try {
		Thread.sleep(7940);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	
	
	juego.setVisible(false);
	audioOff(ap);
	Main m= new Main();
	m.main(null);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
}

public void gameYouLose(Juego juego,int player){
	
	
	
	ImageIcon img_gameover = new ImageIcon(getClass().getClassLoader().getResource("img/juego/gameover.gif"));
	
	JLabel lbgameover = new JLabel(img_gameover);
	lbgameover.setBounds(0,0, 390,100);
	lbgameover.repaint();

	add(lbgameover);
	repaint();
	ImageIcon img_dead =null;
	if (player==1)
		{ img_dead = new ImageIcon(getClass().getClassLoader().getResource("img/juego/zakedead.gif"));}
	else
		{img_dead = new ImageIcon(getClass().getClassLoader().getResource("img/juego/deadjulie.gif"));}

	
	JLabel lbdead = new JLabel(img_dead);
	lbdead.setBounds(150,100, 100,100);
	lbdead.repaint();

	add(lbdead);
	repaint();
	
	
	
	lbanimacion.setIcon(null);
	juego.setBounds(257,216,409,335);
	barra_vida.setVisible(false);
	lbfondo.setIcon(null);
	palabra.setText("");
	
	JLabel palabraYouLose = new JLabel("You Lose",SwingConstants.CENTER);     	
	palabraYouLose.setFont(new Font("Ink Free", Font.BOLD, 28));
	palabraYouLose.setForeground(new Color(223, 45, 223)); 
	juego.add(palabraYouLose, BorderLayout.SOUTH);
    this.setBackground(new Color(0,0,0));  

	
    AudioPlayer ap = new AudioPlayer("src/img/juego/jajajojojo.mp3");
	audio = new Thread(ap);
	audio.start();
	
	try {
		Thread.sleep(4500);
		//Thread.sleep(20000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	
	
	juego.setVisible(false);
	audioOff(ap);

	Main m= new Main();
	m.main(null);
	
	
}
	
	private void jToggleButtonAudioActionPerformed(ActionEvent evt) {
			/**if(this.bt_audio.isSelected()) {
				audioOff();
			} else {
				audioOn();
			}*/
	}
	
	private void audioOff(AudioPlayer ap) {
		//bt_audio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ar/edu/uns/cs/tdp/proyectoX/frames/resources/images/tdp-audio-off.png")));
		ap = null;
		audio.stop();
		//audio = null;
	}
	
	/**private void audioOn() {
		//jToggleButtonAudio.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ar/edu/uns/cs/tdp/proyectoX/frames/resources/images/tdp-audio-on.png")));
		ap = new AudioPlayer("img/juego/dangerzone.mp3");
		audio = new Thread(ap);
		audio.start();
	}*/
	
	


}

