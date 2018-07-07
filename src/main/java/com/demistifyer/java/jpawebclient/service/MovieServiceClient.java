package com.demistifyer.java.jpawebclient.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.demistifyer.java.jpawebclient.model.Movie;

public interface MovieServiceClient {

	public abstract JSONObject addMovie(Movie movie);

	public abstract List<Movie> getAllMovies();

	public abstract Movie getMovieByTitle(String title);

	public abstract Movie getMovieById(String id);

	public abstract List<Movie> getMovieByCast(String cast);

	public abstract List<Movie> getMovieByGenre(String genre);

	public abstract List<Movie> getMovieByYear(String year);

	public abstract List<Movie> getMovieByRating(String rating);

	public abstract List<Movie> getMovieByAlbum(String album);

	public abstract List<Movie> getMovieByProductionHouse(String productionHouse);

	public abstract JSONObject deleteMovie(String title);

}