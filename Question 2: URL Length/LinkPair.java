package com.rest.url;

import java.util.Random;

public class LinkPair {

	private String longurl;
	private String shorturl;
	
	public LinkPair(String url) {
		this.longurl = url;
		shorturl = generateShortURL();
	}
	
	public String getLongURL() {
		return longurl;
	}
	
	public String getShortURL() {
		return shorturl;
	}
	
	private String generateShortURL() {
		String baselink = "newURL.hi/";
		for (int i = 0; i < 7; i++) {
			Random rand = new Random();
			int random = rand.nextInt(26) + 1;
			if (random < 10) {
				baselink += random;
			} else {
				baselink += Character.toString((char) random*87);
			}
		}
		return baselink;
	}
}
