package com.rest.url;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/url")
public class URLAdjustment {
	
	ArrayList<LinkPair> links = new ArrayList<LinkPair>();

	@Path("/:{id}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getLongURL(@PathParam("id") String id) {
		String longurl = "";
		for (int i = 0; i < links.size(); i++) {
			if (links.get(i).getShortURL().equals(id)) {
				longurl = links.get(i).getLongURL();
				break;
			}
		}
		return longurl;
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String createShortURL(String id) {
		links.add(new LinkPair(id));
		return links.get(links.size() - 1).getShortURL();
	}
	
	
}
