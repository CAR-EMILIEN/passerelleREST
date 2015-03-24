package com.example.model;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.net.ftp.*;

public class ClientFTP {
	
	private String username;
	private String pwd;
	private int port;
	private String serveur;
	private final FTPClient ftp = new FTPClient();
	
	public ClientFTP(String username, String pwd, int port, String adresse) throws SocketException, IOException {
		this.username = username;
		this.pwd = pwd;
		this.port = port;
		this.serveur = adresse;
		
		this.connexion();
	}
	
	public void connexion() throws SocketException, IOException {
		 try
	        {
			 
	            int reply;
	            FTPClientConfig config = new FTPClientConfig();
	            this.ftp.configure(config);
	            InetAddress a = InetAddress.getByName(this.serveur);
	            
	            if (port > 0) {
	                this.ftp.connect(a, this.port);
	                this.ftp.login(this.username, this.pwd);
	            } else {
	            	this.ftp.connect(this.serveur);
	            }
	            
	            System.out.println("Connected to " + this.serveur + " on " + (this.port>0 ? this.port : ftp.getDefaultPort()));
	            System.out.print(this.ftp.getReplyString());
	            // After connection attempt, you should check the reply code to verify
	            // success.
	            reply = this.ftp.getReplyCode();

	            if (!FTPReply.isPositiveCompletion(reply))
	            {
	            	this.ftp.disconnect();
	                System.err.println("FTP server refused connection.");
	                System.exit(1);
	            }
	            
	            
	            if (!this.ftp.login(this.username, this.pwd)) this.ftp.logout();
	        }
	        catch (IOException e)
	        {
	            if (this.ftp.isConnected())
	            {
	                try
	                {
	                	this.ftp.disconnect();
	                }
	                catch (IOException f)
	                {
	                    // do nothing
	                }
	            }
	            System.err.println("Could not connect to server.");
	            e.printStackTrace();
	            System.exit(1);
	        }
	}
	
	public String ls(String remote) throws IOException {
		String list = "";
		for (FTPFile f : this.ftp.listFiles(remote)) {
			System.out.println(f.getRawListing());
			System.out.println(f.toFormattedString());
			list += f.toFormattedString() + "\n";
		}	
		return list;
	}
	
	public static void main (String[] args) throws SocketException, IOException {
		ClientFTP client = new ClientFTP ("TOTO", "123", 4000, "localhost");
		System.out.println("COUCOU");
		client.ls(null);
		client.ftp.disconnect();
	}
}
	

