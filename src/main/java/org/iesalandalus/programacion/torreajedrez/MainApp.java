package org.iesalandalus.programacion.torreajedrez;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private static Torre torre;
	private static boolean salir;
	
	
	//Creando metodo para mostrar Torre
	
	private static void mostrarTorre() {
		
		if(torre != null && salir == false) {
			
			System.out.println(torre);
		}
	}
	
	//Creo metodo para mostrar Menu de operaciones
	
	private static void mostrarMenu(){
		
		System.out.println("1. Crear torre por defecto");
		System.out.println("2. Crear torre de un color");
		System.out.println("3. Crear torre de un color en una columna inicial dada");
		System.out.println("4. Mover torre");
		System.out.println("5. Salir");
	}
	
	
	//Metodo para elegir opcion
	
	private static int elegirOpcion() {

		int opcion = 0;

		do {
			System.out.println("Elige la opción: ");
			opcion = Entrada.entero();

		} while (opcion < 1 && opcion > 5);

		return opcion;

	}

	// Metodo para elegir color

	private static Color elegirColor() {

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

	// metodo para elegir columna inicial

	private static char elegirColumnaInicial() {

		char opcionColumnaInicial;
		do {
			System.out.print("Introduce la columna inicial (a o h): ");

			opcionColumnaInicial = Entrada.caracter();

		} while (opcionColumnaInicial != 'a' && opcionColumnaInicial != 'h');

		return opcionColumnaInicial;
	}

	// Metodo para mostrar menu de direcciones

	private static void mostrarMenuDirecciones() {
		System.out.println("1. Arriba");
		System.out.println("2. Abajo");
		System.out.println("3. Izquierda");
		System.out.println("4. Derecha");
		System.out.println("5. Enroque Corto");
		System.out.println("6. Enroque Largo");
	}
	
	// Metodo para elegir Direccion
	
	private static Direccion elegirDireccion() {
		
		int opcionDireccion;
		
		do {
			System.out.print("Introduce una opción: ");
			opcionDireccion = Entrada.entero();

		} while (opcionDireccion < 1 || opcionDireccion > 6);

		Direccion direccion = null;
		
		switch (opcionDireccion) {
		case 1:
			direccion = Direccion.ARRIBA;
			break;
		case 2:
			direccion = Direccion.ABAJO;
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			break;
		case 4:
			direccion = Direccion.DERECHA;
			break;
		case 5:
			direccion = Direccion.ENROQUE_CORTO;
			break;
		case 6:
			direccion = Direccion.ENROQUE_LARGO;
			break;
		default:

		}
		return direccion;
	}
	
	//Metodo para crear torre por defecto
	
	private static void crearTorreDefecto() {
		
		torre = new Torre();
	}
	
	//Metodo para crear torre en colo
	private static void crearTorreColor() {
		
		Color color = elegirColor();
		torre = new Torre(color);
	}
	
	private static void crearTorreColoColumna() {
		
		Color color = elegirColor();
		char columnaIncial = elegirColumnaInicial();
		torre = new Torre(color,columnaIncial);
	}
	
	//Metodo para mover la torre
	
	private static  void mover() throws OperationNotSupportedException {
		if (torre == null) {
			System.out.println("Debes crear una torre antes de moverla.");

			return;
		}
		mostrarMenuDirecciones();
		Direccion direccion = elegirDireccion();
		
		if (direccion != Direccion.ENROQUE_CORTO && direccion != Direccion.ENROQUE_LARGO) {
			System.out.print("¿Cuántos pasos quieres que dé la torre?: ");
			int pasos = Entrada.entero();
				torre.mover(direccion, pasos);
		} else {
			
				torre.enrocar(direccion);
				if (direccion == Direccion.ENROQUE_CORTO ) {
				System.out.println("Se realizo enroque corto.");
				} else {
					System.out.println("Se realizo enroque largo.");
				}		
			
		}
	}
	
	//metodo para ejecutar opcion
	
	private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
		switch (opcion) {
		case 1:

			crearTorreDefecto();
			break;
		case 2:

			crearTorreColor();
			break;
		case 3:

			crearTorreColoColumna();
			break;
		case 4:

			mover();
			break;
		case 5:
			salir = true;
			break;
		default:
			break;
		}
	}
	
	
	//metodo main
	public static void main(String[] args) throws OperationNotSupportedException {
		do {
			mostrarMenu();
			ejecutarOpcion(elegirOpcion());
			mostrarTorre();
		} while (!salir);
		System.out.println("Se acabo.");

	}

}
