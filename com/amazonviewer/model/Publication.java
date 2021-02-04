package com.amazonviewer.model;

import java.util.Date;

public class Publication {
	
	private String title;
	private Date editionDate;
	private String editorial;
	private String[] authors;
	
	public Publication(String title, Date editionDate, String editorial) {
		super();
		this.title = title;
		this.editionDate = editionDate;
		this.editorial = editorial;
	}
	
	//Getters And Setters
	
	//TITLE
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	//editionDate
	public Date getEditionDate() {
		return editionDate;
	}
	
	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
	
	//EDITORIAL
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	//AUTHORS
	public String[] getAuthors() {
		return authors;
	}
	
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
}
