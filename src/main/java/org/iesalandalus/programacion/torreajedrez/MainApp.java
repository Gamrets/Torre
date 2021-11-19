package org.iesalandalus.programacion.torreajedrez;

public class MainApp {
	
	private static Torre torre;
	private static boolean salir;
	
	
	//Creando metodo para mostrar Torre
	
	private void mostrarTorre() {
		
		if(torre != null && salir == false) {
			
			System.out.println(torre);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("kk");
	}

}
