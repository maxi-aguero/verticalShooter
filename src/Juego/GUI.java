package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Entidad.Entidad;


public class GUI extends JPanel  {
	
	/**
	 * 
	 */
	private JLabel fondo;
	public List<Entidad> mis_virus;//conjunto de elementos a eliminar
	public int cant;
	public JProgressBar barra_vida;
	public JProgressBar[] barra_infectados;
	public JLabel lbJugador;
	
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
	

	
	public void eliminar_virus(List<Entidad> mis_virus) {
		this.mis_virus=mis_virus;
		
	}
	
	

	
	
	
	private void crearFondo() {		
		
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/Level12.png"));
		fondo = new JLabel(imagen,SwingConstants.CENTER);
		fondo = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH)); 

		fondo.setIcon(imgdos);	
		fondo.repaint();	
		fondo.setBounds(0,45, 700, 600);
		this.setLayout(null);
		fondo.setLayout(null);
		JLabel palabra=new JLabel("Plague Inc");
		palabra.setForeground(new Color(223, 45, 223)); 

		palabra.setFont(new Font("Ink Free", Font.BOLD, 40));
		palabra.setBounds(70,2, 300, 50);
		LineBorder linea = new LineBorder(Color.orange,1,true);
		palabra.setBorder( new TitledBorder(linea,""));
		
		
		

	
		

        
    	ImageIcon img_soda = new ImageIcon(getClass().getClassLoader().getResource("img/juego/soda.gif"));
		JLabel lbsoda = new JLabel(img_soda);
		lbsoda.setBounds(-7, 207, 100, 100);
		lbsoda.repaint();

		fondo.add(lbsoda);
		fondo.repaint();
        
        add(palabra);        
		add(fondo);

		//add(vida);	

	
	}
	
	public void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), e.getRangoX(), e.getRangoY());
		LineBorder linea = new LineBorder(Color.orange,1,true);
		//lbdos.setBorder( new TitledBorder(linea,""));
		
		e.getEntidadGrafica().setDibujo(lbdos);//aca seteo el dibujo
		
		

		
		
		lbdos.repaint();


		fondo.add(lbdos);

		fondo.repaint();
		
	}
	
	
public void agregarDibujoJugador(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		lbJugador = new JLabel(img_entidad);

		lbJugador.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), e.getRangoX(), e.getRangoY());
		LineBorder linea = new LineBorder(Color.CYAN,1,true);
		lbJugador.setBorder( new TitledBorder(linea,""));
		
		e.getEntidadGrafica().setDibujo(lbJugador);
		lbJugador.repaint();

		fondo.add(lbJugador);
		fondo.repaint();
		
	}
	

public void setDibujoJugador(String s) {		
	
	ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(s));
	lbJugador.setIcon(img_entidad);
	lbJugador.repaint();

	fondo.add(lbJugador);
	fondo.repaint();
	
}

	public void estadoVida(double valor) {
		barra_vida.setValue((int) valor);		
		barra_vida.setString((int)valor+"/100v");
	
	}
	
	public void ponerProgressBar(int n) {
		barra_infectados= new JProgressBar[n];
		//configurar los JProgressBar
		int j=10;
		for (int i=0;i<n;i++) {
			barra_infectados[i]= new JProgressBar(0,100);
			barra_infectados[i].setValue((int) 100);
			barra_infectados[i].setBounds(700,j, 150, 30);//c
			j=j+70;
			barra_infectados[i].setStringPainted(true);
			barra_infectados[i].setFont(new Font("Ink Free", Font.BOLD, 25));
			barra_infectados[i].setForeground(new Color(250, 40, 0));
			barra_infectados[i].setBackground(new Color(1, 250, 250));
			add(barra_infectados[i]);

		}
		
	

	}
	
	public void eliminacion(List<Entidad> mi_fabrica) {
		
		for(Entidad obj2 : mi_fabrica){ 			
 			obj2.getEntidadGrafica().getDibujo().setVisible(false);	     				 
 				
 		}
	}

	
	
	 
	
	


}

