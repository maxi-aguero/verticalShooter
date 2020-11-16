package factory;

import Entidad.Infectado.InfectadoAlpha;
import Entidad.Infectado.InfectadoBeta;

public abstract class InfectadoFactory {
	public abstract InfectadoAlpha getInfectadoAlpha();
	public abstract InfectadoBeta getInfectadoBeta();
}
