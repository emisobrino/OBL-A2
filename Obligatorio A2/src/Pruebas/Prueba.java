package Pruebas;

import Sistema.Sistema;

public class Prueba {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		int cantPuntos = 5;
		sistema.inicializarSistema(cantPuntos);
		//sistema.registrarCiudad("Montevideo", 123412.0, 123421.0);
		sistema.registrarProductor("4.594.194-1", "Emi", "8 de oct", "emisoro.9@gmail.com", "098850449");
		sistema.registrarProductor("4.594.494-1", "Emias", "8 de asdoct", "emisoasdasdro.5@gmail.com", "099044922");
		sistema.arbolProductor.listarAscendente();
		System.out.println("prueba git");
		
		
	}
}
