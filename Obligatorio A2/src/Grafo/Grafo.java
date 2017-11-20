package Grafo;

import Hash.Hash;
import Modelo.Punto;

public class Grafo {

	//Properties
	private int size;
	private int cantNodosActual;
	private int largo;
	private ListAdy [] listaAdyacencia;
	private boolean[] usados;
	private Hash mapa;
	
	//Constructor
	public Grafo (int n) {
		
		this.size=n;
		this.cantNodosActual=0;
		this.largo = calculoLargo(n*2);
		this.listaAdyacencia = new ListAdy[this.largo];
		for (int i = 0; i < this.largo; i++) {
			this.listaAdyacencia[i]= new ListAdy();
		}
		this.mapa = new Hash(largo);
		this.usados = new boolean[this.largo];
	}
	
	//Calcular largo
	private int calculoLargo(int i) {
		if (esPrimo(i)) {
			return i;
		}else {
			return calculoLargo(++i);
		}
	}

	//Es primo
	private boolean esPrimo(int i) {
		int aux=0;
		for (int j = 1; j < (i+1); j++) {
			if (i%j==0) {
				aux++;
			}
		}
		if (aux!=2) {
			return false;
		}
		return true;
	}

	//Son adyacntes
	public boolean sonAdyacentes (int a, int b) {
		return this.listaAdyacencia[a].pertenece(b);
		
	}
	
	//Agregar arista
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

	//Agregar vertice
	public void agregarVertice(int v) {
		this.usados[v]=true;
		
	}

	//Eliminar arista
	public void eliminarArista(int origen, int destino) {
		this.listaAdyacencia[origen].eliminar(destino);	
	}

	//Es vacio
	public boolean esVacio() {
		return this.size==0;
	}

	//Eliminar vertice
	public void eliminarVertice(int v) {
		this.usados[v]=false;
		this.size --;
		
		//Elimino las aristas donde v es miembro
		this.listaAdyacencia[v] = new ListAdy();	
		//BUSCAR EN TODOS LOS VERTICES LA ARISTA
		for (int i = 1; i<=cantNodosActual; i++)
			this.listaAdyacencia[i].eliminar(v);	
	}

	//Vertices adyacentes
	public ListAdy verticesAdyacentes(int v) {
		return this.listaAdyacencia[v];
	}

	//Esta vertice
	public boolean estaVertice(int v) {
		return this.usados[v];
	}

	//Existe posicion
	public boolean existePosicion(Double coordX, Double coordY) {
		
		return false;
	}
	
	//Esta lleno
	public boolean isFull() {
		
		return cantNodosActual==size;
	}
	
	//Ingresar
	public void ingresar(Punto punto) {
		if ( punto!= null) {
			int pos= dispersion(punto.getCoordenadaX(), punto.getCoordenadaY());
			this.listaAdyacencia[pos].agregarPunto(punto);
			agregarVertice(pos);
			this.mapa.agregarNodo(pos,punto);
			cantNodosActual++;
		}
	}

	//Dispersion
	public int dispersion(double coordX, double coordY) {
		double valor= (coordX + coordY)*10000;
		int pos = (int)Math.abs(Math.round( (valor % this.largo) ) );
		return pos;
	}

	//Eliminar punto 
	public void eliminarPunto(Double coordX, Double coordY) {
		if(existePunto(coordX, coordY)) {
			int pos = dispersion(coordX, coordY);

			
			
			eliminarVertice(pos);
		}
	}
	
	//Getters y Setters
	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public int getCantNodosActual() {
		return cantNodosActual;
	}

	public void setCantNodosActual(int cantNodosActual) {
		this.cantNodosActual = cantNodosActual;
	}

	public ListAdy[] getListaAdyacencia() {
		return listaAdyacencia;
	}

	public void setListaAdyacencia(ListAdy[] listaAdyacencia) {
		this.listaAdyacencia = listaAdyacencia;
	}

	public boolean[] getUsados() {
		return usados;
	}

	public void setUsados(boolean[] usados) {
		this.usados = usados;
	}

	public Hash getMapa() {
		return mapa;
	}

	public void setMapa(Hash mapa) {
		this.mapa = mapa;
	}

	//true si existe el punto en la lista
	public boolean existePunto(Double coordX, Double coordY) {
		int pos = dispersion(coordX, coordY);
		if (listaAdyacencia[pos].getInicio().getNodo()!=null) {
			return true;
		}else {

			return false;
		}
	}

	//si existe un tramo entre los dos puntos
	public boolean existeTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		int posOrigen= dispersion(coordXi, coordYi);
		int posDestino= dispersion(coordXf, coordYf);
		Punto ptoOrigen= listaAdyacencia[posOrigen].getInicio().getNodo();
		Punto ptoDestino= listaAdyacencia[posDestino].getInicio().getNodo();
		
		//pregunto si existe un tramo entre pto origen y pto destino
		if (listaAdyacencia[posOrigen].existe(ptoDestino) && listaAdyacencia[posDestino].existe(ptoOrigen)) {
			return true;
		}else {

			return false;	
		}
		
	}

	//agregar tramo, agregar tramo a las dos posiciones, no se agrega nada en el hash
	public void agregarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		int posOrigen= dispersion(coordXi, coordYi);
		int posDestino= dispersion(coordXf, coordYf);
		Punto ptoOrigen= listaAdyacencia[posOrigen].getInicio().getNodo();
		Punto ptoDestino= listaAdyacencia[posDestino].getInicio().getNodo();
		
		listaAdyacencia[posOrigen].agregarTramo(ptoDestino,peso);
		listaAdyacencia[posDestino].agregarTramo(ptoOrigen,peso);
		
		
	}
}
