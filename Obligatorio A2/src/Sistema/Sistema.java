package Sistema;

import ABBProductor.ABBProductor;
import Grafo.Grafo;
import Modelo.Ciudad;
import Modelo.Plantacion;
import Modelo.Productor;
import Modelo.Silo;
import Sistema.Retorno.Resultado;

public class Sistema implements ISistema {
	// Properties
	private Grafo grafo ;
	public ABBProductor arbolProductor ;

	//Iniciar sistema
	@Override
	public Retorno inicializarSistema(int cantPuntos)
	{
		Retorno ret = new Retorno();
		
		if(cantPuntos > 0) {
			//Creo grafo y arbol productor
			grafo= new Grafo(cantPuntos);
			arbolProductor = new ABBProductor();
			
			System.out.println("Largo grafo:" + grafo.getLargo());//largo del array y hash
			System.out.println("Cantidad nodos grafo:" + grafo.getSize());//cantidad de nodos
		}else {
			ret.resultado = Resultado.ERROR_1;
		}

		return ret;
	}

	//Destruir sistema
	@Override
	public Retorno destruirSistema() 
	{
		Retorno ret = new Retorno();

		if(grafo != null && arbolProductor != null)
		{
			grafo = null;
			arbolProductor = null;
			System.gc();
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

	// Registrar productor
	@Override
	public Retorno registrarProductor(String cedula, String nombre, String direccion, String email, String celular) {
		Retorno ret = new Retorno();

		// Creo Productor
		Productor prod = new Productor(cedula, nombre, direccion, email, celular);

		// Uso los metodo de validar del productor
		if (prod.validarEmail()) {
			if (prod.validarCedula()) {
				if (prod.validarCelular()) {
					if (!arbolProductor.pertenece(prod)) {
						arbolProductor.insertar(prod);
						ret.resultado = Resultado.OK;
						
					} else {
						ret.resultado = Resultado.ERROR_4;
					}
				} else {
					ret.resultado = Resultado.ERROR_2;
				}
			} else {
				ret.resultado = Resultado.ERROR_1;
			}
		} else {
			ret.resultado = Resultado.ERROR_3;
		}

		return ret;
	}

	// Registrar ciudad
	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		// Creo ciudad
		Ciudad ciudad = new Ciudad(coordX, coordY, nombre);

		// Agrego ciudad Si el grafo no esta lleno(cantPuntos) y no existe ningun punto
		// en esas coordenadas
		if (!grafo.isFull()) 
		{
			if (!grafo.existePunto(coordX, coordY)) 
			{
				grafo.ingresar(ciudad);
				ret.resultado = Resultado.OK;
			} else {
				ret.resultado = Resultado.ERROR_2;
			}
		} else {
			ret.resultado = Resultado.ERROR_1;
		}

		return ret;
	}

	// Registrar plantacion
	@Override
	public Retorno registrarPlantacion(String nombre, Double coordX, Double coordY, String cedula_productor,
			int capacidad) {
		Retorno ret = new Retorno();

		// Agrego Plantacion Si el grafo no esta lleno(cantPuntos) y no existe ningun
		// punto en esas coordenadas
		if (!grafo.isFull()) {
			if (capacidad > 0) {
				if (!grafo.existePunto(coordX, coordY)) {
					Plantacion plantacion = new Plantacion( coordX, coordY,nombre, cedula_productor, capacidad);
					grafo.ingresar(plantacion);
					ret.resultado = Resultado.OK;
				} else {
					ret.resultado = Resultado.ERROR_3;
				}
			} else {
				ret.resultado = Resultado.ERROR_2;
			}
		} else {
			ret.resultado = Resultado.ERROR_1;
		}

		return ret;
	}

	// Registrar silo
	@Override
	public Retorno registrarSilo(String nombre, Double coordX, Double coordY, int capacidad) {
		Retorno ret = new Retorno();

		// Agrego Silo Si el grafo no esta lleno(cantPuntos) y no existe ningun punto en
		// esas coordenadas
		if (!grafo.isFull()) {
			if (capacidad > 0) {
				if (!grafo.existePunto(coordX, coordY)) {
					Silo silo = new Silo(coordX, coordY, nombre, capacidad);
					grafo.ingresar(silo);
					ret.resultado = Resultado.OK;
				} else {
					ret.resultado = Resultado.ERROR_3;
				}
			} else {
				ret.resultado = Resultado.ERROR_2;
			}
		} else {
			ret.resultado = Resultado.ERROR_1;
		}

		return ret;
	}

	//Registrar tramo
	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		Retorno ret = new Retorno();
		
		if(peso>0) {
			if (grafo.existePunto(coordXi,coordYi) && grafo.existePunto(coordXf, coordYf)) {
				if(!grafo.existeTramo(coordXi,coordYi,coordXf,coordYf)) {
					grafo.agregarTramo(coordXi,coordYi, coordXf,coordYf,peso);
						ret.resultado=Resultado.OK;
				}else {
					ret.resultado= Resultado.ERROR_3;
				}
			}else {
				ret.resultado= Resultado.ERROR_2;
			}
		}else {
			ret.resultado= Resultado.ERROR_1;
		}
		return ret;
	}

