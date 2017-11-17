package Grafo;

import Modelo.Punto;

public class ListAdy {

	NodoLista inicio;

	
	public ListAdy() {
		this.inicio= new NodoLista();
	}

	public NodoLista getInicio() {
		return inicio;
	}

	public void setInicio(NodoLista inicio) {
		this.inicio = inicio;
	}

	public boolean pertenece(int b) {
		
		return false;
	}

	public void insertar(int destino, int peso) {
		if (!pertenece(destino)) {
			
		}
		
	}

	public void eliminar(int destino) {
		// TODO Auto-generated method stub
		
	}

	public void agregarPunto(Punto p) {
		
		if (inicio!=null) {
			this.inicio.setNodo(p);
		}
		
		
		
	}
	
}
