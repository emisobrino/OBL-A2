package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Punto;
import Modelo.Silo;

public class Hash {
	//Properties
	private NodoHash[] tablaHash;
	private int largoHash;
	
	
	/// CONSTRUCTOR
	public Hash(int Cant) {
		largoHash=Cant;
		this.tablaHash = new NodoHash[largoHash];
		for (int i = 0; i < tablaHash.length; i++) {
			tablaHash[i] = new NodoHash();
		}
	}
	
	//Es vacio
	public Hash Vacio() {
		return null;
	}
	
	//Obtener tabla hash
	public NodoHash[] getTablaHash() {
		return tablaHash;
	}

	
	//Es vacio
	public boolean EsVacio() {
		return false;
	}
	
	//Agregar nodo
	public void agregarNodo(int pos, Punto punto) {
		tablaHash[pos].setDato(punto);
		tablaHash[pos].setEstado(Estado.OCUPADO);
	}
	
	//Eliminar nodo
	public void eliminarNodo(int pos) {
		tablaHash[pos]= new NodoHash();
		tablaHash[pos].setEstado(Estado.ELIMINADO);
	}

	//Listar silos
	public String listadoSilos() {
		String cadena = "";
		
		for(int i=0 ; i<largoHash ; i++) {
			if(tablaHash[i].getDato() != null && tablaHash[i].getDato() instanceof Silo) {
				cadena = cadena + tablaHash[i].getDato().toString();
			}
		}
		
		return cadena;
	}
}
