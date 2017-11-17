package Grafo;

import Modelo.Punto;

public class NodoLista {

	Punto nodo;
	int distancia;
	NodoLista siguiente;
	
	

	//contructor inicial
	public NodoLista(Punto nodo) {
		
		this.nodo = nodo;
		this.distancia = 0;
		this.siguiente = null;
	}
	
	
	
	// contructor vacio
	public NodoLista() {
		
		this.nodo = null;
		this.distancia = 0;
		this.siguiente = null;
	}




	public Punto getNodo() {
		return nodo;
	}
	public void setNodo(Punto nodo) {
		this.nodo = nodo;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public NodoLista getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoLista siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
