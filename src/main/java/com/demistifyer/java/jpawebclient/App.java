package com.demistifyer.java.jpawebclient;

import java.util.List;

import org.json.simple.JSONObject;

import com.demistifyer.java.jpawebclient.dao.impl.DaoFactory;
import com.demistifyer.java.jpawebclient.model.Movie;
import com.demistifyer.java.jpawebclient.service.impl.ClientFactory;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		Movie movie = new Movie();
		
		movie.setId("10");
		movie.setTitle("Ant Man");
		movie.setAlbum("Marvels");
		movie.setGenre("Action");
		movie.setYear("2017");
		movie.setCast("");
		movie.setProductionHouse("MCU");
		movie.setRating("4");
		
		JSONObject addResponse = ClientFactory.getMovieClient().addMovie(movie);
		
		System.out.println(addResponse.toString());
		
		List<Movie> allMovies = ClientFactory.getMovieClient().getAllMovies();
		
		for(Movie movie1 : allMovies) {
			System.out.println(movie1.toString());
		}
		System.out.println();
		
		DaoFactory.getMovieDao().addAllMovies(allMovies);
		
		Movie titleMovie1 = ClientFactory.getMovieClient().getMovieByTitle("Man of Steel");
		Movie idMovie1 = ClientFactory.getMovieClient().getMovieById("2");
		List<Movie> albumMovies1 = ClientFactory.getMovieClient().getMovieByAlbum("DC");
		List<Movie> castMovies1 = ClientFactory.getMovieClient().getMovieByCast("Gal Gadot");
		List<Movie> genreMovies1 = ClientFactory.getMovieClient().getMovieByGenre("action fiction");
		List<Movie> productionMovies1 = ClientFactory.getMovieClient().getMovieByProductionHouse("Warner Bros.");
		List<Movie> ratingMovies1 = ClientFactory.getMovieClient().getMovieByRating("4");
		List<Movie> yearMovies1 = ClientFactory.getMovieClient().getMovieByYear("2017");
		
		
		Movie titleMovie2 = DaoFactory.getMovieDao().getMovieByTitle("Man of Steel");
		Movie idMovie2 = DaoFactory.getMovieDao().getMovieById("2");
		List<Movie> albumMovies2 = DaoFactory.getMovieDao().getMovieByAlbum("DC");
		List<Movie> castMovies2 = DaoFactory.getMovieDao().getMovieByCast("Gal Gadot");
		List<Movie> genreMovies2 = DaoFactory.getMovieDao().getMovieByGenre("action fiction");
		List<Movie> productionMovies2 = DaoFactory.getMovieDao().getMovieByProductionHouse("Warner Bros.");
		List<Movie> ratingMovies2 = DaoFactory.getMovieDao().getMovieByRating("4");
		List<Movie> yearMovies2 = DaoFactory.getMovieDao().getMovieByYear("2017");
		
		System.out.println("Title 1 - " + titleMovie1.toString());
		System.out.println("Title 2 - " + titleMovie2.toString());
		
		System.out.println();
		
		System.out.println("Id 1 - " + idMovie1);
		System.out.println("Id 2 - " + idMovie2);
		
		System.out.println();
		
		for(Movie album : albumMovies1) {
			System.out.println("AlbumMovie 1 - " + album);			
		}
		for(Movie album : albumMovies2) {
			System.out.println("AlbumMovie 2 - " + album);			
		}
		
		System.out.println();
		
		for(Movie cast : castMovies1) {
			System.out.println("CastMovie 1 - " + cast);			
		}
		for(Movie cast : castMovies2) {
			System.out.println("CastMovie 2 - " + cast);			
		}
		
		System.out.println();
		
		for(Movie genre : genreMovies1) {
			System.out.println("GenreMovie 1 - " + genre);			
		}
		for(Movie genre : genreMovies2) {
			System.out.println("GenreMovie 2 - " + genre);			
		}
		
		System.out.println();
		
		for(Movie production : productionMovies1) {
			System.out.println("ProductionMovie 1 - " + production);			
		}
		for(Movie production : productionMovies2) {
			System.out.println("ProductionMovie 2 - " + production);			
		}
		
		System.out.println();
		
		for(Movie rating : ratingMovies1) {
			System.out.println("RatingMovie 1 - " + rating);			
		}
		for(Movie rating : ratingMovies2) {
			System.out.println("ratingMovie 2 - " + rating);			
		}
		
		System.out.println();
		
		for(Movie year : yearMovies1) {
			System.out.println("yearMovie 1 - " + year);			
		}
		for(Movie year : yearMovies2) {
			System.out.println("yearMovie 2 - " + year);			
		}        
    }
}