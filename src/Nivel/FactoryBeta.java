package Nivel;

import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoBeta;

public class FactoryBeta extends Factory{

	@Override
	protected Infectado getAlpha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Infectado getBeta() {
		// TODO Auto-generated method stub
		return new InfectadoBeta();
	}

	

}
