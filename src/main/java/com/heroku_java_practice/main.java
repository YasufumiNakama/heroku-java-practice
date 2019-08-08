package com.heroku_java_practice;

import java.io.FileNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("webmethods")
public class main {

	@Path("/ramen")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String return_ramen() throws FileNotFoundException {
		ramen status = new ramen();
		Gson gson = new GsonBuilder().serializeNulls().create();
		String output = gson.toJson(status.get_ramen());
		return output;
	}
	
}