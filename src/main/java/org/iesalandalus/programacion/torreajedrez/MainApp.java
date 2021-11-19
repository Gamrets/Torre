package org.iesalandalus.programacion.torreajedrez;
import org.iesalandalus.programacion.utilidades.Entrada;

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
	
	
	//Metodo para elegir opcion
	
	private int elegirOpcion() {

		int opcion = 0;

		do {
			System.out.println("Elige la opción: ");
			opcion = Entrada.entero();

		} while (opcion < 1 && opcion > 5);

		return opcion;

	}

	// Metodo para elegir color

	private Color elegirColor() {

		int opcionColor;
		do {
			
			System.out.print("Elige color:1->blanco, 2->negro: ");
			opcionColor = Entrada.entero();
			
		} while (opcionColor < 1 && opcionColor > 2);

		if (opcionColor == 1) {
			
			return Color.BLANCO;
		} else {
			
			return Color.NEGRO;
		}

	}

	public static void main(String[] args) {
		System.out.println("kk");
	}

}
