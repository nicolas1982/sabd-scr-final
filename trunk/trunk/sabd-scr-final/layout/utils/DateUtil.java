/*
 *******************************************************************************
 **  Archivo    : DateUtils.java
 **  Paquete    : com.pearsongov.ct.commons
 **  Proyecto   : HRRH - Herramienta de Reporte y Registros de Hora
 **  Descripcion: Utilidades para trabajar con fechas
 **  Version    : 1.0
 **  Autor      : German Leotta
 **  Fecha      : 12/09/2005
 *******************************************************************************
 **  Modificaciones/Correcciones
 **               Fecha       Responsable     Comentario
 *******************************************************************************
 */
package layout.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Utilitades de fecha
 * 
 * @author <a mailto:german.leotta@pearson.com>German Leotta</a>
 * @version 1.0
 */
public class DateUtil  {
   
    /**
     * Formato de fecha usado para realizar los formateo y parsing
     * de fechas sin tiempo incluido: {@value}
     */
    public static final String FORMAT_DATE = "dd/MM/yyyy";
    
    /**
     * Formato de fecha usado para realizar los formateo y parsing
     * de fechas con tiempo incluido: {@value}
     */
    public static final String FORMAT_DATE_TIME = "dd/MM/yyyy hh:mm";
    
    public static final String FORMAT_TIME = "HH:mm:ss";
    
    static public final DateFormat formatDate = new SimpleDateFormat(FORMAT_DATE);
    
    public static final DateFormat formatDateTime = new SimpleDateFormat(FORMAT_DATE_TIME);
    
    public static final DateFormat sdfTime =  new SimpleDateFormat(FORMAT_TIME);

    {
        formatDate.setLenient(false);
        formatDateTime.setLenient(false);
    }

    /** 
     * Devuelve la fecha actual del sistema
     *
     * @return la fecha actual  
     */
    public static Date getCurrentDate()  {
        return new Date();
      }

    /** 
     * Convierte la fecha pasada de parametro
     * a un String con formato {@link #FORMAT_DATE}
     *
     * @param date Fecha a formatear
     *
     * @return  un String con la fecha formateada
     */
    public static String formatDate(Date date)  {
        String ret = formatDate.format(date);

        return ret;
      }

    /** 
     * Convierte la fecha y hora pasada de parametro
     * a un String con formato {@link #FORMAT_DATE_TIME}
     *
     * @param dateTime Fecha y hora a formatear
     *
     * @return  un String con la fecha y hora formateada
     */
    public static String formatDateTime(Date dateTime)  {
        String ret = formatDateTime.format(dateTime);

        return ret;
      }

    
    /** 
     * Convierte la fecha pasada de parametro
     * con formato {@link #FORMAT_DATE} a Date
     *
     * @param sdate Fecha formateada a convertir
     *
     * @return Date con la fecha
     */
    public static Date parseDate(String sdate)  throws ParseException{
        Date ret;
        ret = formatDate.parse(sdate);
        return ret;
      }

    /** 
     * Convierte la fecha y hora pasada de parametro
     * con formato {@link #FORMAT_DATE_TIME} a Date
     *
     * @param sdate Fecha y hira formateada a convertir
     *
     * @return Date con la fecha y hora
     */
    public static Date parseDateTime(String sdate) throws ParseException {
        Date ret;
        ret = formatDateTime.parse(sdate);
        return ret;
      }

    /** 
     *  Extrae o reseta a 0 el tiempo adjunto a la fecha,
     *  por ej la fecha "14/05/2005 07:45:28.345" la convierte
     *  a "14/05/2005 00:00:00.0"
     *
     * @param dateTime Fecha a extraer el tiempo
     *
     * @return  fecha con el tiempo asociado a 0
     */
    public static Date excludeTime(Date dateTime) throws ParseException {
        String sdate = formatDate(dateTime);
        Date ret = parseDate(sdate);
        return ret;
      }

