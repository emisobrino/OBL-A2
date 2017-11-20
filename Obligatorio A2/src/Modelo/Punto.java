package Modelo;

public class Punto {
	//Properties
	private String nombre;
	private double coordenadaX;
	private double coordenadaY;
	
	//Constructor
	public Punto(double coordenadaX, double coordenadaY, String nombre) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.nombre= nombre;
	}

	public Punto() {
		
	}

	//Getters and Setters
	public double getCoordenadaX() {
		return coordenadaX;
	}


	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}


	public double getCoordenadaY() {
		return coordenadaY;
	}


	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
