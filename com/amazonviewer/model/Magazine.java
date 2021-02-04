package com.amazonviewer.model;

import java.util.Date;
import java.util.ArrayList;

public class Magazine extends Publication {
	
	private int id;
	
	
	public Magazine(String title, Date editionDate, String editorial) {
		super(title, editionDate, editorial);
	}
	
	//Getters And Setters
	
	//ID
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailMagazine = "\n :: MAGAZINE ::" +
				"\n Title: " + getTitle() +
				"\n Edition Date: " + getEditionDate() +
				"\n Editorial: " + getEditorial() +
				"\n Authors";
		
		for(int i = 0; i < getAuthors().length; i++) {
			detailMagazine += "\t" + getAuthors()[i] + " ";
		}
		
		return detailMagazine;
	}
	
	public static ArrayList<Magazine> makeMagazineList(){
		ArrayList<Magazine> magazines = new ArrayList<Magazine>();
		
		String[] authors = new String[3];
		
		for (int i = 0; i < 3 ; i++) {
			authors[i] = "Authors" + i;
		}
		
		for(int i = 1; i <= 5 ; i++ ) {
			magazines.add(new Magazine("Magazine ", new Date(), "Editorial" + 1));
		}
		
		return magazines;
	}
	
	
	
	
	
	
	
}
