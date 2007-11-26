package layout.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Esta clase se dedica a ser una ayuda para el tratamiento de las fechas.
 * Brinda las herramientas para construir fechas, calcular diferencia entre fechas, etc.
 * @author smagnacco
 *
 */
public class StringToDate {
	/**
	 * Dado un string fecha con el formato "dd-MMM-yyyy" Locale.US lo transforma en un Date
	 * @param fecha string de la fecha
	 * @return retorna un objeto del tipo Date con la fecha solicitada
	 * @throws ParseException 
	 */
	public static Date stringToDate(String fecha) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		date = format.parse(fecha);
		return date;
	}

	public static Date stringToDate(String fecha,String format) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat(format);
		Date date = null;
		date = formato.parse(fecha);
		return date;
	}
	
}