package Pruebas;

import Sistema.Sistema;

public class Prueba {

	
	
	public static void main(String[] args) {
		
		
//		int cantPuntos = 10;
//		sistema.inicializarSistema(cantPuntos);
//		sistema.registrarCiudad("Montevideo", -34.901113, -56.164531);
//		sistema.registrarProductor("4.684.222-0", "Emi", "8 de oct", "emisoro.9@gmail.com", "098850449");
//		sistema.registrarProductor("3.987.624-3", "Juan", "6 de asdoct", "emdro.5@gmail.com", "099567922");
//		sistema.registrarProductor("1.984.747-4", "Mathi", "8]4 de oct", "emo.9@gmail.com", "098856789");
//		sistema.registrarProductor("2.435.984-6", "Andy", "2 de asdoct", "asdro.5@gmail.com", "099654922");
//		//sistema.arbolProductor.listarAscendente();
//		System.out.println("prueba git");
//		
//		sistema.registrarSilo("Silo A", -32.92214, -54.51125, 400);
//		sistema.registrarSilo("Silo B", -33.19124, -55.13213, 2000);
//		sistema.registrarSilo("Silo C", -32.95824, -54.22124, 300);
//		sistema.registrarSilo("Silo D", -32.11124, -55.61124, 6000);
		
		
//		
//		sistema.listadoProductores();
//		sistema.listadoDeSilos();
		
//		sistema.mapaEstado();
		//System.out.println(sistema.arbolProductor.pertenece("4.684.222-0"));
		Sistema sistema = new Sistema();
		
		
		cargar(sistema);

		System.out.println(sistema.listadoDePlantacionesEnCiudad(-32.364862,-54.166551).valorString);	
		if (sistema.listadoDePlantacionesEnCiudad(-32.364862,-54.166551).valorString.contains("-32.702193;-57.638238")) {
			System.out.println("contiene");
		}
	}
	
	public static void cargar(Sistema sistema) {
		sistema.inicializarSistema(10);
		sistema.registrarProductor("1.111.111-0", "Lucia", "Esteban Quito 1234", "rigoberta@menchu.com", "099111111");
		

		sistema.registrarCiudad("MELO", -32.364862,-54.166551);
		sistema.registrarSilo("TRINIDAD", -33.520142,-56.904220,200);
		sistema.registrarPlantacion("MONTEVIDEO", -34.901113,-56.164531,"1.111.111-0",1);
//		sistema.registrarSilo("COLONIA", -34.460719,-57.833910,1);
		sistema.registrarPlantacion("YOUNG", -32.702193,-57.638238,"1.111.111-0",300);
		sistema.registrarSilo("CONCHILLAS", -34.164144,-58.034204,400);
		sistema.registrarSilo("SARANDI GRANDE", -33.725648,-56.329281,350);
		sistema.registrarPlantacion("CASTILLOS", -34.197913,-53.861754,"1.111.111-0",1);
		sistema.registrarCiudad("PUNTA DEL DIABLO", -34.042339,-53.547332);
		sistema.registrarPlantacion("VALIZAS", -34.336668,-53.793882,"1.111.111-0",1);

		sistema.registrarTramo(-32.364862,-54.166551	, -34.901113,-56.164531,  6); // MELO-MONTEVIDEO
		sistema.registrarTramo(-32.364862,-54.166551	, -32.702193,-57.638238,  5); // MELO-YOUNG
		sistema.registrarTramo(-32.364862,-54.166551	, -33.725648,-56.329281,  10); // MELO-SARANDI
		sistema.registrarTramo(-32.364862,-54.166551	, -34.197913,-53.861754,  21); // MELO-CASTILLOS
		sistema.registrarTramo(-32.364862,-54.166551	, -34.042339,-53.547332,  10); // MELO-PDD
	}
}
