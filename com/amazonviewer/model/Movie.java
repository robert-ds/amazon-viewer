package com.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import com.amazonviewer.dao.MovieDao;

/**
 * Hereda de {@link Film}
 * Implementa de {@link Ivisualizable} 
 * */

public class Movie extends Film implements Ivisualizable, MovieDao {
	
	private int id;
	private int timeViewed;
	
	public Movie() {
		
	}
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title,genre,creator, duration);
		setYear(year);
	}
	
	//Getters And Setters
	
	//ID
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//TimeViewed
	public int getTimeViewed() {
		return timeViewed;
	}
	
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	//Polimorfismo SobreEscribiendo Métodos
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" +
				"\n Title: " + getTitle() + 
				"\n Genero: " + getGenre() +
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	
	/**
	 * {@inheritDoc}}
	 * */

	@Override
	public Date StartToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}

	/**
	 * {@inheritDoc}}
	 * 
	 * */
	@Override
	public void StopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}
	}
	
	//Método de la Coleccion de Películas
	public static ArrayList<Movie> makeMoviesList(){
		Movie movie = new Movie();
		return movie.read();
	}

	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		
		Date dateI = StartToSee(new Date());
		
		//Simulación de Ver Pelicula
		for (int i = 0; i < 10000; i++) {
			System.out.println("..............");
		}
		
		//Termine de Verla
		StopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Viste: " + toString());
		System.out.println("Por: " + getTimeViewed() + " Milisegundos");
		
	}
		
}

