package Modelo;

public class Plantacion extends Punto {
	//Properties
	private String CIProductor;
	private String tipo;
	private int produccionMensual;
	
	
	
	//Constructor
	public Plantacion(double coordenadaX, double coordenadaY, String nombre, String ciProductor,  int produccionMensual) {
		super(coordenadaX,coordenadaY,nombre);
		this.CIProductor = ciProductor;
		this.produccionMensual = produccionMensual;
		// acordarse del tipo al setear en las pruebas
	}

	//Getters and Setters
	public String getTipo() {
		return tipo;
	}

	public String getCIProductor() {
		return CIProductor;
	}

	public void setCIProductor(String cIProductor) {
		CIProductor = cIProductor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getProduccion() {
		return produccionMensual;
	}

	public void setProduccion(int produccion) {
		this.produccionMensual = produccion;
	}
}
