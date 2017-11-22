package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CedulaValidator {

	//Validar cedula
	public boolean validarCedula(String cedula) 
	{
		//Int Caracteres correctos
		int caracteres = 0;
		
		//Si la cedula tiene 11 caracteres
		if (cedula.length() == 11)
		{
			//Recorro cedula
			for (int c = 0; c < cedula.length(); c++)
			{
				//Comparo caracteres con posiciones
				if (c == 0 || c == 2 || c == 3 || c == 4 || c == 6 || c == 7 || c == 8 || c == 10) 
				{
					if (cedula.charAt(c) == '0' || cedula.charAt(c) == '1' || cedula.charAt(c) == '2'
							|| cedula.charAt(c) == '3' || cedula.charAt(c) == '4' || cedula.charAt(c) == '5'
							|| cedula.charAt(c) == '6' || cedula.charAt(c) == '7' || cedula.charAt(c) == '8'
							|| cedula.charAt(c) == '9') 
						
						caracteres++;
				}
				
				//Valido puntos y giones
				if (c == 1 || c == 5) {
					if (cedula.charAt(c) == '.') caracteres++;
				}
				
				if (c == 9) {
					if (cedula.charAt(c) == '-') caracteres++;
				}
			}
			
			if (caracteres == 11) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
