package Main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

 
public class Loading extends JWindow {
     
    private int duracion;
  
    public Loading(int d) {
    	duracion = d;
    }
     

    public void mostrarLoading() {
        setBounds(257,216,509,335);
        
        ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("img/juego/loading.png"));
        JLabel label = new JLabel(imagen,SwingConstants.CENTER);
        label = new JLabel();
		Icon imgdos= new  ImageIcon(imagen.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH)); 

		label.setIcon(imgdos);	
		label.repaint();	
		label.setBounds(0,45, 700, 600);
		
		ImageIcon img_soda = new ImageIcon(getClass().getClassLoader().getResource("img/juego/soda.gif"));
		JLabel lbsoda = new JLabel(img_soda);
		lbsoda.setBounds(-7, 207, 100, 100);
		lbsoda.repaint();
		
		label.add(lbsoda);
        add(label, BorderLayout.CENTER);
        
        
        JLabel labelWait = new JLabel("please wait",SwingConstants.CENTER);     	
        labelWait.setFont(new Font("Ink Free", Font.BOLD, 28));        

        add(labelWait, BorderLayout.WEST);
        add(labelWait, BorderLayout.SOUTH);
       
        JPanel content = (JPanel)getContentPane();         
        content.setBorder(new LineBorder( Color.orange,2));        
        content.setBackground(new Color(90, 60, 90,177)); 

        setVisible(true);
        Thread load = new Thread();
        load.start();
        try { 
        	Thread.sleep(duracion); 
        	
        } catch (Exception e) {}

        load.stop();
        
        setVisible(false);
         
    }
    
}