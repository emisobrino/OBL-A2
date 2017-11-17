package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Punto;

public class Hash {

	private NodoHash[] tablaHash;
	private int largoHash;
	
	public Hash Vacio() {
		return null;
	}

	/// CONSTRUCTOR
	public Hash(int Cant) {
		largoHash=Cant;
		this.tablaHash = new NodoHash[largoHash];
		for (int i = 0; i < tablaHash.length; i++) {
			tablaHash[i] = new NodoHash();
		}
	}
	
	
	
	public NodoHash[] getTablaHash() {
		return tablaHash;
	}

	

	public boolean EsVacio() {
		return false;
	}
	
	public void agregarNodo(int pos, Punto punto) {
		
			tablaHash[pos].setDato(punto);
			tablaHash[pos].setEstado(Estado.OCUPADO);
		
		
	}

}
