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
	
	//Creo metodo para mostrar Menu de operaciones
	
	private void mostrarMenu(){
		
		System.out.println("1. Crear torre por defecto");
		System.out.println("2. Crear torre de un color");
		System.out.println("3. Crear torre de un color en una columna inicial dada");
		System.out.println("4. Mover torre");
		System.out.println("5. Salir");
	}
	
	public static void main(String[] args) {
		System.out.println("kk");
	}

}
