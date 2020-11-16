package factory;

import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class AlphaFactory extends InfectadoFactory{

	@Override
	public InfectadoAlpha getInfectadoAlpha() {
		// TODO Auto-generated method stub
		//crear y setear la posicion
		
		return new InfectadoAlpha();
	}

	@Override
	public InfectadoBeta getInfectadoBeta() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
