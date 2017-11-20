package Grafo;

import Modelo.Punto;

public class NodoLista {

	Punto nodo;
	int distancia;
	NodoLista siguiente;
	int posicion;
	
	

	//contructor para tramo
	public NodoLista(Punto nodo, int peso, int pos) {
		
		this.nodo = nodo;
		this.distancia = peso;
		this.siguiente = null;
		this.posicion = pos;
	}
	
	
	
	// contructor inicial
	public NodoLista() {
		
		this.nodo = null;
		this.distancia = 0;
		this.siguiente = null;
		this.posicion=-1;
	}



	
	public int getPosicion() {
		return posicion;
	}



	public void setPosicion(int posicion) {
		this.posicion = posicion;
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
