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

	// Metodo para enrocar

	public void enrocar(Direccion direccion) throws OperationNotSupportedException {

		switch (direccion) {
		case ENROQUE_CORTO: {
			if (color == Color.BLANCO) {

				if (posicion.getFila() == 1 && posicion.getColumna() == 'h') {

					setPosicion((new Posicion(posicion.getFila(), 'f')));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}

			} else {

				if (posicion.getFila() == 8 && posicion.getColumna() == 'h') {

					setPosicion((new Posicion(8, posicion.getColumna())));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
			}

			break;
		}

		case ENROQUE_LARGO: {

			if (color == Color.BLANCO) {
				if (posicion.getFila() == 1 && posicion.getColumna() == 'a') {

					setPosicion((new Posicion(posicion.getFila(), 'd')));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}

			} else {

				if (posicion.getFila() == 8 && posicion.getColumna() == 'd') {

					setPosicion((new Posicion(8, posicion.getColumna())));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}

			}
			break;
		}

		default:
		}
	}

	//Metodo de movimiento
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

	//metodos hashCode y equal automaticos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
		Torre other = (Torre) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	
	

}
