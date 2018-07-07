package com.demistifyer.java.jpawebclient.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServiceUrl {
	
	Properties properties  = new Properties();
	
	private String add;
	private String getAll;
	private String id;
	private String title;
	private String album;
	private String year;
	private String genre;
	private String cast;
	private String rating;
	private String production;
	private String delete;
	
	public ServiceUrl() {
		
		try {
			properties.load(this.getClass().getResourceAsStream("/urls.properties"));
			
			add = properties.getProperty("add");
			
			getAll = properties.getProperty("getAll");
			id = properties.getProperty("id");
			title = properties.getProperty("title");
			album = properties.getProperty("album");
			year = properties.getProperty("year");
			genre = properties.getProperty("genre");
			cast = properties.getProperty("cast");
			rating = properties.getProperty("rating");
			production = properties.getProperty("production");
			delete = properties.getProperty("delete");
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("Unable to find the properties File");
			fnfe.printStackTrace();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String addUrl() {
		return add;
	}
	
	public String getAllUrl() {
		return getAll;
	}
	
	public String idUrl() {
		return id;
	}
	
	public String titleUrl() {
		return title;
	}
	
	public String albumUrl() {
		return album;
	}
	
	public String yearUrl() {
		return year;
	}
	
	public String genreUrl() {
		return genre;
	}
	
	public String castUrl() {
		return cast;
	}
	
	public String ratingUrl() {
		return rating;
	}
	
	public String productionUrl() {
		return production;
	}
	
	public String deleteUrl() {
		return delete;
	}	
}