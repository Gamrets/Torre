package org.iesalandalus.programacion.torreajedrez;

public class Torre {

	// Atributos

	private Color color;
	private Posicion posicion;

	//Constructor por defecto
	
	public Torre() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'h');
	}
	
	//Constructor que acepta parametros color
	
	public Torre(Color color) {
		
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'h');
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'h');
		}
		
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
	}
	
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
