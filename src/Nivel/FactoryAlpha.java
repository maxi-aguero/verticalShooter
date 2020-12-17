package Nivel;

import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoAlpha;

public class FactoryAlpha extends Factory{

	@Override
	protected Infectado getInfectado() {
		// TODO Auto-generated method stub
		return new InfectadoAlpha();
	}
	
}
