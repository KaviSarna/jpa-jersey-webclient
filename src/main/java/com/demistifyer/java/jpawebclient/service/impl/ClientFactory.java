package com.demistifyer.java.jpawebclient.service.impl;

import com.demistifyer.java.jpawebclient.service.MovieServiceClient;

public class ClientFactory {
	
	private static MovieServiceClient movieClient = new MovieServiceClientImpl();
	
	public static MovieServiceClient getMovieClient() {
		return movieClient;
	}
}