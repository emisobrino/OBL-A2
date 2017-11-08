package Modelo;

import java.util.regex.Pattern;

public class Productor {
	//Properties
	private String cedula;
	private String nombre;
	private String direccion;
	private String email;
	private String celular;
	
	
	//Constructor
	public Productor(String cedula, String nombre, String direccion, String email, String celular) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.celular = celular;
	}
	
	//Obtener cedula casteada a int sin simbolos
	public int getCedulaInt() {
		int cedulaFinal = 0;

		String[] partes = cedula.split(Pattern.quote("."));
		String part1 = partes[0];
		String part2 = partes[1];
		String part3 = partes[2];

		String[] pp = part3.split(Pattern.quote("-"));
		String pp4 = pp[0];
		String pp5 = pp[1];

		cedulaFinal = Integer.parseInt(part1 + part2 + pp4 + pp5);

		return cedulaFinal;
	}
	
	
	//Tostring
	@Override
	public String toString() {
	// TODO Auto-generated method stub
	return cedula+";"+nombre+";"+celular+"|" ;
	}
	
	//Getters y Setters
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
