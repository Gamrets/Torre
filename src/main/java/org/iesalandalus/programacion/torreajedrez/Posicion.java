package org.iesalandalus.programacion.torreajedrez;

public class Posicion {

	//Declaro atributos fila y columna
	
	private int fila;
	private char columna;
	
	//Creo constructor
	
	public Posicion(int fila, char columna){
		
		setFila(fila);
		setColumna(columna);
	}
	
	//Creo constructor copia
	
     public Posicion(Posicion posicion){
    	 
    	 if (posicion == null) {
 			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
 		}
 		this.fila = posicion.getFila();
 		this.columna = posicion.getColumna();
	}

	//Creo metodos setter y getter
	
	private void setFila(int fila) {
		
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");

		} else {
			this.fila = fila;
		}
	}

	public int getFila() {
		return this.fila;
	}

	private void setColumna(char columna) {

		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");

		} else {
			this.columna = columna;

		}
	}
	
	public char getColumna() {
		return this.columna;
	}
	
	
	
	

}
