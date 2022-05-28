package com.amazonviewer.model;

import java.util.Date;

import com.util.Amazonutil;

import java.util.ArrayList;

public class Book extends Publication implements Ivisualizable {
	
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private ArrayList<Page> pages;
	
	public Book(String title, Date editionDate, String editorial, String[] authors, ArrayList<Page> page) {
		super(title, editionDate, editorial);
		setAuthors(authors);
		this.pages = page;
	}

	//Getters And Setters
	
	//ID
	public int getId() {
		return id;
	}

	//Isbn
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	//Readed
	public String isReaded() {
		String leido = "";
		if(readed == true ) {
			leido = "S�";
		}else {
			leido = "No";
		}
		return leido;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public boolean getIsReaded() {
		return readed;
	}
	
	//TimeRead
	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String  detailBook = "\n :: BOOK :: " +
				"\n Title: " + getTitle() +
				"\n Edition Date: " + getEditionDate() +
				"\n Editorial: " + getEditorial() +
				"\n Authors: " ;
		
		for(int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i];
		}
		
		return detailBook;
	}
	

	//Polimorfismo / SobreEscribiendo Metodos
	
	@Override
	public Date StartToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void StopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeReaded(0);
		}
		
	}
	
	public void view() {
		setReaded(true);
		Date dateI = StartToSee(new Date());
		
		int i = 0;
		do {
			System.out.println("..................");
			System.out.println("Page " + getPages().get(i).getNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println("..................");
			
			if (i != 0) {
				System.out.println("1. Regresar P�gina");
			}
			
			System.out.println("2. Siguiente P�gina");
			System.out.println("0. Cerrar Libro");
			System.out.println();
			
			int response = Amazonutil.validateUserResponseMenu(0, 2);
			if (response == 2) {
				i++;
			}else if(response == 1) {
				i--;
			}else if(response == 0) {
				break;
			}
			
		} while (i < getPages().size());
		
		//Termine de Leerlo
		StopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Le�ste " + toString());
		System.out.println("Por: " + getTimeReaded() +  " Milisegundos");
	}
	
	public static ArrayList<Book> makeBookList(){
		ArrayList<Book> books = new ArrayList<Book>();
		
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "authors " + i;
		}
		
		ArrayList<Page> pages = new ArrayList<Page>();
		int pagina = 0;
		for (int i = 0; i < 3; i++) {
			pagina = i+1;
			pages.add(new Book.Page(pagina, "El contenido de la p�gina " + pagina));//Instanciaci�n de una clase inner Statica
		}
		
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i,  new Date(), " Editorial " + i,  authors, pages));			
		}
		
		return books;
	}
	
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}


	//Clase Anidada
	public static class Page{
		
		private int id;
		private int number;
		private String content;
		
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		
		
		//Getters and Setters
		//ID
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		//NUMBER
		public int getNumber() {
			return number;
		}
		
		public void setNumber(int number) {
			this.number = number;
		}
		
		//CONTENT
		public String getContent() {
			return content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}
		
		
		
	}
	
	
	
}
