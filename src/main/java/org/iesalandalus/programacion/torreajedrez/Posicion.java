package org.iesalandalus.programacion.torreajedrez;

public class Posicion {

	// Declaro atributos fila y columna

	private int fila;
	private char columna;

	// Creo constructor

	public Posicion(int fila, char columna) {

		setFila(fila);
		setColumna(columna);
	}

	// Creo constructor copia

	public Posicion(Posicion posicion) {

		if (posicion == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();
	}

	// Creo metodos setter y getter

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

	// Creo metodos equals y hashCode(de forma automatica)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}

	// Creo metodo toString

	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}
}
