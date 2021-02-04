package com.amazonviewer.model;

import java.util.ArrayList;

/**
 * Herada {@link Movie}
 * @see Film
 * */

public class Chapter extends Movie{

	private int id;
	private int sessionNumber;
	private Serie serie;
	
	public Chapter(String title,String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator,duration,year);
		this.sessionNumber = sessionNumber;
		this.setSerie(serie);
	}

	//Getters And Setters
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	//SessionNumber
	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n :: SERIE :: " +
				"\n Title: " + getSerie().getTitle() +
				"\n :: CHAPTER ::" +
				"\n Title" + getTitle() +
				"\n Year: " + getYear() +
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
	
	public static ArrayList<Chapter> makeChapterList(Serie serie){
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		
		for (int i = 1; i <= 5 ; i++) {
			chapters.add(new Chapter("Cap�tulo: " + i, "Genero: " + i, "Creator: " + i, 45, (short)(2017+i), i, serie));
		}
		
		return chapters;
	}
	
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		
		ArrayList<Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if(chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		
		if(chapterViewedCounter == chapters.size()) {
			getSerie().view();
		}
		
	}
	
	
}
