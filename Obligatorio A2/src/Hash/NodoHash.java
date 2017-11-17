package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Punto;

public class NodoHash {

	 	private Estado estado;
	    private Punto dato;

	    public NodoHash(Punto dato) {
	        this.estado = EstadoHash.Estado.VACIO;
	        this.dato = dato;
	        
	    }

	    public NodoHash() {
	        this.estado = EstadoHash.Estado.VACIO;
	        this.dato = null;
	        
	    }

	    public Punto getDato() {
	        return dato;
	    }

	    public void setDato(Punto dato) {
	        this.dato = dato;
	    }

	   

	  
	    public Estado getEstado() {
	        return estado;
	    }

	   
	    public void setEstado(Estado estado) {
	        this.estado = estado;
	    }
	
}
