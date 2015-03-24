package com.example.model;


public class Host {

	private String adresse;
	private int port;
	private String name;
	private String pass;
	
	
	public Host(String host)
	{
		String h[] = parseHost(host);
		this.adresse = h[0];
		this.port = Integer.parseInt(h[1]);
		this.name = h[2];
		this.pass = h[3];
	}
	
	public String[] parseHost(String host)
	{
		return host.split(":");
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
