package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Entidad.Entidad;
import Main.Main;


public class GUI extends JPanel  {
	
	
	private JLabel lbFondo;
	private JProgressBar barraVida;
	private JLabel lbPlayer;
	private JLabel lbJugador;
	private JLabel lbAnimacion;	
	private JPanel []panelDescrip;
	private JLabel [] descrip;
	
	public GUI() {		
		setPreferredSize(new Dimension(820, 650));
        setBackground(new Color(90,60,90));  
        setFocusable(true);   
        setLayout(null);      
        crearFondo();
        barraVida= new JProgressBar(0,100);
        barraVida.setBounds(160,10, 300, 30);
        barraVida.setStringPainted(true);
        barraVida.setFont(new Font("Ink Free", Font.BOLD, 25));
		barraVida.setForeground(new Color(250, 40, 0));
		barraVida.setBackground(new Color(1, 250, 250));		
		add(barraVida);
	}
	
	
	private void crearFondo() {				
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/Level12.png"));
		lbFondo = new JLabel(imagen,SwingConstants.CENTER);
		lbFondo = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH)); 

		lbFondo.setIcon(imgdos);	
		lbFondo.repaint();	
		lbFondo.setBounds(0,45, 700, 600);
		lbFondo.setLayout(null);
		lbPlayer=new JLabel("Player");
		lbPlayer.setForeground(new Color(223, 45, 223)); 

		lbPlayer.setFont(new Font("Ink Free", Font.BOLD, 28));
		lbPlayer.setBounds(70,2, 300, 50);		

        
    	ImageIcon img_soda = new ImageIcon(getClass().getClassLoader().getResource("img/juego/soda.gif"));
		lbAnimacion = new JLabel(img_soda);
		lbAnimacion.setBounds(-7, 207, 100, 100);
		lbAnimacion.repaint();

		lbFondo.add(lbAnimacion);
		
		panelDescrip=new JPanel[4];
		descrip=new JLabel[12];

		
		panelDescrip[0]=new JPanel();
		panelDescrip[0].setBounds(700, 45, 100, 60);		
		panelDescrip[0].setLayout(new GridLayout(2,0));     
		LineBorder linea = new LineBorder(Color.orange,1,true);
		panelDescrip[0].setBorder( new TitledBorder(linea,""));

		panelDescrip[1]=new JPanel();
		panelDescrip[1].setBounds(700, 115, 100, 90);
		panelDescrip[1].setLayout(new GridLayout(2,1));     
		panelDescrip[1].setBorder( new TitledBorder(linea,""));
		
		panelDescrip[2]=new JPanel();
		panelDescrip[2].setBounds(700, 215, 100, 90);
		panelDescrip[2].setLayout(new GridLayout(2,0));     
		panelDescrip[2].setBorder( new TitledBorder(linea,""));
		
		panelDescrip[3]=new JPanel();
		panelDescrip[3].setBounds(700, 310, 100, 60);
		panelDescrip[3].setLayout(new GridLayout(2,0));     
		panelDescrip[3].setBorder( new TitledBorder(linea,""));
		
		descrip[0]=new JLabel("");
		ImageIcon img_azul = new ImageIcon(getClass().getClassLoader().getResource("img/juego/posionazul.png"));
		descrip[0].setHorizontalAlignment(JLabel.CENTER);
		descrip[0].setVerticalAlignment(JLabel.TOP);
		descrip[0].setIcon(img_azul); 
		descrip[0].setOpaque(true);
		descrip[0].setBackground(new Color(75,0,150,250)); 
		descrip[0].repaint();

		descrip[1]=new JLabel("Max Vida");
		descrip[1].setHorizontalAlignment(JLabel.CENTER);
		descrip[1].setVerticalAlignment(JLabel.TOP);
		descrip[1].setOpaque(true);
		descrip[1].setForeground(new Color(0, 150, 0)); 
		descrip[1].setBackground(new Color(75,0,150,250)); 
		descrip[1].setFont(new Font("Ink Free", Font.BOLD, 14));   
		descrip[1].repaint();	

		panelDescrip[0].add(descrip[0]);
		panelDescrip[0].add(descrip[1]);
		
		
		descrip[2]=new JLabel("");
		ImageIcon img_amarilla = new ImageIcon(getClass().getClassLoader().getResource("img/juego/posionamarilla.png"));
		descrip[2].setHorizontalAlignment(JLabel.CENTER);
		descrip[2].setVerticalAlignment(JLabel.TOP);
		descrip[2].setIcon(img_amarilla); 
		descrip[2].setOpaque(true);
		descrip[2].setBackground(new Color(75,0,150,250)); 
		descrip[2].repaint();

		
		descrip[3]=new JLabel("Mas Velocidad");		
		descrip[3].setHorizontalAlignment(JLabel.CENTER);
		descrip[3].setVerticalAlignment(JLabel.TOP);		
		descrip[3].setOpaque(true);
		descrip[3].setForeground(new Color(0, 150, 0)); 
		descrip[3].setBackground(new Color(75,0,150,250)); 
		descrip[3].setFont(new Font("Ink Free", Font.BOLD, 14));   
		descrip[3].repaint();
		
		descrip[4]=new JLabel("al jugador");
		descrip[4].setHorizontalAlignment(JLabel.CENTER);
		descrip[4].setVerticalAlignment(JLabel.TOP);	
		descrip[4].setOpaque(true);
		descrip[4].setForeground(new Color(0, 150, 0)); 
		descrip[4].setBackground(new Color(75,0,150,250));
		descrip[4].setFont(new Font("Ink Free", Font.BOLD, 14));
		descrip[4].setBounds(710, 176, 80, 25);
		descrip[4].repaint();		
		
		panelDescrip[1].add(descrip[2]);
		panelDescrip[1].add(descrip[3]);
		
		
		descrip[5]=new JLabel("",SwingConstants.CENTER);
		ImageIcon img_verde = new ImageIcon(getClass().getClassLoader().getResource("img/juego/posionverde.png"));
		descrip[5].setIcon(img_verde); 
		descrip[5].setOpaque(true);
		descrip[5].setBackground(new Color(75,0,150,250)); 
		descrip[5].repaint();
		
		descrip[6]=new JLabel("Quieto 5 seg");
		descrip[6].setHorizontalAlignment(JLabel.CENTER);
		descrip[6].setVerticalAlignment(JLabel.TOP);
		descrip[6].setOpaque(true);
		descrip[6].setForeground(new Color(0, 150, 0)); 
		descrip[6].setBackground(new Color(75,0,150,250)); 
		descrip[6].setFont(new Font("Ink Free", Font.BOLD, 14));   
		descrip[6].repaint();
		
		panelDescrip[2].add(descrip[5]);
		panelDescrip[2].add(descrip[6]);
		
		descrip[7]=new JLabel("",SwingConstants.CENTER);
		ImageIcon img_roja = new ImageIcon(getClass().getClassLoader().getResource("img/juego/posionroja.png"));
		descrip[7].setIcon(img_roja); 
		descrip[7].setOpaque(true);
		descrip[7].setBackground(new Color(75,0,150,250)); 
		descrip[7].repaint();
		
		descrip[8]=new JLabel("Super arma");
		descrip[8].setHorizontalAlignment(JLabel.CENTER);
		descrip[8].setVerticalAlignment(JLabel.TOP);
		descrip[8].setOpaque(true);
		descrip[8].setForeground(new Color(0, 150, 0)); 
		descrip[8].setBackground(new Color(75,0,150,250)); 
		descrip[8].setFont(new Font("Ink Free", Font.BOLD, 14));   
		descrip[8].repaint();		
		
		panelDescrip[3].add(descrip[7]);
		panelDescrip[3].add(descrip[8]);


		descrip[9]=new JLabel("Alpha",SwingConstants.LEADING);
		ImageIcon img_alpha = new ImageIcon(getClass().getClassLoader().getResource("img/infectados/zombie.gif"));
		descrip[9].setIcon(img_alpha); 
		descrip[9].setOpaque(true);
		descrip[9].setBorder( new TitledBorder(linea,""));
		descrip[9].setForeground(new Color(0, 150, 0)); 
		descrip[9].setBackground(new Color(75,0,150,250)); 
		descrip[9].setFont(new Font("Ink Free", Font.BOLD, 14));   
		descrip[9].setBounds(700, 380, 100, 80);
		descrip[9].setLayout(null);
		descrip[9].repaint();
		
		descrip[10]=new JLabel("Beta",SwingConstants.LEADING);
		ImageIcon img_beta = new ImageIcon(getClass().getClassLoader().getResource("img/infectados/stanley.gif"));
		descrip[10].setIcon(img_beta); 
		descrip[10].setOpaque(true);
		descrip[10].setBorder( new TitledBorder(linea,""));
		descrip[10].setForeground(new Color(0, 150, 0)); 
		descrip[10].setBackground(new Color(75,0,150,250)); 
		descrip[10].setFont(new Font("Ink Free", Font.BOLD, 14)); 
		descrip[10].setBounds(700, 470, 100, 80);
		descrip[10].setLayout(null);
		descrip[10].repaint();
		
		
		descrip[11]=new JLabel("");
		ImageIcon img_control = new ImageIcon(getClass().getClassLoader().getResource("img/juego/contr.png"));
		Icon imgSize_control= new  ImageIcon(img_control.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)); 
		descrip[11].setIcon(imgSize_control); 	 
		descrip[11].setHorizontalAlignment(JLabel.CENTER);
		descrip[11].setVerticalAlignment(JLabel.TOP);
		descrip[11].setOpaque(true);
		descrip[11].setBorder( new TitledBorder(linea,""));
		descrip[11].setForeground(new Color(0, 150, 0)); 
		descrip[11].setBackground(new Color(75,0,150,250)); 
		descrip[11].setFont(new Font("Ink Free", Font.BOLD, 14));   
		descrip[11].setBounds(700, 560, 100, 80);
		descrip[11].setLayout(null);
		descrip[11].repaint();
		
		add(descrip[4]);
		add(panelDescrip[0]);
		add(panelDescrip[1]);
		add(panelDescrip[2]);
		add(panelDescrip[3]);
		add(descrip[9]);
		add(descrip[10]);
		add(descrip[11]);		
		
		lbFondo.repaint();        
        add(lbPlayer);        
		add(lbFondo);
	
	}
	
	public void agregarEntidad(Entidad e) {				
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		JLabel lbEntidad = new JLabel(img_entidad);
		lbEntidad.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), e.getRangoX(), e.getRangoY());
		e.getEntidadGrafica().setDibujo(lbEntidad);		
		lbEntidad.repaint();
		lbFondo.add(lbEntidad);
		lbFondo.repaint();		
	}
	
	
	public void agregarJugador(Entidad e) {				
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		lbJugador = new JLabel(img_entidad);
		lbJugador.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), e.getRangoX(), e.getRangoY());
		LineBorder linea = new LineBorder(Color.CYAN,1,true);
		lbJugador.setBorder( new TitledBorder(linea,""));		
		e.getEntidadGrafica().setDibujo(lbJugador);
		lbJugador.repaint();
		lbFondo.add(lbJugador);
		lbFondo.repaint();		
	}
	

	public void setDibujoJugador(String s) {			
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(s));
		lbJugador.setIcon(img_entidad);
		lbJugador.repaint();	
		lbFondo.add(lbJugador);
		lbFondo.repaint();
		
	}

	public void estadoVida(double valor) {
		barraVida.setValue((int) valor);		
		barraVida.setString((int)valor+"/100v");	
	}
	
	
	
	public void eliminarEntidades(List<Entidad> lista_entidad) {
		
		for(Entidad obj2 : lista_entidad){ 			
			if (obj2.getEntidadGrafica().getDibujo()!=null)
			{obj2.getEntidadGrafica().getDibujo().setVisible(false);
			 obj2=null; 
			}	     				 
 				
 		}
	}

	
	public void gameWin(Juego juego){	
		
		for(JPanel pDesc:panelDescrip) {
			pDesc.setVisible(false);
		}
		
		for( JLabel lbDesc:descrip) {
			lbDesc.setVisible(false);
		}
		
		ImageIcon img_vacas = new ImageIcon(getClass().getClassLoader().getResource("img/juego/vacas.gif"));
		
		JLabel lbvacas = new JLabel(img_vacas,SwingConstants.CENTER);
		lbvacas.setBounds(-83,0, 555,256);
		lbvacas.repaint();
	
		add(lbvacas);
		repaint();
		
	
		lbAnimacion.setIcon(null);
		juego.setBounds(257,216,409,335);
		barraVida.setVisible(false);
		lbFondo.setIcon(null);
		lbPlayer.setText("");
		
		JLabel palabraYouLose = new JLabel("You win",SwingConstants.CENTER);     	
		palabraYouLose.setFont(new Font("Ink Free", Font.BOLD, 28));
		palabraYouLose.setForeground(new Color(250, 250, 250)); 
		juego.add(palabraYouLose, BorderLayout.SOUTH);
	
		JPanel content = (JPanel)juego.getContentPane();         
	    content.setBorder(new LineBorder( Color.orange,2));        
	    content.setBackground(new Color(0, 45, 0));
	    
	    Thread verYouWin = new Thread();
	    verYouWin.start();
		try {
			Thread.sleep(7940);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		juego.setVisible(false);
		Main m= new Main();
		m.main(null);	
		
				
	}
	
	public void gameYouLose(Juego juego,int player){
	
		for(JPanel pDesc:panelDescrip) {
			pDesc.setVisible(false);
		}
		
		for( JLabel lbDesc:descrip) {
			lbDesc.setVisible(false);
		}
		
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
		
		
		
		lbAnimacion.setIcon(null);
		juego.setBounds(257,216,409,335);
		barraVida.setVisible(false);
		lbFondo.setIcon(null);
		lbPlayer.setText("");
		
		JLabel palabraYouLose = new JLabel("You Lose",SwingConstants.CENTER);     	
		palabraYouLose.setFont(new Font("Ink Free", Font.BOLD, 28));
		palabraYouLose.setForeground(new Color(223, 45, 223)); 
		juego.add(palabraYouLose, BorderLayout.SOUTH);
	    this.setBackground(new Color(0,0,0));  
	
		
	    Thread verYouLose = new Thread();
	    verYouLose.start();
		
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
		
		juego.setVisible(false);
		juego=null;

		Main m= new Main();
		m.main(null);
		
		
	}
		
	
		
	
		
		


}

