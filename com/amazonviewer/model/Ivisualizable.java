package com.amazonviewer.model;

import java.util.Date;

public interface Ivisualizable {
	
	/**
	 * Este M�todo Captura el tiempo exacto de visualizaci�n
	 * 
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @return Devuelve la fecha y hora capturada
	 * 
	 * */
	Date StartToSee(Date dateI);
	
	/**
	 * Este M�todo captura el tiempo exacto de inicio y final de visualizaci�n.
	 * 
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF es un objeto {@code Date} con el tiempo de final exacto.
	 * */
	void StopToSee(Date dateI, Date dateF);
	
	
}
