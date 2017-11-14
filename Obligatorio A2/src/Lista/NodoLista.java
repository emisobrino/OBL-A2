package Lista;

import Modelo.Punto;

public class NodoLista {

	public Punto dato;
	private NodoLista siguiente;
	
	
	public NodoLista(Punto dato) {
		this.dato = dato;
		this.siguiente = null;
	}


	public Punto getDato() {
		return dato;
	}


	public void setDato(Punto dato) {
		this.dato = dato;
	}


	public NodoLista getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(NodoLista siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
	
	
}
