package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CelularValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String Celular_PATTERN = "^([0]{1}?[9]{1}?[0-9]{7})$";
	
	
	public CelularValidator() {
		pattern = Pattern.compile(Celular_PATTERN);
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

