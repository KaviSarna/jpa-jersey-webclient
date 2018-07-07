package com.demistifyer.java.jpawebclient.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.demistifyer.java.jpawebclient.model.Movie;
import com.demistifyer.java.jpawebclient.service.MovieServiceClient;
import com.demistifyer.java.jpawebclient.util.ServiceUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MovieServiceClientImpl implements MovieServiceClient {
	
	private ServiceUrl serviceUrls = new ServiceUrl();
	private JSONParser parser = new JSONParser();
	private ObjectMapper mapper = new ObjectMapper();
	
	protected MovieServiceClientImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#addMovie(com.demistifyer.java.jpawebclient.model.Movie)
	 */
	public JSONObject addMovie(Movie movie) {
		
		JSONObject response = null;
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.addUrl());
			
			ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, movie.toString());
			
			response = (JSONObject) parser.parse(clientResponse.getEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getAllMovies()
	 */
	public List<Movie> getAllMovies() {
		
		List<Movie> list = new ArrayList<Movie>();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.getAllUrl());
			
			ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray movies = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));
			
			for (Object obj : movies) {
				
				Movie movie = mapper.convertValue(obj, Movie.class);
				
				list.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByTitle(java.lang.String)
	 */
	public Movie getMovieByTitle(String title) {
		
		Movie movie = null;
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.titleUrl());
			
			ClientResponse clientResponse = webResource.path(title).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONObject response = (JSONObject) parser.parse(clientResponse.getEntity(String.class));
			
			movie = mapper.convertValue(response, Movie.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieById(java.lang.String)
	 */
	public Movie getMovieById(String id) {
		
		Movie movie = null;
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.idUrl());
			
			ClientResponse clientResponse = webResource.path(id).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONObject response = (JSONObject) parser.parse(clientResponse.getEntity(String.class));
			
			movie = mapper.convertValue(response, Movie.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByCast(java.lang.String)
	 */
	public List<Movie> getMovieByCast(String cast) {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.castUrl());
			
			ClientResponse clientResponse = webResource.path(cast).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray response = (JSONArray) parser.parse(clientResponse.getEntity(String.class));
			
			for (Object object : response) {
				Movie movie = mapper.convertValue(object, Movie.class);				
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByGenre(java.lang.String)
	 */
	public List<Movie> getMovieByGenre(String genre) {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.genreUrl());
			
			ClientResponse clientResponse = webResource.path(genre).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray response = (JSONArray) parser.parse(clientResponse.getEntity(String.class));
			
			for (Object object : response) {
				Movie movie = mapper.convertValue(object, Movie.class);
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByYear(java.lang.String)
	 */
	public List<Movie> getMovieByYear(String year) {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.yearUrl());
			
			ClientResponse clientResponse = webResource.path(year).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray response = (JSONArray) parser.parse(clientResponse.getEntity(String.class));
			
			for (Object object : response) {
				Movie movie = mapper.convertValue(object, Movie.class);				
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByRating(java.lang.String)
	 */
	public List<Movie> getMovieByRating(String rating) {
		
		List<Movie> movies = new ArrayList<Movie>();;
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.ratingUrl());
			
			ClientResponse clientResponse = webResource.path(rating).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray response = (JSONArray) parser.parse(clientResponse.getEntity(String.class));
			
			for(Object object : response) {
				Movie movie = mapper.convertValue(object, Movie.class);				
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByAlbum(java.lang.String)
	 */
	public List<Movie> getMovieByAlbum(String album) {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.albumUrl());
			
			ClientResponse clientResponse = webResource.path(album).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray response = (JSONArray) parser.parse(clientResponse.getEntity(String.class));
			
			for (Object object : response) {
				
				//JSONObject json = (JSONObject) object;
		
				Movie movie = mapper.convertValue(object, Movie.class);
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#getMovieByProductionHouse(java.lang.String)
	 */
	public List<Movie> getMovieByProductionHouse(String productionHouse) {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.productionUrl());
			
			ClientResponse clientResponse = webResource.path(productionHouse).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			JSONArray response = (JSONArray) parser.parse(clientResponse.getEntity(String.class));
			
			for (Object object : response) {
				Movie movie = mapper.convertValue(object, Movie.class);
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	/* (non-Javadoc)
	 * @see com.demistifyer.java.jpawebclient.service.MovieServiceClien#deleteMovie(java.lang.String)
	 */
	public JSONObject deleteMovie(String title) {
		
		JSONObject response = null;
		
		try {
			Client client = Client.create();
			
			WebResource webResource = client.resource(serviceUrls.deleteUrl());
			
			ClientResponse clientResponse = webResource.path(title).type(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
			
			response = (JSONObject) parser.parse(clientResponse.getEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}