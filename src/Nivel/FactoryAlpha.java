package Nivel;

import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;

public class FactoryAlpha extends Factory{

	@Override
	protected Infectado getAlpha() {
		// TODO Auto-generated method stub
		return new InfectadoAlpha();
	}

	@Override
	protected Infectado getBeta() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
