package Entidad.Infectado;

import Entidad.Entidad;
import Visitor.VisitorInfectado;

public class InfectadoAlpha extends Infectado {
		
	public InfectadoAlpha() {
		// cargaViralActual, cargaViralPierde±o, Rango, VelMov, VelAtaq, Puntos, Monedas
		super(100, 0, 100, 3, 20, 35, 30); 
		visitor = new VisitorInfectado(this);				
		ruta_dibujo = "img/infectados/alpha.png";
		
	}

	@Override
	public boolean estaVivo() {
		// TODO Auto-generated method stub
		return cargaViralActual>0?true:false;	
	}

	@Override
	public void iniciarAtaque(Entidad obj) {
		// TODO Auto-generated method stub
		
	}	
	

}
