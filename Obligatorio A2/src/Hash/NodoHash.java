package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Punto;

public class NodoHash {

	 	private Estado estado;
	    private Punto dato;
	    private NodoHash  siguiente;

	    public NodoHash(Punto dato) {
	        this.estado = EstadoHash.Estado.VACIO;
	        this.dato = dato;
	        this.siguiente = null;
	    }

	    public NodoHash() {
	        this.estado = EstadoHash.Estado.VACIO;
	        this.dato = null;
	        this.siguiente = null;
	    }

	    public Punto getDato() {
	        return dato;
	    }

	    public void setDato(Punto dato) {
	        this.dato = dato;
	    }

	    public NodoHash getSiguiente() {
	        return siguiente;
	    }

	    public void setSiguiente(NodoHash siguiente) {
	        this.siguiente = siguiente;
	    }

	  
	    public Estado getEstado() {
	        return estado;
	    }

	   
	    public void setEstado(Estado estado) {
	        this.estado = estado;
	    }
	
}
