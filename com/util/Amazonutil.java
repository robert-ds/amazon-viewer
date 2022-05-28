package com.util;

import java.util.Scanner;

/**<h1>AmazonUtil</h1>
 * Esta Clase permite validar la respuesta del Usuario con respecto al uso del men�
 * <p>
 * 
 * @param Los valores de entrado son con respecto al m�nimo (min) y al m�ximo (max) que dispone el men�. 
 * @author Robert Vasquez
 * @version 1.1
 * @since 2020
 * 
 * */

public class Amazonutil {
	
	public static int validateUserResponseMenu(int min, int max) {
		//Leer Respuesta del Usuario
		Scanner sc = new Scanner(System.in);
		
		//Validar Respuesta
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("NO Ingresaste Una Opci�n Valida");		
			System.out.println("Intenta Otra Vez");		
		}
		
		int response = sc.nextInt();
		
		//Validar Rango de Respuesta
		while(response < min || response > max) {
			//Solicitar de Nuevo la Respuesta 
			System.out.println("No Ingresaste una Opci�n Valida");
			System.out.println("Intenta Otra Vez");
			
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("No Ingresaste Una Opci�n V�lida");
				System.out.println("Intenta Otra Vez");
			}
		}
		
		System.out.println("Tu Respuesta fue: " + response + "\n");
		return response;
	}

}
