package com.demistifyer.java.jpawebclient.dao.impl;

import com.demistifyer.java.jpawebclient.dao.MovieDao;

public class DaoFactory {
	
	private static MovieDao movieDao = new MovieDaoImpl();
	
	public static MovieDao getMovieDao() {
		return movieDao;
	}
}