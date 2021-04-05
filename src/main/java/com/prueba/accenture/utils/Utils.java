package com.prueba.accenture.utils;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
	
	public static final String randomString () {
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    String cadena = "";
	    for (int x = 0; x < 5; x++) {
	        int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
	        char caracterAleatorio = banco.charAt(indiceAleatorio);
	        cadena += caracterAleatorio;
	    }
	    return cadena;
	}
	
	public static int getDifferenceBetwenDates(Date dateInicio, Date dateFinal) {
	    long milliseconds = dateFinal.getTime() - dateInicio.getTime();
	    int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
	    return hours;
	}
	
	public static int numeroAleatorioEnRango(int minimo, int maximo) {
	    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

}
