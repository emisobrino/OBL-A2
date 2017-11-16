package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Punto;

public class Hash {

	private NodoHash[] tablaHash;

	public Hash Vacio() {
		return null;
	}

	/// CONSTRUCTOR
	public Hash(int Cant) {
		this.tablaHash = new NodoHash[Cant];
		for (int i = 0; i < tablaHash.length; i++) {
			Punto a = new Punto();
			tablaHash[i] = new NodoHash(a);
		}
	}

	// insertar en el hash
	public void Insertar(Punto p) {
		Punto dato = null;
		int hashPosition = this.H(p.getCoordenadaX(), p.getCoordenadaY());
		int a = -1;
		if (tablaHash[hashPosition].getEstado() == Estado.OCUPADO) {
			dato = (Punto) tablaHash[hashPosition].getDato();
			NodoHash aux = new NodoHash(dato);
			tablaHash[hashPosition].setDato(p);
			tablaHash[hashPosition].setSiguiente(aux);
			tablaHash[hashPosition].setEstado(Estado.OCUPADO);
		} else {
			tablaHash[hashPosition].setDato(p);
			tablaHash[hashPosition].setEstado(Estado.OCUPADO);
		}

	}

	//imprimir hash
	public void ImprimirHash() {
		for (int i = 0; i < tablaHash.length; i++) {
			if (tablaHash[i].getSiguiente() != null) {
				NodoHash aux = tablaHash[i];
				while (aux != null) {
					System.out.println("Hash: " + i + ": " + aux.getDato());
					aux = aux.getSiguiente();
				}

			} else {
				System.out.println("Hash: " + i + ": " + tablaHash[i].getDato());
			}
		}
	}

	
	public NodoHash encontrarNull(NodoHash elNodo) {
		while (elNodo != null) {
			if (elNodo.getSiguiente() == null) {
				return elNodo;
			}
			elNodo.getSiguiente();
		}
		return null;
	}

	
	
	public boolean EsVacio() {
		return false;
	}

	
	
	public boolean Pertenece(Punto i) {
		Punto Abc = null;
		int hash = H(i.getCoordenadaX(), i.getCoordenadaY());
		Abc = tablaHash[hash].getDato();
		if (Abc != null)
			if (Abc.getNombre() != null)
				if (Abc.getNombre().equals(i.getNombre())) {
					return true;
				}
		return false;
	}

	public boolean Borrar(Punto i) {
		Punto Abc = null;
		int hash = H(i.getCoordenadaX(), i.getCoordenadaY());
		Abc = tablaHash[hash].getDato();

		NodoHash aux = tablaHash[hash];
		if (Abc.equals(i)) {
			tablaHash[hash] = tablaHash[hash].getSiguiente();
			return true;
		}
		return false;
	}

	public int H(double coordX, double coordY) {
		int devolver = 0;
		devolver = hallarValorASCII(coordX,coordY) % tablaHash.length + 1;
		return devolver;
	}

	private int hallarValorASCII(double coordX, double coordY) {
		int sumaASCII = 0;
		sumaASCII= (int)(coordX + coordY);
		return sumaASCII;
	}

}
