package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {

	// Atributos

	private Color color;
	private Posicion posicion;

	// Constructor por defecto

	public Torre() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'h');
	}

	// Constructor que acepta parametros color

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

	// Creo constructor que acepta color y columna inicial

	public Torre(Color color, char columnaInicial) {

		setColor(color);

		if (columnaInicial != 'a' && columnaInicial != 'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, columnaInicial);
		} else if (color == Color.NEGRO) {
			posicion = new Posicion(8, columnaInicial);
		}
	}

	// Creo metodos Getters y Setters
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

	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {

		if (pasos <= 0) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		}

		if (direccion == null) {

			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}

		try {

			switch (direccion) {

			case ARRIBA: {
				if (color == Color.BLANCO) {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
				} else {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
				}
				break;
			}
			case ABAJO: {
				if (color == Color.NEGRO) {
					setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
				} else {
					setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
				}
				break;
			}
			case IZQUIERDA: {
				if (color == Color.BLANCO) {

					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
				} else {

					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
				}
				break;
			}
			case DERECHA: {
				if (color == Color.BLANCO) {

					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
				} else {

					setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
				}
				break;
			}
			default:
			}
		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
		}

	}

}
