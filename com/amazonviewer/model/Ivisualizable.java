package com.amazonviewer.model;

import java.util.Date;

public interface Ivisualizable {
	
	/**
	 * Este Método Captura el tiempo exacto de visualización
	 * 
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @return Devuelve la fecha y hora capturada
	 * 
	 * */
	Date StartToSee(Date dateI);
	
	/**
	 * Este Método captura el tiempo exacto de inicio y final de visualización.
	 * 
	 * @param dateI es un objeto {@code Date} con el tiempo de inicio exacto.
	 * @param dateF es un objeto {@code Date} con el tiempo de final exacto.
	 * */
	void StopToSee(Date dateI, Date dateF);
	
	
}
