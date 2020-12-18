package Nivel;

public class NodoNivel {
	protected NodoNivel sig;
	protected Lista info;
	
	public NodoNivel(Lista listaNuevaNivel) {
		sig=null;
		info=listaNuevaNivel;
	}
	
	public NodoNivel getSiguiente() {
		return sig;
	}
	
	public Lista getInfoNivel() {
		return info;
	}
	
	public void setSiguienteNodoNivel(Lista l) {
		sig=new NodoNivel(l);
		
		
	}
	
	

}