    /** 
     * Indica si dos fechas estan en la misma semana tomando como dia
     * de inicio de la semana el dia Lunes
     *
     * @param fecha Fecha 1
     * @param today Fecha 2
     *
     * @return true si las dos fechas estan en la misma semana, false en caso contrario
     */
    public static boolean mismaSemana(Date fecha, Date today)  {
        Date firstDate = (fecha.before(today)) ? fecha : today;
        Date lastDate = (!fecha.before(today)) ? fecha : today;
        GregorianCalendar cFirstDate = (GregorianCalendar) Calendar.getInstance();
        cFirstDate.setTime(firstDate);
        cFirstDate.setFirstDayOfWeek(GregorianCalendar.MONDAY);

        GregorianCalendar cLastDate = (GregorianCalendar) Calendar.getInstance();
        cLastDate.setTime(lastDate);
        cLastDate.setFirstDayOfWeek(GregorianCalendar.MONDAY);

        if ((cLastDate.get(GregorianCalendar.WEEK_OF_YEAR) == cFirstDate.get(GregorianCalendar.WEEK_OF_YEAR))&&
        		cFirstDate.get(GregorianCalendar.YEAR)==cLastDate.get(GregorianCalendar.YEAR))  {
            return true;
          }

        if (cFirstDate.get(GregorianCalendar.YEAR) == (cLastDate.get(GregorianCalendar.YEAR)
            - 1))  {
            int maxMonth = cFirstDate.getMaximum(GregorianCalendar.WEEK_OF_YEAR);
            int minMonth = cLastDate.getMinimum(GregorianCalendar.WEEK_OF_YEAR);

            if ((cFirstDate.get(GregorianCalendar.WEEK_OF_YEAR) == maxMonth)
                && (cLastDate.get(GregorianCalendar.WEEK_OF_YEAR) == minMonth))  {
                return true;
              }
          }

        return false;
      }

    /** 
     * Dada una fecha y una cantidad de dias, suma la cantidad
     * de dias a la fecha y devuelve la fecha resultante.
     * Si la cantidad es negativa entonces los dias se restan
     *
     * @param date fecha a la cual se le quieren sumar los dias
     * @param cantDias Cantidad de dias a sumar o restar 
     *
     * @return  Date fecha resultante
     */
    public static Date getNextDate(Date date, int cantDias)  {
        long oneDay = 86400000;
        long thisDate = date.getTime();

        return new Date(thisDate + (oneDay * cantDias));
      }
    
    /**
     * Devuelve la fecha mas temprana entre las dos pasadas como parametro
     * 
     * @param d1 Fecha 1 a comparar
     * @param d2 Fecha 2 a comparar
     * 
     * @return un Date con la fecha mas tempara
     */
    public static Date getEarlestDate(Date d1, Date d2) {
        if ((d1==null)&&(d2==null))
            return null;
        else if (d1==null)
            return d2;
        else if (d2==null)
            return d1;
        else if (d1.before(d2))
            return d1;
        else
            return d2;
    }
    
    
    /**
     * Devuelve la fecha mas tardia entre las dos pasadas como parametro
     * 
     * @param d1 Fecha 1 a comparar
     * @param d2 Fecha 2 a comparar
     * 
     * @return un Date con la fecha mas tardia
     */
    public static Date getLatestDate(Date d1, Date d2) {
        if ((d1==null)&&(d2==null))
            return null;
        else if (d1==null)
            return d2;
        else if (d2==null)
            return d1;
        else if (d1.after(d2))
            return d1;
        else
            return d2;
        
    }
    
    public static Date getFirstDayOfPreviousMonth(Date today) throws ParseException {
        return getFirstDayOfMonth(today, -1);
    }
    
    public static Date getLastDayOfPreviousMonth(Date today) throws ParseException {
        return getLastDayOfMonth(today, -1);
    }
    
    public static Date getFirstDayOfMonth(Date today) throws ParseException {
        return getFirstDayOfMonth(today, 0);
    }
    
    public static Date getLastDayOfMonth(Date today) throws ParseException {
        return getLastDayOfMonth(today, 0);
    }
    
    public static Date getFirstDayOfMonth(Date today, int mesesRelativos) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
//      me muevo tantos meses
        c.add(Calendar.MONTH, mesesRelativos);
        
