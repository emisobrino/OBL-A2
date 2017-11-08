package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CedulaValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String Cedula_PATTERN = "^([0-9]{1}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{1})$";
	
	
	public CedulaValidator() {
		pattern = Pattern.compile(Cedula_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}