	//Eliminar tramo
	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		Retorno ret = new Retorno();

		if (grafo.existePunto(coordXi, coordYi) && grafo.existePunto(coordXf, coordYf)) {
			if (grafo.existeTramo(coordXi, coordYi, coordXf, coordYf))
			{
				grafo.eliminarTramo(coordXi, coordYi, coordXf, coordYf);
				ret.resultado=Resultado.OK;
			}else {
				ret.resultado= Resultado.ERROR_2;
			}
		}else {
			ret.resultado= Resultado.ERROR_1;
		}

		return ret;
	}

	//Eliminar punto
	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		//Si existe punto en las coordenadas, le pido al grafo que lo elimine
		if (grafo.existePunto(coordX, coordY)) {
			grafo.eliminarPunto(coordX, coordY);
			ret.resultado = Resultado.OK; 
		}else {
			ret.resultado = Resultado.ERROR_1;
		}

		return ret;
	}

	//Mapa estado
	@Override
	public Retorno mapaEstado() {
		Retorno ret = new Retorno();

		grafo.mapaEstado();
		ret.resultado = Resultado.OK;

		return ret;
	}

	//Ruta a silo mas cercano
	@Override
	public Retorno rutaASiloMasCercano(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		if(grafo.existePunto(coordX, coordY)&& grafo.esPlantacion(coordX, coordY)) {
			if(!(grafo.encontroSiloMasCercano(coordX, coordY).equals("")) ) {
				
				ret.valorString= grafo.encontroSiloMasCercano(coordX, coordY);
				ret.resultado=Resultado.OK;
				
			}else {
				ret.resultado= Resultado.ERROR_2;
			}
			
		}else {
			ret.resultado= Resultado.ERROR_1;
			
		}
		

		return ret;
	}

	//Listado de plantaciones en ciudad
	@Override
	public Retorno listadoDePlantacionesEnCiudad(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		if ( grafo.existeCiudad(coordX, coordY)) {
			ret.valorString=grafo.listadoPlantacionesEnCiudad(coordX, coordY);
			ret.resultado=Resultado.OK;
		}else {
			ret.resultado= Resultado.ERROR_1;
		}
		return ret;
	}

	//Listado de silos
	@Override
	public Retorno listadoDeSilos() {
		Retorno ret = new Retorno();
		
		if(!grafo.esVacio()) {
			ret.valorString = grafo.listadoSilos();
			System.out.println(grafo.listadoSilos());
			ret.resultado = Resultado.OK;
		}
		return ret;
	}

	//Listado de productores
	@Override
	public Retorno listadoProductores() {
		Retorno ret = new Retorno();

		//Si el arbol no esta vacio, pido al arbol que me liste los productores ascendentemente
		if(!arbolProductor.esArbolVacio()) {
			ret.valorString = arbolProductor.listarAscendente();
			ret.resultado = Resultado.OK;
		}

		return ret;
	}

}








