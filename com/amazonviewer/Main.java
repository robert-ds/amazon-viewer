package com.amazonviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.amazonviewer.model.Book;
import com.amazonviewer.model.Chapter;
import com.amazonviewer.model.Magazine;
import com.amazonviewer.model.Movie;
import com.amazonviewer.model.Serie;
import com.makereport.Report;

import com.util.Amazonutil;

/**
 * <h1>AmazonViewer</h1>
 * Amazonviewer es un programa que permite visualizar Movies, Series con sus respectivos Chapters, 
 * Books y Magazines. Te permite generar reportes generales y con fecha del día
 * <p>
 * Existen algunas reglas como que todos los elementos pueden ser visualizados o leídos a excepción de las 
 * magazines, estás solo pueden ser vistas a modo de exposición sin ser leídas.
 * 
 * @author Robert Vasquez
 * @version 1.1
 * @since 2020
 * 
 * */

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		showMenu();
		
		
	}
	
	//Muestra El Menú Principal de la Applicacción
	public static void showMenu(){
		int exit = 0;
		
		do {
			System.out.println("WELCOME TO AMAZON VIEWER");
			System.err.println("");
			System.out.println("Seleciona el Número de la Opción Deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");			
			System.out.println();	
			
			//lee Respuesta de Usuario
			int response = Amazonutil.validateUserResponseMenu(0, 6);
			/*
			 * Scanner sc = new Scanner(System.in); int response =
			 * Integer.valueOf(sc.nextLine());
			 */
			
			switch(response){
				case 0:
					exit = 0;
				break;
					
				case 1:
					showMovies();
				break;
				
				case 2:
					showSeries();
				break;
				
				case 3:
					showBook();
				break;
				
				case 4:
					showMagazine();
					break;
					
				case 5:
					makereport();
					exit = 1;
					break;
				
				case 6:
					makeReport(new Date());
					exit = 1;
					break;
					
				default:
					System.out.println();
					System.out.println("::::::::... SELECCIONA UNA OPCIÓN...:::::::::");
					System.out.println();
					exit = 1;
				break;
			}
		} while (exit != 0);
	}
	
	//MOVIES
	static ArrayList<Movie> movies = new ArrayList<Movie>();
	public static void showMovies() {
		movies = Movie.makeMoviesList();
		int exit = 1;
		
		do {
			System.out.println("");
			System.out.println(":: MOVIES ::");
			System.out.println("");
			
			for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menú");
			System.out.println();
			
			//Leer Respuesta del Usuario
			int response = Amazonutil.validateUserResponseMenu(0, movies.size());
			
			/*
			 * Scanner sc = new Scanner(System.in); int response =
			 * Integer.valueOf(sc.nextLine());
			 */
			
			if(response == 0) {
				exit = 0;
				showMenu();
				break;
			}
			
			if(response > 0) {
			Movie movieSelected = movies.get(response - 1 );
			movieSelected.view();
			}
			
		}while(exit != 0);
				
	}
	
	//SERIES
	static ArrayList<Serie> serie = Serie.makeSeriesList();
	public static void showSeries() {
		int exit = 1;

		//Accediendo Al Método Estático
		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();
			
			for (int i = 0; i < serie.size(); i++) {
				System.out.println(i+1 + ". " + serie.get(i).getTitle() + " Vista: " + serie.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menú");
			System.out.println();
			
			//Leyendo Respuesta del usuario
			int response = Amazonutil.validateUserResponseMenu(0, serie.size());
			/*
			 * Scanner sc = new Scanner(System.in); int respuesta =
			 * Integer.valueOf(sc.nextLine());
			 */
			
			if (response == 0) {
				exit = 0;
				showMenu();
			}
			
			if (response > 0) {				
				showChapter(serie.get(response - 1).getChapters() );
			}
			
		}while(exit != 0);
	}
	
	//CHAPTERS
	public static void showChapter(ArrayList<Chapter> chaptersOfSerieSelected) {
		int exit = 0;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menú");
			System.out.println("");
			
			//Leer Respuesta del usuario
			int response = Amazonutil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
			/*
			 * Scanner sc = new Scanner(System.in); int respuesta =
			 * Integer.valueOf(sc.nextLine());
			 */
			if (response == 0) {
				exit = 0;
			}
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
				chapterSelected.view();
			}
		}while(exit != 0);
	}

	//BOOKS
	static ArrayList<Book> books = Book.makeBookList();
	public static void showBook() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) {
				System.out.println(i+1 + ". " + books.get(i).getTitle() + "Leido: " + books.get(i).isReaded());
			}
			
			System.out.println("0. Regresar al Menú");
			System.out.println("");
			
			//Leyendo respuesta del usuario
			int response = Amazonutil.validateUserResponseMenu(0, books.size());
			/*
			 * Scanner sc = new Scanner(System.in); int respuesta =
			 * Integer.valueOf(sc.nextLine());
			 */
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
				Book bookSelected = books.get(response - 1);
				bookSelected.view();
			}
			
		}while(exit != 0);
	}
	
	
	//MAGAZINE
	public static void showMagazine() {
		ArrayList<Magazine> magazines = Magazine.makeMagazineList();
		int exit = 0;
		
		do {
			System.out.println();
			System.out.println(":: MAGAZINES ::");
			System.out.println();

			for(int i = 0; i < magazines.size(); i++) {
				System.out.println(i+1 + ". " + magazines.get(i).getTitle());
			}
			
			System.out.println("0. Regresar al Menú");
			System.out.println();
			
			int response = Amazonutil.validateUserResponseMenu(0, 0);
			
			if (response == 0) {
				exit = 0;
				showMenu();
			}
				
		}while(exit != 0);
	}
	
	//Reporte Básico
	public static void makereport() {
		Report report = new Report(); 
		report.setNameFile("SeconsReport");
		report.setTitle(":: Vistos ::");
		report.setExtension("txt");
		String contentReport = "";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movies.toString() + "\n";
			}
		}
		
		for (Serie serie : serie) {
			ArrayList<Chapter> chapters = serie.getChapters();
			
			for (Chapter chapter : chapters) {
				if(chapter.getIsViewed()){
					contentReport += chapter.toString();
				}
			}
		}
		
		for (Book book : books) {
			if (book.getIsReaded()) {
				contentReport += book.toString() + "\n";
			}
		}
		
		report.setContent(contentReport);
		report.makeReport();
		System.out.println("Reporte Generado");
		System.out.println();
		
	}
	
	//Reporte Detallado
	public static void makeReport(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
		String dateString = df.format(date);
		Report report = new Report();
		
		report.setNameFile("SeconsReport" + dateString);
		report.setTitle(":: Vistos ::");
		report.setExtension("txt");
		
		SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
		dateString = dfNameDays.format(date);
		String contentReport = "Date: " + dateString + "\n\n\n";
		
		for (Movie movie : movies) {
			if(movie.getIsViewed()) {
				contentReport += movie.toString() + "\n";
			}
		}
		
		for (Serie serie : serie) {
			ArrayList<Chapter> chapters = serie.getChapters();
			
			for (Chapter chapter : chapters) {
				contentReport += chapter.toString();
			}
		}
		
		for (Book book : books) {
			if(book.getIsReaded()) {
				contentReport += book.toString();
			}
		}
		
		report.setContent(contentReport);
		report.makeReport();
		System.out.println("Reporte Generado");
		System.out.println();
		
	}
}
