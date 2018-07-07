package com.demistifyer.java.jpawebclient.dao;

import java.util.List;

import com.demistifyer.java.jpawebclient.model.Movie;

public interface MovieDao {
	
	public abstract void addAllMovies(List<Movie> movies);
	
	public abstract void addMovie(Movie movie);
	
	public abstract void deleteMovie(Movie movie);
	
	public abstract Movie getMovieById(String id);
	
	public abstract Movie getMovieByTitle(String title);
	
	public abstract List<Movie> getMovieByAlbum(String album);
	
	public abstract List<Movie> getMovieByYear(String year);
	
	public abstract List<Movie> getMovieByRating(String rating);
	
	public abstract List<Movie> getMovieByCast(String cast);
	
	public abstract List<Movie> getMovieByProductionHouse(String productionHouse);
	
	public abstract List<Movie> getMovieByGenre(String genre);
}
