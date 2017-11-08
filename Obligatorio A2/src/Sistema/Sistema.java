package Sistema;

import Sistema.Retorno.Resultado;
import Utilidades.CedulaValidator;
import Utilidades.CelularValidator;
import Utilidades.EmailValidator;

public class Sistema implements ISistema {

	
	
	@Override
	public Retorno inicializarSistema(int cantPuntos) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarProductor(String cedula, String nombre, String direccion, String email, String celular) {
		Retorno ret = new Retorno();
		
		//if(!ABB.pertece(cedula)){}
			if(validarEmail(email)) 
			{
				if(validarCedula(cedula)) 
				{
					if(validarCelular(celular)) {
						
					}else {
						System.out.println("Formato de celular incorrecto");
						ret.resultado = Resultado.ERROR_2;
					}
				}else {
					System.out.println("Formato de cedula incorrecta");
					ret.resultado = Resultado.ERROR_1;
				}
			}else {
				System.out.println("Formato de Email incorrecto");
				ret.resultado = Resultado.ERROR_3;
			}
		//}else{
			//System.out.println("Usuario ya existe");
			//ret.resultado = Resultado.ERROR_4;
		//}
			
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}
	
	//Validar celular
		public boolean validarCelular(String celular) {
			CelularValidator celValidar = new CelularValidator();
			return celValidar.validate(celular);
		}
	
	//Validar cedula
	public boolean validarCedula(String cedula) {
		CedulaValidator cedulaValidar = new CedulaValidator();
		return cedulaValidar.validate(cedula);
	}

	//Validar email
	private boolean validarEmail(String email) {
		EmailValidator emailValidar = new EmailValidator();
		
		return emailValidar.validate(email);
	}

	@Override
	public Retorno registrarCiudad(String nombre, Double coordX, Double coordY) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarPlantacion(String nombre, Double coordX, Double coordY, String cedula_productor,
			int capacidad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarSilo(String nombre, Double coordX, Double coordY, int capacidad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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
