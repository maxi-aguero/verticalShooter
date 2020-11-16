package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SwingConstants;

import Entidad.Entidad;

public class GUI extends JPanel  {
	
	private JLabel fondo;
	public List<Entidad> mi_fabrica;//conjunto de elementos a eliminar
	public Lista_Nivel1 lista_a;//conjunto de elementos a eliminar
	public Lista_Nivel2 lista_b;//conjunto de elementos a eliminar
	public Tanda tanda_actual;
	public int cant;
	public JButton b,b2;
	public GUI() {
		
		this.setPreferredSize(new Dimension(700, 600));
        this.setBackground(new Color(90,60,90));  
        this.setFocusable(true);   
        this.setLayout(null);      
        crearFondo();
		

	}
	
	public void eliminarTodos(List<Entidad> mi_fabrica,Lista_Nivel1 lista_nivel_1,Lista_Nivel2 lista_nivel_2,Tanda tanda_actual) {
		this.mi_fabrica=mi_fabrica;
		lista_a=lista_nivel_1;
		lista_b=lista_nivel_2;
		this.tanda_actual=tanda_actual;
		
		
	}
	
	
	
	private void crearFondo() {		
		
		ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/background.png"));
		fondo = new JLabel(imagen,SwingConstants.CENTER);
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH)); 
	 	fondo.setIcon(imgdos);	
		fondo.repaint();	
		fondo.setBounds(0,0, 700, 600);
		this.setLayout(null);
		fondo.setLayout(null);
		JLabel palabra=new JLabel("Plague Inc");
		palabra.setForeground(new Color(223, 45, 223)); 

		palabra.setFont(new Font("Ink Free", Font.BOLD, 40));
		palabra.setBounds(70,2, 300, 50);
		
		JLabel vida=new JLabel("vida");
		//vida.setBounds(1000,5, 300, 150);
		
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
		//add(vida);	

	
	}
	
	public void agregarDibujo(Entidad e) {		
		
		ImageIcon img_entidad = new ImageIcon(getClass().getClassLoader().getResource(e.getImagen()));
		JLabel lbdos = new JLabel(img_entidad);
		lbdos.setBounds(e.getX(), e.getY(), 100, 100);
		e.setDibujo(lbdos);
		lbdos.repaint();

		fondo.add(lbdos);
		fondo.repaint();
		
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
			     				{obj2.getDibujo().setVisible(false);		     				 
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
			     				{obj2.getDibujo().setVisible(false);		     				 
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
	            	obj2.getDibujo().setVisible(false);
	            }
	     		if(lista_a.getLista().size()!=0)
	     			lista_a.getLista().clear();
	     		else
	     			lista_b.getLista().clear();
	     		tanda_actual.getLista().clear();
	     		
	     		


	         }        
	       }
	
	


}

