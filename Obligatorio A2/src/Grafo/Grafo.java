package Grafo;

import Modelo.Punto;

public class Grafo {

	private int size;
	private int cantNodos;
	private ListAdy [] listaAdyacencia;
	private boolean[] usados;
	
	
	public Grafo (int n) {
		
		this.size=0;
		this.cantNodos=n;
		this.listaAdyacencia = new ListAdy[this.cantNodos+1];
		for (int i = 0; i < this.cantNodos; i++) {
			this.listaAdyacencia[i]= new ListAdy();
		}
		this.usados = new boolean[this.cantNodos+1];
	}
	
	public boolean sonAdyacentes (int a, int b) {
		return this.listaAdyacencia[a].pertenece(b);
		
	}
	
	public void agregarArista(int origen, int destino, int peso) {
		//preguntar recursivo hasta que siguiente sea null
		//Punto puntoDestino = Hash.devolverPunto(destino);
		//NodoLista n = new NodoLista(puntoDestino);
		//n.setDistancia(distancia);
		//listaAdyacencia[origen].getInicio().setSiguiente(n);
		//setear en proximo en null?
		
		//hacer lo mismo para el destino con el punto origen
		this.listaAdyacencia[origen].insertar(destino, peso);
		
	}

	public void agregarVertice(int v) {
		this.usados[v]=true;
		this.size ++;
	}

	public void eliminarArista(int origen, int destino) {
		this.listaAdyacencia[origen].eliminar(destino);	
	}

	public boolean esVacio() {
		return this.size==0;
	}

	
	public void eliminarVertice(int v) {
		this.usados[v]=false;
		this.size --;
		
		//Elimino las aristas donde v es miembro
		this.listaAdyacencia[v] = new ListAdy();	
		//BUSCAR EN TODOS LOS VERTICES LA ARISTA
		for (int i = 1; i<=cantNodos; i++)
			this.listaAdyacencia[i].eliminar(v);	
	}

	public ListAdy verticesAdyacentes(int v) {
		return this.listaAdyacencia[v];
	}

	public boolean estaVertice(int v) {
		return this.usados[v];
	}

	//para agregar un punto al grafo 
	// llamar tambien al agregar vertice cuando se agregue
	public void insertar(Punto p, int pos) {		
		listaAdyacencia[pos].agregarPunto(p);
				
	}
	
	public boolean existePosicion(Double coordX, Double coordY) {
		
		return false;
	}
	public boolean isFull() {
		
		return cantNodos==size;
	}
	
	public void ingresar(Punto punto) {
		
		
	}
	
	
	
	
	
	
	
	
}
