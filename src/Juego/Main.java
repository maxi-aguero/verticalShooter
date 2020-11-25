package Juego;



public class Main {
	private static WindowInicio ventana;
	private static WindowDialogos ventanaDialogo;
	private static Loading loading;
	private static Juego nuevojuego;
	public Main() {}
	
		
	public static void main(String[] args) {
		 ventana = new WindowInicio();  
	     ventana.setVisible(true);
	     while(ventana.getIniciar()!=true){}	
	     ventana.setVisible(false);	
	     ventanaDialogo = new WindowDialogos();
	     ventanaDialogo.setVisible(true);
	     while(ventanaDialogo.getIniciar()!=true){}	
	     ventanaDialogo.setVisible(false);
	     loading= new Loading(14000); 
	     loading.mostrarLoading();
	     nuevojuego= new Juego();
		 nuevojuego.requestFocus();
		 
		
		

	}
}
