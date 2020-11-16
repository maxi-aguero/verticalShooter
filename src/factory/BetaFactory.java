package factory;

import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public class BetaFactory extends InfectadoFactory{

	@Override
	public InfectadoAlpha getInfectadoAlpha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfectadoBeta getInfectadoBeta() {
		// TODO Auto-generated method stub
		return  new InfectadoBeta();
	}

	
	
	

}
