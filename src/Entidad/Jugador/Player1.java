package Entidad.Jugador;

import javax.swing.ImageIcon;

import Visitor.VisitorJugador;

public class Player1 extends Player {
		
	public Player1() {
		super(0, 100, 5, 1, 20, 35, 30); 
		visitor = new VisitorJugador(this);				
		ruta_dibujo = "img/jugador/jugador.png";
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual<100?true:false;	
			
		
	}


	
	public void moverizquierda() {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo));		
		dibujo.setIcon(imagen);	
		
		
		int coordx = this.getDibujo().getX();
		if (coordx>0) {
			coordx = coordx - 2;		
			
			dibujo.setLocation(coordx,this.getDibujo().getY());
			}
		else
		{
			
			
			dibujo.setLocation(400,this.getY());
		}
		
	}

	@Override
	public void moverderecha() {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo));		
		dibujo.setIcon(imagen);	
		
		
		int coordx = this.getDibujo().getX();
		if (coordx<400) {
			coordx = coordx + 2;		
			
			dibujo.setLocation(coordx,this.getDibujo().getY());
			}
		else
		{
			
			
			dibujo.setLocation(0,this.getY());
		}		
	}

	@Override
	public boolean interactuar() {
		// TODO Auto-generated method stub
		return false;
	}	
	

}
