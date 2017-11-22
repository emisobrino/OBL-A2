package Grafo;

import javax.xml.stream.events.NotationDeclaration;

import Modelo.Plantacion;
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

	

	public void agregarPunto(Punto p, int pos) {
		
		if (inicio!=null) {
			this.inicio.setNodo(p);
			this.inicio.setPosicion(pos);
		}
	}
	
	// true si el punto destino esta en la lista de tramos 
	public boolean existe(Punto ptoDestino) {
		NodoLista aux= inicio;
		boolean encontre=false;
		// mientras el nodo no sea null y no halla encontrado el pto
		while (aux!=null && !encontre) {
			if (aux.getNodo().equals(ptoDestino)) {
				encontre=true;
			}else {
				aux= aux.getSiguiente();
			}
			
		}
		return encontre;
	}

	
	//agrega punto al tramo con el peso
	public void agregarTramo(Punto ptoDestino, int peso,int posicion) {
		
		NodoLista nodo = new NodoLista(ptoDestino, peso, posicion);
		
		if (tramosVacios()) {
			inicio.setSiguiente(nodo);
		}else {
			NodoLista aux = inicio.getSiguiente();
			inicio.setSiguiente(nodo);
			nodo.setSiguiente(aux);
		}
		
		
	}

	public boolean tramosVacios() {
		return (this.getInicio().getSiguiente()==null);
	}
	
	public void eliminarTramo(int destino) {
		
		NodoLista auxInicio= inicio.getSiguiente(); 
		
		if (auxInicio.getPosicion() == destino) {
			auxInicio= auxInicio.getSiguiente();
			inicio.setSiguiente(auxInicio);
		}else {
			while (auxInicio.getSiguiente().getPosicion()!=destino) {
				auxInicio= auxInicio.getSiguiente();
			}
			NodoLista sig = auxInicio.getSiguiente().getSiguiente();
			auxInicio.setSiguiente(sig);
		}
		
	}

	public String listadoPlantacionesCiudad() {
		String resultado = "";
		// guardo el primer tramo
		NodoLista aux = inicio.getSiguiente();

		// recorro si no es null
		while (aux != null) {
			// pregunto si es plantacion y tiene distancia menor/igual a 20
			if (aux.getNodo() instanceof Plantacion && aux.getDistancia() <= 20) {
				// armo el retorno con las coordenadas
				resultado += aux.getNodo().getCoordenadaX() + ";" + aux.getNodo().getCoordenadaY() + "|";
			}
			aux = aux.getSiguiente();
		}

		return resultado;
	}
	
}
