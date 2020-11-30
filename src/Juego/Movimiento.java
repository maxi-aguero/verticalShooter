package Juego;

public class Movimiento extends Thread {

	
	private Juego juego;
	private boolean deboMover;	

	
	public Movimiento(Juego j) {
		juego = j;
		deboMover = true;
	}
	
	public void run() {		
		
		while(deboMover) {
			juego.interactuar();

		  
			
			try {
				Thread.sleep(40); // 40 anda bien
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			

		
		/**while(deboMover) {
			try {
				Thread.sleep(40); // 40 anda bien
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		
		
	}
	
	public boolean getMover(){ return deboMover ;}
	public void setDeboMover(boolean deboMover){ this.deboMover = deboMover ;}
	
		
	
		
		
		
}
	

