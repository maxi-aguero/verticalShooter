package Nivel;

import Entidad.Infectado.Infectado;
import Entidad.Infectado.InfectadoBeta;

public class FactoryBeta extends Factory{

	
	
	protected Infectado getInfectado() {
		// TODO Auto-generated method stub
		return new InfectadoBeta();
	}

	

}
