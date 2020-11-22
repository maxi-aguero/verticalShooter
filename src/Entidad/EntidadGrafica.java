package Entidad;

import javax.swing.JLabel;

public class EntidadGrafica {
	protected JLabel dibujo;// label de gui
	protected String ruta_dibujo;
	protected int coorInicialx;//coordenadas iniciales
	protected int coorInicialy;


	
	public EntidadGrafica() {}
	public JLabel getDibujo() { return dibujo ;}
	public void setDibujo(JLabel dibujo) { this.dibujo = dibujo ;}
	

	public String getImagen() {
		return ruta_dibujo;
	}
	
	public void setImagen(String s) {
		 ruta_dibujo=s;
	}
	
	public void setX(int x) {
		this.coorInicialx=x;
	}
	
	public int getX() {
		return coorInicialx;
	}
	
	public void setY(int y) {
		this.coorInicialy=y;
	}
	
	public int getY() {
		return coorInicialy;
	}
}
