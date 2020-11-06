package mapa;

import javax.swing.JFrame;

public class Juego extends JFrame {
	protected Mapa mapa;
	protected GUI gui;
	
	public Juego() {
		
		gui = new GUI();
		mapa = new Mapa(gui, this);
		
		 
	    this.add(gui);
	    this.setTitle("Zombielandia");
	    this.setResizable(false);
	    this.setVisible(true);
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
		//gui.setMapa(mapa);

	}
	

}
