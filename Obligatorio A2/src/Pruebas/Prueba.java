package Pruebas;

import Sistema.Sistema;

public class Prueba {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		int cantPuntos = 5;
		sistema.inicializarSistema(cantPuntos);
		sistema.registrarCiudad("Montevideo", 123412.0, 123421.0);
		
		
	}
}
