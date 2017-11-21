package Hash;

import Hash.EstadoHash.Estado;
import Modelo.Ciudad;
import Modelo.Plantacion;
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
		for (int i = 0; i < largoHash; i++) {
			if(tablaHash[i].getDato() != null) return false;
		}
		return true;
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

	//Obtener Url Mapa con Puntos
	public String getURLMapaPuntos() {
		String urlMapa = "http://maps.googleapis.com/maps/api/staticmap?center=Uruguay&zoom=7&size=1200x600&maptype=roadmap&sensor=false";
		
		if(!EsVacio()) {
			for(int i = 0; i < largoHash; i++ ) {
				if(tablaHash[i].getDato() != null && tablaHash[i].getDato() instanceof Ciudad){
					Double coordX = tablaHash[i].getDato().getCoordenadaX();
					Double coordY = tablaHash[i].getDato().getCoordenadaY();
					urlMapa = urlMapa + "&markers=color:red%7Clabel:C%7C" + coordX.toString() + "," + coordY.toString() +"&";
				}
				if(tablaHash[i].getDato() != null && tablaHash[i].getDato() instanceof Silo){
					Double coordX = tablaHash[i].getDato().getCoordenadaX();
					Double coordY = tablaHash[i].getDato().getCoordenadaY();
					urlMapa = urlMapa + "&markers=color:green%7Clabel:S%7C" + coordX.toString() + "," + coordY.toString() +"&";
				}
				
				if(tablaHash[i].getDato() != null && tablaHash[i].getDato() instanceof Plantacion){
					Double coordX = tablaHash[i].getDato().getCoordenadaX();
					Double coordY = tablaHash[i].getDato().getCoordenadaY();
					urlMapa = urlMapa + "&markers=color:yellow%7Clabel:P%7C" + coordX.toString() + "," + coordY.toString() +"&";
				}
			}
		}
		return urlMapa;
	}
}
