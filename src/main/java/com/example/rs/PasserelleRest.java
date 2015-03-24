package com.example.rs;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.services.Passerelle;


@Path( "/p" )
public class PasserelleRest {

	@Inject private Passerelle passerelle = new Passerelle();
	
	//@Produces ( "application/octet-stream")
	@GET
	@Produces("text/html")
	public String getLs()
	{
		String ls = passerelle.ls();
		return ls;
	}
	
	@GET
	@Path("/{hostFTP}/{cmd}")
	public String command(@PathParam("hostFTP") String host, @PathParam("cmd") String cmd)
	{
		return passerelle.parseCommand(host,cmd);
		
		
	}
}
