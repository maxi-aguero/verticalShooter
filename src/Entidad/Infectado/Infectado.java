package Entidad.Infectado;


import Entidad.Entidad;
import Entidad.Personaje;
import Entidad.Proyectil.Proyectil;
import Entidad.Proyectil.ProyectilVirus;
import EstrategiaMovimiento.EstrategiaMovimiento;
import Mapa.MapaVirus;
import Visitor.Visitor;


public abstract class Infectado extends Personaje   {
	protected MapaVirus mapabalasgui;
	protected MapaVirus mapabalas;
	
	protected Infectado(int cargaViralActual, int cargaViralPierde, int rango) {

		super(cargaViralActual, cargaViralPierde, rango);
	}	
	
	public void setMapaBalasGUI(MapaVirus mb) {
		mapabalasgui=mb;
	}
	
	public MapaVirus getMapaBalasGUI() {
		return mapabalasgui;
	}	
	
	public void setMapaBalas(MapaVirus mb) {
		mapabalas=mb;
	}
	
	public MapaVirus getMapaBalas() {
		return mapabalas;
	}
	
	public void atacar(Entidad obj) {
		iniciarAtaque(obj);
		
		/**ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		if(vida>0) {  // si estoy vivo, ataco
			if(frecuencia_ataques%velocidad_ataque == 0)
				iniciarAtaque(obj);
			frecuencia_ataques++;
		} else
			morir();*/
	}
	
	public void iniciarAtaque(Entidad obj) {
		//posicion de balas

		//Infectado disparo = new InfectadoBeta();
		Proyectil disparo = new ProyectilVirus(this.getEntidadGrafica().getDibujo().getX(),this.getEntidadGrafica().getDibujo().getY());
		//Infectado disparo = new InfectadoAlpha();
		disparo.getEntidadGrafica().setX(this.getEntidadGrafica().getDibujo().getX());
		disparo.getEntidadGrafica().setY(this.getEntidadGrafica().getDibujo().getY());
		
		mapabalasgui.ponerBalasEnLista(disparo);
		mapabalas.ponerBalasEnLista(disparo);
		
		
		//punto== entidgrad grafica, hacer setx, sety
		//Punto p = new Punto(punto.getX()-disparo.getAncho()+10, punto.getY());
		//disparo.setPunto()
		//mapa lista_a_agregar significa la lista que se genera de manera dinamica
		//mapa.add(disparo); meto disparo en mapa
		
		/**ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));		
		dibujo.setIcon(imagen);
		Disparo disparo = new DisparoEnemigo(danio, null, rango);
		Punto p = new Punto(punto.getX()-disparo.getAncho()+10, punto.getY());
		disparo.setPunto(p);
		mapa.add(disparo);*/	
	}
	
	//public boolean interactuar() {		}

	public void mover(EstrategiaMovimiento d) {
		// TODO Auto-generated method stub
		d.mover();
	}	

	public void accept(Visitor v){
		v.visit(this);
	} 

}
