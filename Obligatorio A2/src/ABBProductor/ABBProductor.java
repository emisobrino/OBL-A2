package ABBProductor;

import javax.xml.bind.ValidationEvent;

import Modelo.Productor;

public class ABBProductor {

	private NodoProductor raiz;

	public ABBProductor() {
		this.raiz = null;
	}

	public NodoProductor getRaiz() {
		return raiz;
	}

	public boolean esArbolVacio() {
		return (raiz == null);
	}

	public void mostrarPreOrder() {
		mostrarPreOrder(this.raiz);
	}

	public void mostrarPreOrder(NodoProductor a) {
		if (a != null) {
			System.out.print(a.getDato() + "   ");
			mostrarPreOrder(a.getIzq());
			mostrarPreOrder(a.getDer());
		}
	}

	public int cantNodos(NodoProductor nodo) {
		int cont = 0;
		if (nodo != null) {
			cont += cantNodos(nodo.getIzq()); // cuenta subarbol izquierdo
			cont++; // contabilizar el nodo visitado
			cont += cantNodos(nodo.getDer()); // cuenta subarbol derecho

		}
		return cont;
	}

	public void insertar(Productor p) {

		if (esArbolVacio()) {
			this.raiz = new NodoProductor(p);

		} else {
			insertar(p, this.raiz);
		}
	}

	private void insertar(Productor p, NodoProductor a) {

		if (a.getDato().getCedulaInt() > p.getCedulaInt()) {

			if (a.getIzq() == null) {
				a.setIzq(new NodoProductor(p));
			} else {
				insertar(p, a.getIzq());

			}
		} else {

			if (a.getDer() == null) {
				a.setDer(new NodoProductor(p));
			} else {

				insertar(p, a.getDer());
			}

		}

	}

	public String listarAscendente() {

		return listarAscendente(this.raiz);
	}


	private String listarAscendente(NodoProductor n) {
		if (n == null) {
			return "";
		}
		String cadena = "";
		cadena = cadena + listarAscendente(n.getIzq());
		cadena = cadena + n.getDato().toString();	
		cadena = cadena + listarAscendente(n.getDer());
			
		return cadena;
	}
	
	public boolean pertenece(Productor p) {

		return pertenece(p, this.raiz);

	}

	private boolean pertenece(Productor p, NodoProductor n) {
		if (n == null) {
			return false;
		}
		if (n.getDato().getCedulaInt() == p.getCedulaInt()) {
			return true;
		}
		if (n.getDato().getCedulaInt() > p.getCedulaInt()) {
			return pertenece(p, n.getIzq());
		} else {

			return pertenece(p, n.getDer());
		}
	}

}