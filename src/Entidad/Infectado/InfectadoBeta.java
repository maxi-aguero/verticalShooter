package Entidad.Infectado;

import Visitor.VisitorInfectado;

public class InfectadoBeta extends Infectado {
		
	public InfectadoBeta() {
		super(40, 5, 100, 3, 20, 35, 30); 
		visitor = new VisitorInfectado(this);				
		ruta_dibujo = "img/infectados/beta.png";
		
	}
	
	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;	
	}		

}
