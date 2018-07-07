package com.demistifyer.java.jpawebclient.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	private String id;
	private String title;
	private String album;
	private String year;
	private String casts;
	private String productionHouse;
	private String genre;
	private String rating;
	
	public Movie() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCast() {
		return casts;
	}
	public void setCast(String casts) {
		this.casts = casts;
	}
	public String getProductionHouse() {
		return productionHouse;
	}
	public void setProductionHouse(String productionHouse) {
		this.productionHouse = productionHouse;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		
		String str = "{\"id\":\""+id+"\",\"title\":\""+title+"\",\"album\":\""+album+"\",\"year\":\""+year+
				"\",\"cast\":\""+casts+"\",\"productionHouse\":\""+productionHouse+"\",\"genre\":\""+genre+"\",\"rating\":\""+rating+"\"}";
		
		return str;
	}
}