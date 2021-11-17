package org.iesalandalus.programacion.torreajedrez;

public class Torre {

	// Atributos

	private Color color;
	private Posicion posicion;

	
	//Creo metodos Getters y Setters
	private void setPosicion(Posicion posicion) {

		this.posicion = posicion;
		
	}

	public Posicion getPosicion() {

		return this.posicion;
	}

	private void setColor(Color color) {

		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

}
