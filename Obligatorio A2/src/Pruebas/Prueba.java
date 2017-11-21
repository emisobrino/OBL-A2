package Pruebas;

import Sistema.Sistema;

public class Prueba {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		int cantPuntos = 5;
		sistema.inicializarSistema(cantPuntos);
		//sistema.registrarCiudad("Montevideo", 123412.0, 123421.0);
		sistema.registrarProductor("4.594.223-1", "Emi", "8 de oct", "emisoro.9@gmail.com", "098850449");
		sistema.registrarProductor("3.987.624-3", "Juan", "6 de asdoct", "emdro.5@gmail.com", "099567922");
		sistema.registrarProductor("1.984.747-4", "Mathi", "8]4 de oct", "emo.9@gmail.com", "098856789");
		sistema.registrarProductor("2.435.984-6", "Andy", "2 de asdoct", "asdro.5@gmail.com", "099654922");
		//sistema.arbolProductor.listarAscendente();
		System.out.println("prueba git");
		
		sistema.listadoProductores();
	}
}
