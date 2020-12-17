package Nivel;

public class NodoNivel {
	protected NodoNivel sig;
	protected Lista info;
	
	public NodoNivel(Lista listaNuevaNivel) {
		sig=null;
		info=listaNuevaNivel;
	}
	/**
	public void agregarNivel1() {
		
		Lista nuevaListaNivel1=new Nivel1();
		NodoNivel nodoNuevo = new NodoNivel();
		nodoNuevo.sig=sig;
		nodoNuevo.info=nuevaListaNivel1;
		sig=nodoNuevo;		
	}
	
	public void agregarNivel2() {
		Lista nuevaListaNivel2=new Nivel2();
		NodoNivel nodoNuevo = new NodoNivel();
		nodoNuevo.info=nuevaListaNivel2;
		nodoNuevo.sig=null;
		sig.sig=nodoNuevo;		
		
	}
	
	
	public NodoNivel getPrimerNivel() {
		return sig;
	}
	
	public NodoNivel getSegundoNivel() {
		return sig.sig;
	}
	*/
	public NodoNivel getSiguiente() {
		return sig;
	}
	
	public Lista getInfoNivel() {
		return info;
	}
	
	public void setSiguienteNodoNivel(Lista listaNuevaNivel) {
		sig=new NodoNivel(listaNuevaNivel);
		
		
	}
	
	

}
