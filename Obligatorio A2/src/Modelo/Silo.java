package Modelo;

public class Silo extends Punto {

	private int capacidad;

	public Silo(double coordenadaX, double coordenadaY, String nombre, int capacidad) {
		super(coordenadaX, coordenadaY, nombre);
		this.capacidad=capacidad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
}
