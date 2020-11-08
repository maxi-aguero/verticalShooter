package Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Entidad.Entidad;



public class Juego  extends  JFrame  {
	
	protected GUI gui;
	protected Movimiento movimiento;
	protected Mapa mapa;
	//protected Tienda tienda;
	protected int contadorDobleDanio;
	protected int contadorDobleOro;
	
	public Juego(){
		
		gui = new GUI();
		gui.setVisible(true);
		mapa = new Mapa(gui, this);
		//gui.setMapa(mapa);
		
		this.add(gui);
        this.setTitle("Zombielandia");
        //this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setFocusable(true);
          

        mapa.crearNivelUno(); 
        
        
		
		
		movimiento = new Movimiento(this);
		movimiento.run();
	}	

	public Mapa getMapa() {
		return mapa;
	}
	
	public GUI getGUI() {
		return gui;
	}
	
	public void interactuar() {	
		boolean puedoSeguirMoviendome;

//		System.out.println("Tamaño lista principal: "+mapa.getListaPrincipal().size());
//		System.out.println("Tamaño lista eliminar: "+mapa.getListaEliminar().size());
//		System.out.println("Tamaño lista agregar: "+mapa.getListaAgregar().size());
	
		
		
		for(Entidad obj : mapa.getListaPrincipal()) {
			if(obj.estaVivo()) {				/*
				obj.interactuar();
				*/
				puedoSeguirMoviendome = obj.interactuar();
				if( !puedoSeguirMoviendome ) 
					finDelJuego();
			}			
			else
				obj.morir();
		}
		
		for(Entidad obj : mapa.getListaEliminar()) {
			mapa.getListaPrincipal().remove(obj);
			obj.getDibujo().setVisible(false);
			obj = null;
		}
		mapa.resetLista(mapa.getListaEliminar());
		
		
		for(Entidad obj : mapa.getListaAgregar()) {
			mapa.getListaPrincipal().add(obj);
			gui.agregarDibujo(obj);
			//obj.setMapa(mapa);
		}		
		mapa.resetLista(mapa.getListaAgregar());
		
		
		for(Entidad obj : mapa.getListaPirata()) {
			mapa.getListaPrincipal().add(obj);
			gui.agregarDibujo(obj);
			//obj.setMapa(mapa);
		}
		
		
	}
	
	private void finDelJuego() {
		//movimiento.setDeboMover(false);
		//gui.gameOver();
		
	}

	public void activarContadorDobleDanio() {
		contadorDobleDanio = 5000;
	}

	public void activarContadorDobleOro() {
		contadorDobleOro = 5000;
	}
	

	
	
}