        Calendar ret = Calendar.getInstance();
        ret.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));
        ret.set(Calendar.MONTH, c.get(Calendar.MONTH));
        ret.set(Calendar.YEAR, c.get(Calendar.YEAR));
        
        return excludeTime(ret.getTime());
    }
    
    public static Date getLastDayOfMonth(Date today, int mesesRelativos) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        //me muevo tantos meses
        c.add(Calendar.MONTH, mesesRelativos);
        
        Calendar ret = Calendar.getInstance();
        ret.set(Calendar.DAY_OF_MONTH, c.getMaximum(Calendar.DAY_OF_MONTH));
        ret.set(Calendar.MONTH, c.get(Calendar.MONTH));
        ret.set(Calendar.YEAR, c.get(Calendar.YEAR));
        
        return excludeTime(ret.getTime());
    }
    
    /**
     * Devuelve la cantidad de diferencias en meses entre lastDate y
     * firstDate. Si el valor es 0, significa que estan dentro de los 
     * primeros 30 dias, 1, entre 30 y 60, 3 entre 60 y 90, etc. 
     * Si firstDate es posterior a lastDate devuelve 0
     * @param lastDate
     * @param firstDate
     * @return
     */
    public static int getMonthsDifferences(Date lastDate, Date firstDate) {
    	if (firstDate.after(lastDate))
    		return 0;
    	Calendar cFirstDate = Calendar.getInstance();
    	Calendar cLastDate = Calendar.getInstance();
    	cFirstDate.setTime(firstDate);
    	cLastDate.setTime(lastDate);
    	int difYears = cLastDate.get(Calendar.YEAR) - cFirstDate.get(Calendar.YEAR);
   		int difMonths = (cLastDate.get(Calendar.MONTH)+(12*difYears)) - cFirstDate.get(Calendar.MONTH);
   		int varMonths = 1;
   		if (cLastDate.get(Calendar.DAY_OF_MONTH)>=cFirstDate.get(Calendar.DAY_OF_MONTH)) {
    			varMonths = 0;
   		}
   		return (difMonths - varMonths);
   		
    }
    
    /**
     * Devuelve la cantidad de diferencias en dias entre lastDate y
     * firstDate. Si firstDate es posterior a lastDate devuelve la diferencia
     * en dias como un nro negativo
     * @param lastDate
     * @param firstDate
     * @return
     */
    public static int getDaysDifferences(Date lastDate, Date firstDate) {

    	long lastDateInMillisec = lastDate.getTime();
    	long firstDateInMillisec = firstDate.getTime();
    	long onDayInMillisec = 24 * 60 * 60 * 1000;
    	
    	return ((int)((lastDateInMillisec - firstDateInMillisec) / onDayInMillisec));
    }
    
    public static String getLocalFormatDate(Date date, Locale locale) {
    	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd/MM/yyyy H:mm", locale);
		String fecha = sdf.format(date);
		String fechaU = fecha.substring(0,1).toUpperCase()+fecha.substring(1);
		return fechaU;
    }
    
    public static String getLocalFormatDate(Locale locale) {
		return getLocalFormatDate(getCurrentDate(),locale);
    }

    public static int getJulianDay(Date today) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        return Calendar.DAY_OF_YEAR;

    
    }
    
    public static int getYear(Date today) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        return Calendar.YEAR;

    }
    
//    public static Date getLastDayOfMonth(Date today) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(today);
//        Calendar ret = Calendar.getInstance();
//        ret.set(Calendar.DAY_OF_MONTH, c.getMaximum(Calendar.DAY_OF_MONTH));
//        ret.set(Calendar.MONTH, c.get(Calendar.MONTH));
//        ret.set(Calendar.YEAR, c.get(Calendar.YEAR));
//        return ret.getTime();
//    }
//    
//    public static Date getFirstDayMonth(Date today) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(today);
//        Calendar ret = Calendar.getInstance();
//        ret.set(Calendar.DAY_OF_MONTH, c.getMinimum(Calendar.DAY_OF_MONTH));
//        ret.set(Calendar.MONTH, c.get(Calendar.MONTH));
//        ret.set(Calendar.YEAR, c.get(Calendar.YEAR));
//        
//        return ret.getTime();
//    }
    
    
  }
