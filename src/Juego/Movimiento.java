package Juego;

public class Movimiento extends Thread {
	
	private boolean deboMover;	
	
	public Movimiento() {
		deboMover = true;
	}
	
	public void run(Juego juego) {			
		while(deboMover) {
			juego.interactuar();		  
			
			try {
				Thread.sleep(40);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		
			
	}
	
	public boolean getMover(){ return deboMover ;}
	public void setDeboMover(boolean deboMover){ this.deboMover = deboMover ;}
		
}
	

