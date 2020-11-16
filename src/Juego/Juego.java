package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import Entidad.Entidad;
import EstrategiaMovimiento.MovimientoHorizontal;
import EstrategiaMovimiento.MovimientoVertical;
public class Juego  extends  javax.swing.JFrame implements ActionListener,KeyListener  {
	protected GUI gui;
	protected Mapa mapa;
	protected Timer tiempo;	
	protected List<Entidad> obj_eliminar;//infectados que elimino
	

	public Juego(){
		obj_eliminar=new LinkedList<Entidad>();
		mapa = new Mapa();	
		vinculargui();
		
        start(); 
	}
	

	private void start() {   	
        this.addKeyListener(this);
        gui.agregarDibujo(mapa.getJugador());	
        tiempo = new Timer(40, this);
        tiempo.start();
    }
	

	
	
	private void vinculargui() {
		gui = new GUI();
		gui.setVisible(true);
		this.add(gui);		
		this.setTitle("Zombielandia");		
        //this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);		
	}
	
	
	
	

	
	
	
	
	public void interactuar() {			
		//si la tanda es nula
		if (mapa.getTanda().getLista()==null)
			{	//"gane todas las tandas"
				gui.b.setVisible(false);
				
				
			}
		else
			{if (mapa.getTanda().esTandaVacia())
				{	
					//llenar
					mapa.getTanda().crearTanda();

					if (mapa.getTanda().getLista()!=null)
					{
						for(Entidad obj : mapa.getTanda().getLista()) {			
							gui.agregarDibujo(obj);							
							obj_eliminar.add(obj);
						}
						//vaciar tanda y lista1 eliminar la mitad
						gui.eliminarTodos(obj_eliminar,mapa.getListaN1(),mapa.getListaN2(),mapa.getTanda());//elimina tanda 1

					}
				
				}
			else {
					
					//los infectados se mueven
					for(Entidad obj :  mapa.getTanda().getLista()) {			
						
						Entidad elementoIntersectado = mapa.intersecta_algo(obj);
						if(elementoIntersectado!=null) 
							elementoIntersectado.accept(obj.getVisitor());
						else
						{
							obj.getDireccion().setDireccion(MovimientoVertical.ABAJO );
							obj.mover(obj.getDireccion());
						}	
					}
			}
		}
		
			
	
	}	
	
	

	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {

			case KeyEvent.VK_LEFT: {

				mapa.getJugador().getDireccion().setDireccion(MovimientoHorizontal.IZQUIERDA );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());
	        	break;
			}
			case KeyEvent.VK_RIGHT: {
				
				
				

				mapa.getJugador().getDireccion().setDireccion(MovimientoHorizontal.DERECHA );
				mapa.getJugador().mover(mapa.getJugador().getDireccion());
	        	break;
			}
		
		
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.interactuar();

		
	}
}

