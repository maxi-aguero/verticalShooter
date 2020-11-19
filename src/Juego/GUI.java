package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import Entidad.Entidad;
import Nivel.Lista_Nivel1;
import Nivel.Lista_Nivel2;
import Nivel.Tanda;

public class GUI extends JPanel  {
	
	/**
	 * 
	 */
	private JLabel fondo;
	public List<Entidad> mi_fabrica;//conjunto de elementos a eliminar
	public Lista_Nivel1 lista_a;//conjunto de elementos a eliminar
	public Lista_Nivel2 lista_b;//conjunto de elementos a eliminar
	public Tanda tanda_actual;
	public int cant;
	public JButton b,b2;
	public JProgressBar barra_vida;
	public GUI() {
		
		this.setPreferredSize(new Dimension(700, 650));
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
	
	public void eliminarTodos(List<Entidad> mi_fabrica,Lista_Nivel1 lista_nivel_1,Lista_Nivel2 lista_nivel_2,Tanda tanda_actual) {
		this.mi_fabrica=mi_fabrica;
		lista_a=lista_nivel_1;
		lista_b=lista_nivel_2;
		this.tanda_actual=tanda_actual;
		
		
	}
	
	
	
	
	
	
	private void crearFondo() {		
		
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/b8.jpg"));
		fondo = new JLabel(imagen,SwingConstants.CENTER);
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH)); 
	 	fondo.setIcon(imgdos);	
		fondo.repaint();	
		//fondo.setBounds(0,0, 700, 600);
		fondo.setBounds(0,45, 700, 600);
		this.setLayout(null);
		fondo.setLayout(null);
		JLabel palabra=new JLabel("Plague Inc");
		palabra.setForeground(new Color(223, 45, 223)); 

		palabra.setFont(new Font("Ink Free", Font.BOLD, 40));
		palabra.setBounds(70,2, 300, 50);
		
		///JLabel vida=new JLabel("vida");
		//vida.setBounds(400,3, 100, 1);
		
		
		b=new JButton("eliminar tanda 1");
		b.setBounds(800,5, 200, 50);
        b.addActionListener(new OyenteElimino()); 

    	b2=new JButton("eliminar tanda 2");
		b2.setBounds(800,75, 200, 50);
        b2.addActionListener(new OyenteElimino_tanda2()); 
        b2.setVisible(false);
        add(palabra);        
		add(fondo);
		add(b);
		add(b2);

		//add(vida);	

	
	}
	
	public void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getEntidadGrafica().getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getEntidadGrafica().getX(), e.getEntidadGrafica().getY(), 100, 100);
		e.getEntidadGrafica().setDibujo(lbdos);
		lbdos.repaint();

		fondo.add(lbdos);
		fondo.repaint();
		
	}
	
	
	public void estadoVida(double valor) {
		barra_vida.setValue((int) valor);		
		barra_vida.setString((int)valor+"/100v");
	
	}
	

	
	
	 private class OyenteElimino implements ActionListener{
	     	public void actionPerformed(ActionEvent e){      	 
	            b.setVisible(false);
	            b2.setVisible(true);
	            
	            
	            if (lista_a.getLista().size()==0){
	            	
	            	int[] arr_indice=new int[10];
		     		for(int k=0;k<10;k++){
		     			arr_indice[k]=99;
		     		}
		     		//elimino los objetos de la lista
		     		 for(Entidad obj2 : mi_fabrica){
		     			 
		     			 int xy=0;
			     		 for(Entidad obj : lista_b.getLista()){
			     			
			     			 if (obj==obj2)
			     				{obj2.getEntidadGrafica().getDibujo().setVisible(false);		     				 
			     				 arr_indice[xy]=xy;
			     				}
			     			xy++;
			     		}
	
	
		     		}
		     		for(int j=0;j<10;j++){
		     			if (arr_indice[j]!=99)
		     				lista_b.getLista().remove(arr_indice[j]);
		     		} 
		     		 
		     		tanda_actual.getLista().clear();
	            	
	            	
	            }
	            else
	            {
	            
		     		int[] arr_indice=new int[10];
		     		for(int k=0;k<10;k++){
		     			arr_indice[k]=99;
		     		}
		     		//elimino los objetos de la lista
		     		 for(Entidad obj2 : mi_fabrica){
			     		
		     			 int xy=0;
			     		 for(Entidad obj : lista_a.getLista()){
			     			
			     			 if (obj==obj2)
			     				{obj2.getEntidadGrafica().getDibujo().setVisible(false);		     				 
			     				 arr_indice[xy]=xy;
			     				}
			     			xy++;
			     		}
	
	
		     		}
		     		for(int j=0;j<10;j++){
		     			if (arr_indice[j]!=99)
		     				lista_a.getLista().remove(arr_indice[j]);
		     		} 
		     		 
		     		tanda_actual.getLista().clear();

	            }
	        	 

	         }        
	       }
	
	 
	 private class OyenteElimino_tanda2 implements ActionListener{
	     	public void actionPerformed(ActionEvent e){      	 
	     		b.setVisible(true);
	            b2.setVisible(false);
	            for(Entidad obj2 : mi_fabrica){
	            	obj2.getEntidadGrafica().getDibujo().setVisible(false);
	            }
	     		if(lista_a.getLista().size()!=0)
	     			lista_a.getLista().clear();
	     		else
	     			lista_b.getLista().clear();
	     		tanda_actual.getLista().clear();
	     		
	     		


	         }        
	       }
	
	


}

