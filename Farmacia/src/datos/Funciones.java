package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Funciones {

	public static GregorianCalendar traerFecha(String fecha )
	{
		
		String strDia=fecha.substring(0,2);
		String strMes=fecha.substring(3,5);
	    String strAnio=fecha.substring(6,10);
	   
	    
	    int dia=Integer.valueOf(strDia);
	    int mes=Integer.valueOf(strMes)-1;
	    int anio=Integer.valueOf(strAnio);
	 
	    
	    		
		GregorianCalendar f=new GregorianCalendar(anio,mes,dia);
		
		return f;
	}
	
	
public static String traerFechaCorta(GregorianCalendar fecha){
		
		int anio=fecha.get(Calendar.YEAR);
		
		String mes=new String();
		//mes=mes.valueOf((fecha.get(Calendar.MONTH)+1));
		mes=mes.valueOf((fecha.get(Calendar.MONTH)));
		String dia=new String();
		//dia=String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		dia=String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		if(mes.length() == 1){
			mes = "0"+mes;
		}
		
		if(dia.length() == 1){
			dia = "0"+dia;
		}
		
		return dia+"/"+mes+"/"+anio;
	
	}

	public static double aproximar2Decimal(double valor) {
		return Math.rint(valor * 100) / 100;
	}

	

	public static double aproximar1Decimal(double valor) {
		return Math.rint(valor * 10) / 10;
	}


	public static String traerFechaQuery(GregorianCalendar fecha) {
		int anio = fecha.get(Calendar.YEAR);
		String mes = new String();

		mes = mes.valueOf((fecha.get(Calendar.MONTH) + 1));
		String dia = new String();
		dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
		if (mes.length() == 1) {
			mes = "0" + mes;
		}
		if (dia.length() == 1) {
			dia = "0" + dia;
		}
		return "'" + anio + "-" + mes + "-" + dia + "'";
	}
	
	

	public static int diferenciaEntreFechas(GregorianCalendar fecha1, GregorianCalendar fecha2){
		long difms = fecha1.getTimeInMillis() - fecha2.getTimeInMillis();
		long difdLong = difms / (1000 * 60 * 60 * 24);
		int diasInt = (int) difdLong;
		return Math.abs(diasInt);
	}
	
	public static String traerFechaDesdeStringAnglo(String fecha){
		int intDia = 0;
		int intMes = 0;
		int intAnio = 0;
		
		String stringAnio = fecha.substring(0,4);
		String stringMes = fecha.substring(5,7);
		String stringDia = fecha.substring(8,10);
		
		intDia = Integer.parseInt(stringDia);
		intMes = Integer.parseInt(stringMes)-1;
		intAnio = Integer.parseInt(stringAnio);
		
		GregorianCalendar fechaResultado = new GregorianCalendar(intAnio,intMes,intDia);
		
		return Funciones.traerFechaCorta(fechaResultado);
	}
	
	public static GregorianCalendar traerFechaDesdeStringAngloGrego(String fecha){
		int intDia = 0;
		int intMes = 0;
		int intAnio = 0;
		
		String stringAnio = fecha.substring(0,4);
		String stringMes = fecha.substring(5,7);
		String stringDia = fecha.substring(8,10);
		
		intDia = Integer.parseInt(stringDia);
		intMes = Integer.parseInt(stringMes)-1;
		intAnio = Integer.parseInt(stringAnio);
		
		GregorianCalendar fechaResultado = new GregorianCalendar(intAnio,intMes,intDia);
		
		return fechaResultado;
	}

}
