package Modelo;

public class Plantacion {
	//Properties
	private Productor propietario;
	private String tipo;
	private double produccionMensual;
	
	
	//Constructor
	public Plantacion(Productor propietario, String tipo, double produccionMensual) {
		super();
		this.propietario = propietario;
		this.tipo = tipo;
		this.produccionMensual = produccionMensual;
	}

	//Getters and Setters
	public Productor getPropietario() {
		return propietario;
	}

	public void setPropietario(Productor propietario) {
		this.propietario = propietario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getProduccion() {
		return produccionMensual;
	}

	public void setProduccion(double produccion) {
		this.produccionMensual = produccion;
	}
}
