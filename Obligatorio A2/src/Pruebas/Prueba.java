package Pruebas;

import Sistema.Sistema;

public class Prueba {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		int cantPuntos = 10;
		sistema.inicializarSistema(cantPuntos);
		sistema.registrarCiudad("Montevideo", -34.901113, -56.164531);
		sistema.registrarProductor("4.594.223-1", "Emi", "8 de oct", "emisoro.9@gmail.com", "098850449");
		sistema.registrarProductor("3.987.624-3", "Juan", "6 de asdoct", "emdro.5@gmail.com", "099567922");
		sistema.registrarProductor("1.984.747-4", "Mathi", "8]4 de oct", "emo.9@gmail.com", "098856789");
		sistema.registrarProductor("2.435.984-6", "Andy", "2 de asdoct", "asdro.5@gmail.com", "099654922");
		//sistema.arbolProductor.listarAscendente();
		System.out.println("prueba git");
		
		sistema.registrarSilo("Silo A", -32.92214, -54.51125, 400);
		sistema.registrarSilo("Silo B", -33.19124, -55.13213, 2000);
		sistema.registrarSilo("Silo C", -32.95824, -54.22124, 300);
		sistema.registrarSilo("Silo D", -32.11124, -55.61124, 6000);
		
		
		
		sistema.listadoProductores();
		sistema.listadoDeSilos();
		
		sistema.mapaEstado();
	}
}
