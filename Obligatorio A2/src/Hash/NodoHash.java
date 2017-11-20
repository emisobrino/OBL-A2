package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Punto;

public class NodoHash {
	//Properties	
	private Estado estado;
	private Punto dato;

	//Constructor con Punto 
	public NodoHash(Punto dato) {
		this.estado = EstadoHash.Estado.OCUPADO;//vacio? o ocupado
		this.dato = dato;
	}

	//Constructor vacio
	public NodoHash() {
		this.estado = EstadoHash.Estado.VACIO;
		this.dato = null;
	}

	//Obtener punto
	public Punto getDato() {
		return dato;
	}

	//Setear punto
	public void setDato(Punto dato) {
		this.dato = dato;
	}

	//Obtener estado
	public Estado getEstado() {
		return estado;
	}

	//Setear estado
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
