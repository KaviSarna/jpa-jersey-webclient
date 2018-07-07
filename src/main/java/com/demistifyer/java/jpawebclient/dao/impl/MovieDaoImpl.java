package com.demistifyer.java.jpawebclient.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demistifyer.java.jpawebclient.dao.MovieDao;
import com.demistifyer.java.jpawebclient.model.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieDaoImpl implements MovieDao {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	protected MovieDaoImpl() {
		super();
	}
	
	public void addAllMovies(List<Movie> movies) {
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			for (Movie movie : movies) {
				
				entityManager.persist(movie);
			}
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMovie(Movie movie) {
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			entityManager.persist(movie);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMovie(Movie movie) {
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			
			entityManager.remove(entityManager.find(Movie.class, movie.getId()));
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Movie getMovieById(String id) {
		
		Movie movie = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			movie = entityManager.find(Movie.class, id);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}

	public Movie getMovieByTitle(String title) {

		Movie movie = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.title = \'" + title+"\'");
			movie = mapper.convertValue(query.getSingleResult(), Movie.class);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByAlbum(String album) {

		List<Movie> movies = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.album = :album");
			query.setParameter("album", album);
			
			movies = (List<Movie>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByYear(String year) {

		List<Movie> movies = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.year = :year");
			query.setParameter("year", year);
			
			movies = (List<Movie>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByRating(String rating) {

		List<Movie> movies = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.rating = :rating");
			query.setParameter("rating", rating);
			
			movies = (List<Movie>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByCast(String cast) {

		List<Movie> movies = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.casts = :cast");
			query.setParameter("cast", cast);
			
			movies = (List<Movie>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByProductionHouse(String productionHouse) {

		List<Movie> movies = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.productionHouse = :productionHouse");
			query.setParameter("productionHouse", productionHouse);
			
			movies = (List<Movie>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovieByGenre(String genre) {

		List<Movie> movies = null;
		
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Movies");
			EntityManager entityManager = emFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			Query query = entityManager.createQuery("select m from Movie m where m.genre = :genre");
			query.setParameter("genre", genre);
			
			movies = (List<Movie>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

}