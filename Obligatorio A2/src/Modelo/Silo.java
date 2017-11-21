package Modelo;

public class Silo extends Punto {
	//Properties
	private int capacidadOriginal;
	private int capacidadRemanente;

	//Constructor
	public Silo(double coordenadaX, double coordenadaY, String nombre, int capacidad) {
		super(coordenadaX, coordenadaY, nombre);
		this.capacidadOriginal=capacidad;
		this.capacidadRemanente = capacidad;
	}

	//Getters y Setters 
	public int getCapacidadOriginal() {
		return capacidadOriginal;
	}

	public void setCapacidadOriginal(int capacidadOriginal) {
		this.capacidadOriginal = capacidadOriginal;
	}

	public int getCapacidadRemanente() {
		return capacidadRemanente;
	}

	public void setCapacidadRemanente(int capacidadRemanente) {
		this.capacidadRemanente = capacidadRemanente;
	}

	//ToString
	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return getCoordenadaX()+";"+getCoordenadaY()+";"+capacidadOriginal+";"+capacidadOriginal+"|" ;
	}
}
