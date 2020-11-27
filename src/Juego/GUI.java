package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	
	private JLabel lbfondo;
	public JProgressBar barra_vida;
	public JLabel palabra;
	public JLabel lbJugador;
	public JLabel lbanimacion;	
	
	public GUI() {
		
		this.setPreferredSize(new Dimension(850, 650));
        this.setBackground(new Color(90,60,90));  
        this.setFocusable(true);   
        this.setLayout(null);      
        crearFondo();
        //crear barra vida
        barra_vida= new JProgressBar(0,100);
    	barra_vida.setBounds(350,10, 300, 30);
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
		palabra=new JLabel("Plague Inc");
		palabra.setForeground(new Color(223, 45, 223)); 

		palabra.setFont(new Font("Ink Free", Font.BOLD, 40));
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
		
		for(Entidad obj2 : lista_entidad){ 			
 			obj2.getEntidadGrafica().getDibujo().setVisible(false);	     				 
 				
 		}
	}

	
public void gameWin(Juego juego){
		
		barra_vida.setVisible(false);
		lbfondo.setIcon(null);
		palabra.setText("Gane"); 
		
		
		palabra.setBounds(250,250, 300, 50);


		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		juego.setVisible(false);

		Main m= new Main();
		m.main(null);
		
	}
	
	 
	
	


}

