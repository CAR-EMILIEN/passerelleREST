package com.example.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.services.Passerelle;


@Path( "/passerelle" )
public class PasserelleRest {

	@Inject private Passerelle passerelle;
	
	@Produces ( "application/octet-stream")
	@GET
	public truc getLs()
	{
		return passerelle.ls();
	}
	
	
}
