package Sistema;

import ABBProductor.ABBProductor;
import Grafo.Grafo;
import Modelo.Ciudad;
import Modelo.Plantacion;
import Modelo.Productor;
import Modelo.Silo;
import Sistema.Retorno.Resultado;
import Utilidades.CedulaValidator;
import Utilidades.CelularValidator;
import Utilidades.EmailValidator;

public class Sistema implements ISistema {
	// Properties
	private Grafo grafo ;
	private ABBProductor arbolProductor ;

	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		Retorno ret = new Retorno();
		grafo= new Grafo(5);
		arbolProductor = new ABBProductor();
		//largo del array y hash
		System.out.println(grafo.getLargo());
		//cantidad de nodos
		System.out.println(grafo.getSize());
		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

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
			if (!grafo.existePosicion(coordX, coordY)) 
			{
				grafo.ingresar(ciudad);
				
				//para prueba el for
				for (int i = 0; i < grafo.getListaAdyacencia().length; i++) {
					if (grafo.getListaAdyacencia()[i].getInicio().getNodo() != null) {
						System.out.println(i);
						System.out.println(grafo.getMapa().getTablaHash()[i].getDato().getNombre());
					}
						
				}
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
				if (!grafo.existePosicion(coordX, coordY)) {
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
				if (!grafo.existePosicion(coordX, coordY)) {
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

	@Override
	public Retorno registrarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int peso) {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno eliminarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf) {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno eliminarPunto(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno mapaEstado() {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno rutaASiloMasCercano(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno listadoDePlantacionesEnCiudad(Double coordX, Double coordY) {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno listadoDeSilos() {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

	@Override
	public Retorno listadoProductores() {
		Retorno ret = new Retorno();

		ret.resultado = Resultado.NO_IMPLEMENTADA;

		return ret;
	}

}
